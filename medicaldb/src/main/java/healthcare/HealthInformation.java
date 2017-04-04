package healthcare;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"id", "revision"})
public class HealthInformation {
    @JsonProperty("_id")
    private String id;

    @JsonProperty("_rev")
    private String revision;

    @JsonProperty("first_name")
    private String FirstName;

    @JsonProperty("last_name")
    private String LastName;

    @JsonProperty("middle_name")
    private String MiddleName;

    @JsonProperty("phone_number")
    private String PhoneNumber;

    @JsonProperty("email")
    private String Email;

    @JsonProperty("social_security_id")
    private String SocialSecurityId;

    @JsonProperty("date_of_birth")
    private Date DateOfBirth;

    @JsonProperty("gender")
    private String Gender;

    @JsonProperty("ethnicity")
    private String Ethnicity;

    @JsonProperty("address")
    private Address Address;

    @JsonProperty("alternative_contacts")
    private List<Contact> AlternativeContacts;

    @JsonProperty("known_conditions")
    private List<String> KnownConditions;

    @JsonProperty("surgeries")
    private List<Surgery> Surgeries;

    @JsonProperty("insurances")
    private List<Insurance> Insurances;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSocialSecurityId() {
        return SocialSecurityId;
    }

    public void setSocialSecurityId(String socialSecurityId) {
        SocialSecurityId = socialSecurityId;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEthnicity() {
        return Ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        Ethnicity = ethnicity;
    }

    public healthcare.Address getAddress() {
        return Address;
    }

    public void setAddress(healthcare.Address address) {
        Address = address;
    }

    public List<String> getKnownConditions() {
        return KnownConditions;
    }

    public void setKnownConditions(List<String> knownConditions) {
        KnownConditions = knownConditions;
    }

    public List<Contact> getAlternativeContacts() {
        return AlternativeContacts;
    }

    public void setAlternativeContacts(List<Contact> alternativeContacts) {
        AlternativeContacts = alternativeContacts;
    }

    public List<Surgery> getSurgeries() {
        return Surgeries;
    }

    public void setSurgeries(List<Surgery> surgeries) {
        Surgeries = surgeries;
    }

    public List<Insurance> getInsurances() {
        return Insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        Insurances = insurances;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }
}
