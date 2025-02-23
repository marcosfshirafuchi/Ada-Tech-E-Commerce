package Clientes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaTelefone {

private static final String REGEX_TELEFONE = "^(\\(?[1-9]{2}\\)?\\s?)?9?[0-9]{4}\\s?-?\\s?[0-9]{4}$";

    public static boolean validarTelefone(String telefone) {
        Pattern pattern = Pattern.compile(REGEX_TELEFONE);
        Matcher matcher = pattern.matcher(telefone);
        return matcher.matches();
    }
}
