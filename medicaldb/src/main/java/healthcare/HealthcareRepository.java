package healthcare;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;
import org.slf4j.Logger;

/**
 * Created by inkys_000 on 3/26/2017.
 */
public class HealthcareRepository extends CouchDbRepositorySupport<HealthInformation> {
    private Logger _logger;

    public HealthcareRepository(CouchDbConnector connector, Logger logger) {
        super(HealthInformation.class, connector);
        _logger = logger;
    }
}
