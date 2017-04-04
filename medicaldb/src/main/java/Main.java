import authentication.PasswordHasher;
import authentication.PkdfHasher;
import authentication.Token;
import authentication.User;
import healthcare.Hospital;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static spark.Spark.*;

/**
 * Created by inkys_000 on 3/25/2017.
 */
public class Main {
    public static SessionFactory SessionFactory;

    public static void main(String[] args)throws Exception {
        String url = System.getenv("JDBC_DATABASE_URL") == null ?
                "jdbc:postgresql://localhost:5432/healthcare" :
                System.getenv("JDBC_DATABASE_URL");

        Configuration config = new Configuration()
                .configure()
                .setProperty("connection.url", url)
                .setProperty("hibernate.connection.url", url)
                .addAnnotatedClass(Token.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Hospital.class);

        ServiceRegistry builder = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();

        SessionFactory = config.buildSessionFactory(builder);
        PasswordHasher hasher = new PkdfHasher();
        String port = System.getenv("PORT") == null ? "8080" : System.getenv("PORT");
        port(Integer.parseInt(port));
        AuthenticationController authController = new AuthenticationController(hasher, LoggerFactory.getLogger("[Authentication]"));
        post("/test", (req, res) -> "main");
        get("/test", (req, res) -> "Test");
        authController.init();
        HealthcareController healthcareController = new HealthcareController();
        healthcareController.init();
        HospitalController hospitalController = new HospitalController();
        hospitalController.init();
    }
}
