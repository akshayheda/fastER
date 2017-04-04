import spark.Request;
import spark.Response;
import spark.servlet.SparkApplication;

/**
 * Created by inkys_000 on 3/26/2017.
 */
public class EmergencyController implements SparkApplication {

    private boolean addEmergency(Request req, Response res) {
        return true;
    }

    private boolean removeEmergency(Request req, Response res) {
        return true;
    }

    public void init() {

    }
}
