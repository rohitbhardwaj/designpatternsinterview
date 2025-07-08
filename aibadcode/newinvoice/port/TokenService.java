/*  File: src/main/java/aibadcode/newinvoice/port/TokenService.java  */
package aibadcode.newinvoice.port;

/**
 * Security-token port.
 *
 * <b>SRP</b> – Sole purpose is issuing tokens.<br>
 * <b>DIP</b> – Core uses this interface, leaving crypto details to adapters.
 */
public interface TokenService {
    String issueToken(String clientId);
}
