import healthcare.Address;
import healthcare.HealthInformation;
import healthcare.HealthcareRepository;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Scanner;

public class HealthcareRepositoryTest {
    HealthcareRepository repository;

    @Before
    public void Initialize() throws Throwable {
        HttpClient client = new StdHttpClient
                .Builder()
                .url("https://7d6ab3fe-06aa-4ddc-9f7b-f6f6cbf9c07d-bluemix.cloudant.com")
                .enableSSL(true)
                .username("user_name")
                .password("password")
                .build();

        CouchDbInstance instance = new StdCouchDbInstance(client);
        CouchDbConnector connector = new StdCouchDbConnector("health", instance);

        repository = new HealthcareRepository(connector, LoggerFactory.getLogger("TestLogger"));
    }

    @Test
    public void AddDocument() {
        HealthInformation info = new HealthInformation();
        info.setId("randomid");
        info.setEmail("RANDOM_EMAIL");
        repository.add(info);
    }
}
