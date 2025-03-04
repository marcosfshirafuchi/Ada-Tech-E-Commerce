package Clientes;

import java.util.InputMismatchException;

public class ValidaCNPJ {
    public static boolean isCNPJ(String CNPJ) {
        // Remove caracteres não numéricos
        CNPJ = CNPJ.replaceAll("\\D", "");

        // considera-se erro CNPJ's formados por uma sequência de números iguais ou tamanho diferente de 14
        if (CNPJ.length() != 14 || CNPJ.matches("(\\d)\\1{13}")) {
            return false;
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

        try {
            // Cálculo do 1º dígito verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                num = CNPJ.charAt(i) - '0';
                sm += (num * peso);
                peso = (peso == 9) ? 2 : peso + 1;
            }

            r = sm % 11;
            dig13 = (r < 2) ? '0' : (char) ((11 - r) + '0');

            // Cálculo do 2º dígito verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = CNPJ.charAt(i) - '0';
                sm += (num * peso);
                peso = (peso == 9) ? 2 : peso + 1;
            }

            r = sm % 11;
            dig14 = (r < 2) ? '0' : (char) ((11 - r) + '0');

            // Verifica se os dígitos calculados conferem com os dígitos informados.
            return (dig13 == CNPJ.charAt(12) && dig14 == CNPJ.charAt(13));
        } catch (InputMismatchException erro) {
            return false;
        }
    }
}
