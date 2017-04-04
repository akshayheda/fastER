package authentication;

/**
 * Created by inkys_000 on 3/25/2017.
 */
public interface PasswordHasher {
    byte[] Hash(String password, byte[] salt);

    boolean VerifyHash(String password, byte[] salt, byte[] hash);
}
