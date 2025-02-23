import java.util.Scanner;

import static BancoDeDados.BancoDeDadosClientes.listarClientes;
import static FuncoesDaMain.FuncoesDaMain.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("**************Ada Commerce - E-Commerce**************\n");

        int opcao;
        boolean loop = true;

        while(loop) {
            System.out.println("Escolha o tipo de serviço que deseja executar: \n");

            System.out.println("1 - Cadastro de Cliente");
            System.out.println("2 - Cadastro de Produto");
            System.out.println("3 - Cadastro de Pedido");
            System.out.println("4 - Sair do sistema \n");

            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("");
                    escolherCadastroCliente();
                    break;
                case 2:
                    escolherCadastroProduto();
                    break;
                case 3:
                    escolherCadastroPedido();
                    break;
                case 4:
                    System.out.println("**********Lista de clientes cadastrados**********");
                    listarClientes();
                    System.out.println("Saindo do sistema.");
                    loop = false;
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
                    System.out.println("------------------------------");
            }
        }
    }
}