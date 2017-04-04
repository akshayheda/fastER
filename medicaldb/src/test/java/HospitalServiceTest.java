import authentication.Token;
import authentication.User;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import healthcare.Hospital;
import healthcare.HospitalService;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class HospitalServiceTest {
    SessionFactory SessionFactory;
    @Before
    public void CreateSession() throws Exception {

        Configuration config = new Configuration()
                .configure()
                .setProperty("connection.url", "jdbc:postgresql://localhost:5432/healthcare")
                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/healthcare")
                .addAnnotatedClass(Token.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Hospital.class);

        ServiceRegistry builder = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();

        SessionFactory = config.buildSessionFactory(builder);

        if (false) {
            BufferedReader reader = new BufferedReader(new FileReader("data.csv"));
            reader.readLine();
            Scanner sc = new Scanner(reader);
            sc.useDelimiter("(?!\\B\"[^\"]*),(?![^\"]*\"\\B)|\r\n");
            int counter = 0;
            while(sc.hasNext()) {
                sc.next(); //ignore this value, not relevant
                String ID = sc.next();
                String hospitalName = sc.next();
                String address = sc.next();
                String address_2 = sc.next();
                String city = sc.next();
                String state = sc.next();
                int zip = sc.nextInt();
                String telephone = sc.next();
                String type = sc.next();
                int population = sc.nextInt();
                String county = sc.next();
                String cFLIP = sc.next();
                String country = sc.next();
                float latitude = sc.nextFloat();
                float longitude = sc.nextFloat();
                int naicsCode = sc.nextInt();
                String naicsDescription = sc.next();
                String source = sc.next();
                String website = sc.next();
                String stateID = sc.next();
                String altName = sc.next();
                String stateFIPS = sc.next();
                String owner = sc.next();
                int beds = sc.nextInt();
                String trauma = sc.next();
                String helipad = sc.next();
                String dateCreated = sc.next();
                Hospital h = new Hospital();
                h.setId(UUID.randomUUID().toString());
                h.setHospitalId(ID);
                h.setHospitalName(hospitalName);
                try {
                    WKTReader wktreader = new WKTReader();
                    Geometry geometry = wktreader.read("POINT(" + latitude + " " + longitude+ ")");
                    h.setLocation(geometry);
                }
                catch (ParseException e) {
                    System.out.println("ERROR");
                    continue;
                }
                h.setLatitude(latitude);
                h.setLongitude(longitude);
                h.setPhoneNumber(telephone);
                h.setPostalCode(zip);
                h.setTraumaAvailable(Boolean.parseBoolean(trauma));
                h.setAddress(address);
                h.setCity(city);
                h.setState(state);
                h.setAlternateAddress(address_2);
                h.setWebsite(website);
                HospitalService service = new HospitalService(SessionFactory.openSession(), LoggerFactory.getLogger("hello"));
                service.addHospital(h);
                System.out.println(counter);
                counter++;

            }
        }
    }
    @Test
    public void TestRange() {
        HospitalService service = new HospitalService(SessionFactory.openSession(),
                LoggerFactory.getLogger("TestLogger"));
        List<Hospital> hospitalList = service.findWithinRadius(42.4605f, -71.0609f, 100);
        System.out.println(hospitalList.size());
        hospitalList.forEach(f -> System.out.println(f.getHospitalId()));
    }
}
