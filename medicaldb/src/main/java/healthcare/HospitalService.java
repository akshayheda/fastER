package healthcare;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class HospitalService {
    Session session;
    Logger logger;

    public HospitalService(Session s, Logger logger) {
        session = s;
        this.logger = logger;
    }

    public List<Hospital> findWithinRadius(float lat, float lon, int km) {
        try {
            Query query = session.createQuery("select c from Hospital c where dwithin(c.Location, :geometry, :distance) = true",
                    Hospital.class);

            WKTReader reader = new WKTReader();
            Geometry geo = reader.read("POINT(" + lat + " " + lon + ")");
            query.setParameter("geometry", geo);
            query.setParameter("distance", km * 0.09);
            return new ArrayList<Hospital>(query.list());
        }
        catch (ParseException e) {
            System.out.println("Failed to calculate point?");
            return null;
        }
    }

    public void addHospital(Hospital hospital) {
        Transaction t = session.beginTransaction();
        session.persist(hospital);
        t.commit();
    }

    public List<HealthInformation> getHospitalInformation(String username) {
        return null;
    }
}
