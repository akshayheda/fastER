import authentication.AuthenticationService;
import authentication.PasswordHasher;
import authentication.User;
import org.hibernate.Session;
import org.json.JSONObject;
import org.slf4j.Logger;
import spark.Request;
import spark.Response;
import spark.servlet.SparkApplication;

import java.security.SecureRandom;

import static spark.Spark.*;

public class AuthenticationController implements SparkApplication {
    private PasswordHasher hasher;
    private Logger logger;

    public AuthenticationController(PasswordHasher hasher, Logger logger) {
        this.hasher = hasher;
        this.logger = logger;
    }

    private String register(Request req, Response res) {
        Session s = Main.SessionFactory.openSession();
        AuthenticationService service = new AuthenticationService(s);
        JSONObject object = new JSONObject(req.body());
        User user = new User();


        logger.info("Received request to register: " + req.body());

        String firstName;
        if (object.isNull("first_name") || (firstName = object.getString("first_name")) == null)
            return "first_name";
        user.setFirstName(firstName);
        String middleName;
        if (object.isNull("middle_name") || (middleName = object.getString("middle_name")) == null)
            return "middle_name";
        user.setMiddleName(middleName);
        String lastName;
        if (object.isNull("last_name") || (lastName = object.getString("last_name")) == null)
            return "last_name";
        user.setLastName(lastName);
        String title;
        if (object.isNull("title") || (title = object.getString("title")) == null)
            return "title";
        user.setTitle(title);
        String email;
        if (object.isNull("email") || (email = object.getString("title")) == null)
            return "email";
        user.setEmail(email);
        if (object.isNull("address"))
            return "address";
        user.setAddress(object.getString("address"));
        String username;
        if (object.isNull("username") || (username = object.getString("username")) == null)
            return "username";
        user.setUserName(username);

        if (service.getId(username) != null)
            return "exists";

        SecureRandom random = new SecureRandom();
        byte[] salt = random.generateSeed(256);
        user.setPasswordSalt(salt);
        user.setPasswordHash(hasher.Hash(object.getString("password"), salt));
        String uuid = service.register(user);

        if (uuid == null)
            return "fail";
        return "success";
    }

    private String login(Request req, Response res) {
        JSONObject object = new JSONObject(req.body());
        String username = object.getString("username");
        String password = object.getString("password");

        if (username == null)
            return "username";

        if (password == null)
            return "password";

        AuthenticationService service = new AuthenticationService(Main.SessionFactory.openSession());
        byte[] salt = service.getSalt(username);
        String uuid = service.login(username, hasher.Hash(password, salt));
        if (uuid == null)
            return "failure";
        return uuid;
    }

    // TODO: implement an email verification system
    private boolean verify(Request req, Response res) {
        return true;
    }

    @Override
    public void init() {
        path("/auth", () -> {
            post("/register", this::register);

            post("/login", this::login);

            post("/verify", this::verify);
        });
    }
}
