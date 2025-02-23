package FuncoesDaMain;

//import Clientes.CadastrarCliente;
import Clientes.CadastrarCliente;
import Clientes.PessoaFisica;
import Clientes.PessoaJuridica;

import java.util.Scanner;

import static BancoDeDados.BancoDeDadosClientes.cadastrarClientes;
import static BancoDeDados.BancoDeDadosClientes.listarClientes;
import static Clientes.CadastrarCliente.cadastrarPessoaJuridica;

public class FuncoesDaMain {
    static int opcaoCliente;
    public static void escolherCadastroCliente() {

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop) {
            System.out.println("\nEscolha a opção do cliente:\n");
            System.out.println("1 - Cadastro de Pessoa Física");
            System.out.println("2 - Cadastro de Pessoa Juridica");
            System.out.println("3 - Imprimir lista de Clientes");
            System.out.println("4 - Voltar ao Menu Principal\n");
            System.out.print("Digite a opção do cliente desejada: ");

            opcaoCliente = scanner.nextInt();

            PessoaFisica pessoafisica = new PessoaFisica();
            PessoaJuridica pessoaJuridica = new PessoaJuridica();
            switch (opcaoCliente){
                case 1:
                    System.out.print("\n");
                    pessoafisica = CadastrarCliente.cadastrarPessoaFisica();
                    cadastrarClientes(pessoafisica);
                    break;
                case 2:
                    System.out.print("\n");
                    pessoaJuridica = cadastrarPessoaJuridica();
                    cadastrarClientes(pessoaJuridica);
                    break;
                case 3:
                    System.out.println("Lista de clientes cadastrados:");
                    listarClientes();
                    break;
                case 4:
                    System.out.println("\n------------------------------");
                    System.out.println("Voltando ao Menu Principal.");
                    System.out.println("------------------------------\n");
                    loop = false;
                    break;
                default:
                    System.out.println("\n------------------------------");
                    System.out.println("Digite uma opção válida.");
                    System.out.println("------------------------------\n");

            }
        }

    }

    public static void escolherCadastroProduto(){

    }

    public static void escolherCadastroPedido(){

    }
}
