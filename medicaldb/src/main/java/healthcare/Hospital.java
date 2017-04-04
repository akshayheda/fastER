package healthcare;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "hospitals")
@JsonIgnoreProperties({"location"})
public class Hospital {

    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private String Id;

    @Column(name = "hospital_name")
    @JsonProperty("hospital_name")
    private String HospitalName;

    @Column(name = "hospital_id")
    @JsonProperty("hospital_id")
    private String HospitalId;

    @Column(name = "is_online")
    @JsonProperty("is_online")
    private boolean IsOnline;

    @Column(name = "postal")
    @JsonProperty("postal")
    private int PostalCode;

    @Column(name = "latitude")
    @JsonProperty("latitude")
    private float Latitude;

    @Column(name = "longitude")
    @JsonProperty("longitude")
    private float Longitude;

    @Column(name = "median_time")
    @JsonProperty("median_time")
    private int MedianTime;

    @Column(name = "location")
    @JsonIgnore
    private Geometry Location;

    @Column(name = "phone_number")
    @JsonProperty("phone_number")
    private String PhoneNumber;

    @Column(name = "trauma")
    @JsonProperty("trauma")
    private boolean TraumaAvailable;

    @Column(name = "address")
    @JsonProperty("address")
    private String Address;

    @Column(name = "city")
    @JsonProperty("city")
    private String City;

    @Column(name = "state")
    @JsonProperty("state")
    private String State;

    @Column(name = "website")
    @JsonProperty("website")
    private String Website;

    @Column(name = "alternate_address")
    @JsonProperty("alternate_address")
    private String AlternateAddress;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getHospitalName() {
        return HospitalName;
    }

    public void setHospitalName(String hospitalName) {
        HospitalName = hospitalName;
    }

    public boolean isOnline() {
        return IsOnline;
    }

    public void setOnline(boolean online) {
        IsOnline = online;
    }

    public String getHospitalId() {
        return HospitalId;
    }

    public void setHospitalId(String hospitalId) {
        HospitalId = hospitalId;
    }

    public int getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(int postalCode) {
        PostalCode = postalCode;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float longitude) {
        Longitude = longitude;
    }

    public int getMedianTime() {
        return MedianTime;
    }

    public void setMedianTime(int medianTime) {
        MedianTime = medianTime;
    }

    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float latitude) {
        Latitude = latitude;
    }

    public Geometry getLocation() {
        return Location;
    }

    public void setLocation(Geometry location) {
        Location = location;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public boolean isTraumaAvailable() {
        return TraumaAvailable;
    }

    public void setTraumaAvailable(boolean traumaAvailable) {
        TraumaAvailable = traumaAvailable;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getAlternateAddress() {
        return AlternateAddress;
    }

    public void setAlternateAddress(String alternateAddress) {
        AlternateAddress = alternateAddress;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }
}
