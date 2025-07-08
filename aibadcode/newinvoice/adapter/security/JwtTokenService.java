/*  File: src/main/java/aibadcode/newinvoice/adapter/security/JwtTokenService.java  */
package aibadcode.newinvoice.adapter.security;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import aibadcode.newinvoice.port.TokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * <h2>JwtTokenService – Security Adapter</h2>
 *
 * <p>Encapsulates all JWT details so the domain “just asks” for a token.</p>
 *
 * <h3>SOLID Highlight</h3>
 * <ul><li><b>ISP</b>: {@link TokenService} keeps a narrow interface—only what
 * the core actually needs.</li></ul>
 */
public class JwtTokenService implements TokenService {

    private final Key  key;
    private final long ttlMinutes;

    public JwtTokenService(Key key, long ttlMinutes) {
        this.key        = key;
        this.ttlMinutes = ttlMinutes;
    }

    public String issueToken(String clientId) {
        Date exp = Date.from(
            Instant.now().plus(ttlMinutes, ChronoUnit.MINUTES));
        return Jwts.builder()
                   .setSubject(clientId)
                   .setExpiration(exp)
                   .signWith(key, SignatureAlgorithm.HS256)
                   .compact();
    }
}
