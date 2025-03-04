package Clientes;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.net.InetAddress;
import java.util.Hashtable;
import java.util.regex.Pattern;

public class EmailValidator {

    private static final String EMAIL_REGEX =
            "^(?!\\.)(?!.*\\.\\.)[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    /**
     * Valida um endereço de e-mail em três etapas:
     * 1. Verifica o formato com Regex.
     * 2. Verifica se o domínio existe via DNS.
     * 3. Verifica se o domínio tem registros MX (Mail Exchange).
     *
     * @param email E-mail a ser validado
     * @return true se o e-mail for válido, false caso contrário
     */
    public static boolean isValidEmail(String email) {
        return isValidFormat(email) && isDomainValid(email) && hasMXRecord(email);
    }

    /**
     * Verifica se o formato do e-mail é válido usando Regex.
     */
    private static boolean isValidFormat(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

    /**
     * Verifica se o domínio do e-mail existe.
     */
    private static boolean isDomainValid(String email) {
        String domain = email.substring(email.indexOf("@") + 1);
        try {
            InetAddress.getByName(domain);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Verifica se o domínio tem registros MX (Mail Exchange).
     */
    private static boolean hasMXRecord(String email) {
        String domain = email.substring(email.indexOf("@") + 1);
        try {
            Hashtable<String, String> env = new Hashtable<>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.dns.DnsContextFactory");
            DirContext ctx = new InitialDirContext(env);
            Attributes attrs = ctx.getAttributes(domain, new String[]{"MX"});
            return attrs.get("MX") != null;
        } catch (NamingException e) {
            return false;
        }
    }
}
