package Clientes;

import java.util.Scanner;

import static Clientes.EscolhaSiglaDeEstado.buscarEstadoBrasileiroEscolhido;
import static Clientes.EscolhaSiglaDeEstado.imprimirSiglaDosEstadosBrasileiros;

public class CadastrarCliente {
    public static PessoaFisica cadastrarPessoaFisica() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        String cpf;
        do{
            System.out.print("Digite o CPF do cliente: ");
            cpf = scanner.nextLine();
            if (ValidaCPF.isCPF(cpf) == false){
                System.out.printf("Erro, CPF invalido !!!\n");
            }
        }while (ValidaCPF.isCPF(cpf) == false);
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o CEP do cliente: ");
        String cep = scanner.nextLine();
        System.out.print("Digite o logradouro do cliente: ");
        String logradouro = scanner.nextLine();
        System.out.print("Digite o numero logradouro do cliente: ");
        String numero = scanner.nextLine();
        String complemento = null;
        int opcao;
        do{
            System.out.print("Precisa preecher algum dado complementar do endereço do cliente: \n(1 - Sim ou 2 - Não): ");
            opcao = scanner.nextInt();
            switch (opcao){
                case(1):
                    System.out.print("\nDigite o complemento do logradouro do cliente: ");
                    complemento = scanner.nextLine();
                    break;
                case(2):
                    break;
                default:
                    System.out.println("Opção incorreta:");
            }
        }while (!(opcao>=1&& opcao <=2));
        scanner.nextLine();
        System.out.print("Digite o bairro do cliente: ");
        String bairro = scanner.nextLine();
        System.out.print("Digite cidade do cliente: ");
        String cidade = scanner.nextLine();
        System.out.print("Menu dos estados brasileiros: ");
        imprimirSiglaDosEstadosBrasileiros();
        System.out.print("Digite o código do estado brasileiro escolhido: ");
        int codigo = scanner.nextInt();
        EstadosBrasil estadoBrasil = buscarEstadoBrasileiroEscolhido(codigo);
        Endereco endereco;
        if (complemento==null){
            endereco = new Endereco(cep,logradouro,numero,bairro,cidade,estadoBrasil);
        }else {
            endereco = new Endereco(cep,logradouro,numero,complemento,bairro,cidade,estadoBrasil);
        }
        PessoaFisica pessoaFisica = new PessoaFisica(nome,cpf,endereco,telefone,TipoDeCliente.PESSOA_FISICA.getTipoDeCliente());
        return pessoaFisica;
    }

    public static PessoaJuridica cadastrarPessoaJuridica(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        String cnpj = null;
        do{
            System.out.print("Digite o CNPJ neste formato: 00000000000000 => ");
            cnpj = scanner.nextLine();
            if (ValidaCNPJ.isCNPJ(cnpj) == false){
                System.out.printf("Erro, CNPJ invalido !!!\n");
            }
        }while (ValidaCNPJ.isCNPJ(cnpj) == false);
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o CEP do cliente: ");
        String cep = scanner.nextLine();
        System.out.print("Digite o logradouro do cliente: ");
        String logradouro = scanner.nextLine();
        System.out.print("Digite o numero logradouro do cliente: ");
        String numero = scanner.nextLine();
        String complemento = null;
        int opcao;
        do{
            System.out.print("Precisa preecher algum dado complementar do endereço do cliente: \n(1 - Sim ou 2 - Não)");
            opcao = scanner.nextInt();
            switch (opcao){
                case(1):
                    System.out.print("\nDigite o complemento do logradouro do cliente: ");
                    complemento = scanner.nextLine();
                    break;
                case(2):
                    break;
                default:
                    System.out.println("Opção incorreta:");
            }
        }while (!(opcao>=1&& opcao <=2));
        scanner.nextLine();
        System.out.print("Digite o bairro do cliente: ");
        String bairro = scanner.nextLine();
        System.out.print("Digite cidade do cliente: ");
        String cidade = scanner.nextLine();
        System.out.print("Menu dos estados brasileiros: ");
        imprimirSiglaDosEstadosBrasileiros();
        System.out.print("Digite o código do estado brasileiro escolhido: ");
        int codigo = scanner.nextInt();
        EstadosBrasil estadoBrasil = buscarEstadoBrasileiroEscolhido(codigo);
        Endereco endereco;
        if (complemento==null){
            endereco = new Endereco(cep,logradouro,numero,bairro,cidade,estadoBrasil);
        }else {
            endereco = new Endereco(cep,logradouro,numero,complemento,bairro,cidade,estadoBrasil);
        }
        PessoaJuridica pessoaJuridica = new PessoaJuridica(nome,cnpj,endereco,telefone,TipoDeCliente.PESSOA_JURIDICA.getTipoDeCliente());
        return pessoaJuridica;
    }
}
