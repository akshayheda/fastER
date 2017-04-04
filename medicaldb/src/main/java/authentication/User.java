package authentication;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by inkys_000 on 3/25/2017.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private String Id;

    @Column(name = "hash", nullable = false)
    private byte[] PasswordHash;

    @Column(name = "salt", nullable = false)
    private byte[] PasswordSalt;

    @Column(name = "email", nullable = false)
    private String Email;

    @Column(name = "username", nullable = false)
    private String UserName;

    @Column(name = "title", nullable = false)
    private String Title;

    @Column(name = "first_name", nullable = false)
    private String FirstName;

    @Column(name = "middle_name", nullable = false)
    private String MiddleName;

    @Column(name = "last_name", nullable = false)
    private String LastName;

    @Column(name = "address", nullable = false)
    private String Address;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Token> TokenList;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public byte[] getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(byte[] hash) {
        PasswordHash = hash;
    }

    public byte[] getPasswordSalt() {
        return PasswordSalt;
    }

    public void setPasswordSalt(byte[] salt) {
        PasswordSalt = salt;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String username) {
        UserName = username;
    }

    private String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Set<Token> getTokenList() {
        return TokenList;
    }

    public void setTokenList(Set<Token> tokenList) {
        this.TokenList = tokenList;
    }
}
