import authentication.AuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import healthcare.Hospital;
import healthcare.HospitalService;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import spark.servlet.SparkApplication;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;

import static spark.Spark.*;

/**
 * Created by inkys_000 on 3/26/2017.
 */
public class HospitalController implements SparkApplication {
    @Override
    public void init() {
        path("/hospital", () -> {
            /**before((req, res) -> {
                String auth = req.headers("Authorization");
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
                req.attribute("UserName", decodedComponents[0]);
            });**/

            post("/query", (req, res) -> {
                JSONObject obj = new JSONObject(req.body());
                if (obj.isNull("latitude"))
                    return null;
                BigDecimal lat = obj.getBigDecimal("latitude");
                if (lat == null)
                    return null;
                BigDecimal lon = obj.getBigDecimal("longitude");
                if (lon == null)
                    return null;
                BigDecimal radius = obj.getBigDecimal("radius");
                if (radius == null)
                    return null;

                HospitalService service = new HospitalService(Main.SessionFactory.openSession(),
                        LoggerFactory.getLogger("Hospital"));
                ObjectMapper mapper = new ObjectMapper();
                StringWriter writer = new StringWriter();
                List<Hospital> hospitalList = service.findWithinRadius(lat.floatValue(), lon.floatValue(), radius.intValue());
                mapper.writeValue(writer, hospitalList.subList(0, 5));
                return writer.toString();
            });
        });
    }
}
