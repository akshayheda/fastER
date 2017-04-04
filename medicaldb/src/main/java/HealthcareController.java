import authentication.AuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import healthcare.HealthInformation;
import healthcare.HealthcareRepository;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.json.JSONObject;
import spark.Request;
import spark.Response;
import spark.servlet.SparkApplication;

import java.io.IOException;
import java.util.Base64;

import static spark.Spark.*;

public class HealthcareController implements SparkApplication {

    private boolean update(Request req, Response res) throws IOException {
        AuthenticationService service = new AuthenticationService(Main.SessionFactory.openSession());
        JSONObject object = new JSONObject(req.body());
        String id = service.getId(req.attribute("UserName"));
        if (id == null)
            return false;
        ObjectMapper mapper = new ObjectMapper();
        HealthInformation information = mapper.readValue(req.body(), HealthInformation.class);

        HealthcareRepository repo = req.attribute("healthRepository");
        HealthInformation currentInfo = repo.get(id);
        if (currentInfo == null) {
            repo.add(information);
            return true;
        }
        information.setId(id);
        repo.update(information);
        return true;
    }

    private boolean addRegional(Request req, Response res) {
        return true;
    }

    public void init() {
        path("/healthcare", () -> {
            before((request, response) -> {
                String auth = request.headers("Authorization");
                if (auth.length() > 500)
                    halt(401, "Really?");
                String[] components = auth.split("\\s");
                if (components.length != 2 || components[0].toLowerCase() != "basic"){
                    halt(401, "Improper authorization");
                    return;
                }
                String decoded = new String(Base64.getDecoder().decode(components[1]));
                String[] decodedComponents = decoded.split(":");
                if (decodedComponents.length != 2) {
                    halt(401, "Improper authorization format");
                    return;
                }
                AuthenticationService service = new AuthenticationService(Main.SessionFactory.openSession());
                if (!service.verifyLogin(components[0], components[1]))
                    halt(401, "Improper token");
                request.attribute("UserName", decodedComponents[0]);
            });

            // Add services and repositories
            before((request, response) -> {
                HttpClient client = new StdHttpClient
                        .Builder()
                        .url("https://7d6ab3fe-06aa-4ddc-9f7b-f6f6cbf9c07d-bluemix.cloudant.com")
                        .enableSSL(true)
                        .username("user_name")
                        .password("password")
                        .build();

                CouchDbInstance instance = new StdCouchDbInstance(client);
                CouchDbConnector connector = new StdCouchDbConnector("health", instance);

                request.attribute("healthRepository", connector);
            });

            post("/update", this::update);
            post("/addRegional", this::addRegional);
        });
    }
}
