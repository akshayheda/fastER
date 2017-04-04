package healthcare;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "emergencies")
public class Emergency implements Comparable<Emergency> {
    @JsonProperty("id")
    private String Id;

    @JsonProperty("injury_type")
    private String InjuryType;

    @JsonProperty("latitude")
    private float Latitutde;

    @JsonProperty("longitude")
    private float Longitude;

    @JsonProperty("severity")
    private float Severity;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getInjuryType() {
        return InjuryType;
    }

    public void setInjuryType(String injuryType) {
        InjuryType = injuryType;
    }

    public float getLatitutde() {
        return Latitutde;
    }

    public void setLatitutde(float latitutde) {
        Latitutde = latitutde;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float longitude) {
        Longitude = longitude;
    }

    public float getSeverity() {
        return Severity;
    }

    public void setSeverity(float severity) {
        Severity = severity;
    }

    @Override
    public int compareTo(Emergency o) {
        return (int) (getSeverity() - o.getSeverity());
    }
}
