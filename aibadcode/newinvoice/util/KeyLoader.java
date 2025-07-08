/*  File: src/main/java/aibadcode/newinvoice/util/KeyLoader.java  */
package aibadcode.newinvoice.util;

import java.security.Key;
import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;

/** Loads HS-256 key from BASE64 env var – isolates secret handling. */
public final class KeyLoader {
    public static Key loadHs256Key() {
        String b64 = System.getenv("JWT_SECRET_B64");
        return new SecretKeySpec(Base64.getDecoder().decode(b64), "HmacSHA256");
    }
}
