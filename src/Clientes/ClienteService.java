package Clientes;

import BancoDeDados.BancoDeDadosClientes;

import java.util.Scanner;

import static Clientes.ConsultaCEP.buscarEndereco;
import static Clientes.ConsultaCEP.obterEndereco;
import static Clientes.ValidaTelefone.validarTelefone;

public class ClienteService {
    private BancoDeDadosClientes bancoDeDadosClientes = BancoDeDadosClientes.getInstancia();
    public boolean atualizarDadosCliente(int idCliente) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = bancoDeDadosClientes.buscarClientePorId(idCliente);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return false;
        }

        System.out.println("Atualizando dados do cliente: " + cliente.getNome());

        System.out.print("Digite o novo nome do cliente: ");
        String nome = scanner.nextLine();

        String novoDocumento;
        if (cliente instanceof PessoaFisica) {
            do {
                System.out.print("Digite o novo CPF neste formato: 00000000000 => ");
                novoDocumento = scanner.nextLine();
                if (!ValidaCPF.isCPF(novoDocumento)) {
                    System.out.println("Erro, CPF inválido!");
                }
            } while (!ValidaCPF.isCPF(novoDocumento));
        } else {
            do {
                System.out.print("Digite o novo CNPJ neste formato: 00000000000000 => ");
                novoDocumento = scanner.nextLine();
                if (!ValidaCNPJ.isCNPJ(novoDocumento)) {
                    System.out.println("Erro, CNPJ inválido!");
                }
            } while (!ValidaCNPJ.isCNPJ(novoDocumento));
        }

        String telefone;
        do {
            System.out.print("Digite o novo telefone do cliente: ");
            telefone = scanner.nextLine();
            if (!validarTelefone(telefone)) {
                System.out.println("Erro, telefone inválido!");
            }
        } while (!validarTelefone(telefone));

        String cep;
        boolean respostaCep;
        do {
            System.out.print("Digite o novo CEP do cliente: ");
            cep = scanner.nextLine();
            respostaCep = buscarEndereco(cep);
            if (!respostaCep) {
                System.out.println("Erro, CEP inválido!");
            }
        } while (!respostaCep);

        Endereco endereco = obterEndereco(cep);
        System.out.print("Digite o número do logradouro do cliente: ");
        String numero = scanner.nextLine();
        endereco.setNumero(numero);

        String complemento = null;
        int opcao;
        do {
            System.out.print("Deseja preencher um complemento do endereço? (1 - Sim, 2 - Não): ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao == 1) {
                System.out.print("Digite o complemento: ");
                complemento = scanner.nextLine();
                endereco.setComplemento(complemento);
            }
        } while (opcao != 1 && opcao != 2);

        cliente.setNome(nome);
        cliente.setNumeroDoDocumento(novoDocumento);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);

        System.out.println("Dados do cliente atualizados com sucesso!");
        return true;
    }
}
