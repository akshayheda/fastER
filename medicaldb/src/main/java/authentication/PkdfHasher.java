package authentication;

import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.crypto.generators.BCrypt;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jcajce.PKCS12KeyWithParameters;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by inkys_000 on 3/25/2017.
 */
public class PkdfHasher implements PasswordHasher {
    private int iterations = 5000;
    private int byteLength = 256;

    public PkdfHasher() {

    }

    public PkdfHasher(int iterations, int byteLength) {
        this.iterations = iterations;
        this.byteLength = byteLength;
    }

    public byte[] Hash(String password, byte[] salt) {
        try {
            PKCS5S2ParametersGenerator generator = new PKCS5S2ParametersGenerator();
            generator.init(password.getBytes("UTF-8"), salt, iterations);
            byte[] hash = ((KeyParameter) generator.generateDerivedMacParameters(8 * byteLength)).getKey();
            return hash;
        }
        catch(UnsupportedEncodingException e) {
            return null;
        }
    }

    public boolean VerifyHash(String password, byte[] salt, byte[] hash) {
        return Arrays.equals(Hash(password, salt), hash);
    }
}
