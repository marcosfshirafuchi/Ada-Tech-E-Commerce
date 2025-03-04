package Clientes;

import java.util.InputMismatchException;

public class ValidaCPF {
    public static boolean isCPF(String CPF) {
        // Remove caracteres não numéricos
        CPF = CPF.replaceAll("\\D", "");

        // considera-se erro CPFs formados por uma sequência de números iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") ||
                CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") ||
                CPF.equals("99999999999") || (CPF.length() != 11))
            return false;

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            // Cálculo do 1º Dígito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = CPF.charAt(i) - '0';
                sm += (num * peso);
                peso--;
            }

            r = 11 - (sm % 11);
            dig10 = (r == 10 || r == 11) ? '0' : (char) (r + '0');

            // Cálculo do 2º Dígito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = CPF.charAt(i) - '0';
                sm += (num * peso);
                peso--;
            }

            r = 11 - (sm % 11);
            dig11 = (r == 10 || r == 11) ? '0' : (char) (r + '0');

            return (dig10 == CPF.charAt(9) && dig11 == CPF.charAt(10));
        } catch (InputMismatchException erro) {
            return false;
        }
    }

}
