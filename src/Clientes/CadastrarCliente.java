package Clientes;

import java.util.Scanner;

import static Clientes.ConsultaCEP.buscarEndereco;
import static Clientes.ConsultaCEP.obterEndereco;
import static Clientes.ValidaTelefone.validarTelefone;

public class CadastrarCliente {
    private static int cont = 1;
    public static PessoaFisica cadastrarPessoaFisica() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("**********Cadastro de Pessoa Física**********");
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        String cpf;
        do {
            System.out.print("Digite o CPF do cliente neste formato: 00000000000 => ");
            cpf = scanner.nextLine();
            if (ValidaCPF.isCPF(cpf) == false) {
                System.out.printf("Erro, CPF invalido !!!\n");
            }
        } while (ValidaCPF.isCPF(cpf) == false);
        String telefone;
        do {
            System.out.print("Digite o telefone do cliente: ");
            telefone = scanner.nextLine();
            if (!validarTelefone(telefone)) {
                System.out.printf("Erro, Telefone invalido !!!\n");
            }
        } while (!validarTelefone(telefone));
        String cep;
        boolean respostaCep;

        do {
            System.out.print("Digite o CEP do cliente: ");
            cep = scanner.nextLine();
            respostaCep = buscarEndereco(cep);
            if (!respostaCep) {
                System.out.printf("Erro, CEP invalido !!!\n");
            }
        } while (!respostaCep);
        Endereco endereco = obterEndereco(cep);
        System.out.print("Digite o numero logradouro do cliente: ");
        String numero = scanner.nextLine();
        endereco.setNumero(numero);
        String complemento = null;
        int opcao;
        do {
            System.out.print("Precisa preecher algum dado complementar do endereço do cliente: \n(1 - Sim ou 2 - Não): ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case (1):
                    System.out.print("\nDigite o complemento do logradouro do cliente: ");
                    scanner.nextLine();
                    complemento = scanner.nextLine();
                    endereco.setComplemento(complemento);
                    break;
                case (2):
                    break;
                default:
                    System.out.println("Opção incorreta:");
            }
        } while (!(opcao >= 1 && opcao <= 2));
        PessoaFisica pessoaFisica = new PessoaFisica(cont++,nome, cpf, endereco, telefone, TipoDeCliente.PESSOA_FISICA.getTipoDeCliente());
        return pessoaFisica;
    }

    public static PessoaJuridica cadastrarPessoaJuridica() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("**********Cadastro de Pessoa Juridica**********");
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        String cnpj = null;
        do {
            System.out.print("Digite o CNPJ neste formato: 00000000000000 => ");
            cnpj = scanner.nextLine();
            if (ValidaCNPJ.isCNPJ(cnpj) == false) {
                System.out.printf("Erro, CNPJ invalido !!!\n");
            }
        } while (ValidaCNPJ.isCNPJ(cnpj) == false);
        String telefone;
        do {
            System.out.print("Digite o telefone do cliente: ");
            telefone = scanner.nextLine();
            if (!validarTelefone(telefone)) {
                System.out.printf("Erro, Telefone invalido !!!\n");
            }
        } while (!validarTelefone(telefone));
        String cep;
        boolean respostaCep;
        do {
            System.out.print("Digite o CEP do cliente: ");
            cep = scanner.nextLine();
            respostaCep = buscarEndereco(cep);
            if (!respostaCep) {
                System.out.printf("Erro, CEP invalido !!!\n");
            }
        } while (!respostaCep);
        System.out.print("Digite o numero logradouro do cliente: ");
        String numero = scanner.nextLine();
        Endereco endereco = obterEndereco(cep);
        endereco.setNumero(numero);
        String complemento = null;
        int opcao;
        do {
            System.out.print("Precisa preecher algum dado complementar do endereço do cliente: \n(1 - Sim ou 2 - Não): ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case (1):
                    System.out.print("\nDigite o complemento do logradouro do cliente: ");
                    scanner.nextLine();
                    complemento = scanner.nextLine();
                    endereco.setComplemento(complemento);
                    break;
                case (2):
                    break;
                default:
                    System.out.println("Opção incorreta:");
            }
        } while (!(opcao >= 1 && opcao <= 2));
        PessoaJuridica pessoaJuridica = new PessoaJuridica(cont++,nome, cnpj, endereco, telefone, TipoDeCliente.PESSOA_JURIDICA.getTipoDeCliente());
        return pessoaJuridica;
    }
}
