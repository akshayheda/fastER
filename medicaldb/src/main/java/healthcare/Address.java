package healthcare;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by inkys_000 on 3/26/2017.
 */
public class Address {
    @JsonProperty("address")
    private String Address;

    @JsonProperty("city")
    private String City;

    @JsonProperty("postal_code")
    private String PostalCode;

    @JsonProperty("apartment")
    private String ApartmentNumber;

    @JsonProperty("state")
    private String State;
}
