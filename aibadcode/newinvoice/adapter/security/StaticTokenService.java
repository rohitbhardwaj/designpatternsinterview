/*  adapter/security/StaticTokenService.java  */
package aibadcode.newinvoice.adapter.security;

import aibadcode.newinvoice.port.TokenService;

/**
 * Dummy token generator – returns a predictable string.
 *
 * <p>Shows how security can be abstracted for teaching; a real adapter would
 * sign JWTs.</p>
 *
 * <b>SRP</b> – One responsibility.<br>
 * <b>OCP / DIP</b> – Replace with real crypto without changing consumers.
 */
public class StaticTokenService implements TokenService {
    @Override public String issueToken(String clientId) {
        return "token-for-" + clientId;
    }
}
