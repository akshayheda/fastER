package healthcare;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by inkys_000 on 3/26/2017.
 */
public class Surgery {
    @JsonProperty("surgery")
    private String Surgery;

    @JsonProperty("location")
    private Address Location;
}
