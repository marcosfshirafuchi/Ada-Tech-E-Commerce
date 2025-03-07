package ValidacaoInput;

import java.util.Scanner;

public class ValidacaoInput {

    public static int obterOpcaoValida(Scanner scanner) {
        while (true) {
            String entrada = scanner.nextLine();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("\n------------------------------");
                System.out.println("Entrada inválida! Digite um número válido.");
                System.out.println("------------------------------\n");
            }
        }
    }

    public static double obterValorMonetarioValido(Scanner scanner) {
        while (true) {
            String entrada = scanner.nextLine().trim();

            if (entrada.isEmpty()) {
                return -1;
            }

            entrada = entrada.replace(",", ".");

            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um valor monetário válido.");
            }
        }
    }
}
