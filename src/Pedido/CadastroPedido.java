package Pedido;

import java.util.Scanner;

import BancoDeDados.BancoDeDadosClientes;
import BancoDeDados.BancoDeDadosPedidos;
import Pedido.Notificacao.*;
import Produtos.Produto;
import BancoDeDados.BancoDeDadosProdutos;
import Clientes.Cliente;

public class CadastroPedido {
    private BancoDeDadosClientes bancoDeDadosClientes = BancoDeDadosClientes.getInstancia();
    private BancoDeDadosPedidos bancoDeDadosPedidos = BancoDeDadosPedidos.getInstancia();
    private BancoDeDadosProdutos bancoDeDadosProdutos = BancoDeDadosProdutos.getInstancia();

    public CadastroPedido(BancoDeDadosClientes bancoDeDadosClientes, BancoDeDadosPedidos bancoDeDadosPedidos, BancoDeDadosProdutos bancoDeDadosProdutos) {
        this.bancoDeDadosClientes = bancoDeDadosClientes;
        this.bancoDeDadosPedidos = bancoDeDadosPedidos;
        this.bancoDeDadosProdutos = bancoDeDadosProdutos;
    }

    public Pedido iniciarCadastroPedidos() {
        Scanner scanner = new Scanner(System.in);
        boolean cadastrarPedido = true;
        Pedido pedido = null;

        while (cadastrarPedido) {
            cadastrarPedido(scanner);

            System.out.println("Deseja cadastrar outro pedido? (1 - Sim / 2 - Não)");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            cadastrarPedido = opcao == 1;
        }
        return pedido;
    }

    private Pedido cadastrarPedido(Scanner scanner) {
        System.out.println("Escolha um cliente: ");
        bancoDeDadosClientes.listarTodos();
        System.out.println("Digite o ID do cliente: ");
        int idCliente = scanner.nextInt();

        Cliente cliente = bancoDeDadosClientes.buscarPorId(idCliente);

        Pedido pedido = new Pedido(cliente);

        System.out.println("Cadastro de Pedido para " + cliente.getNome() + "\n");

        boolean adicionarProdutos = true;
        while (adicionarProdutos) {
            System.out.print("Escolha o produto para adicionar ao pedido: ");
            System.out.println();
            bancoDeDadosProdutos.listarTodos();
            System.out.println("Digite o ID do produto: ");
            int idProduto = scanner.nextInt();

            Produto produto = BancoDeDadosProdutos.getInstancia().buscarPorId(idProduto);
            if (produto != null) {
                System.out.print("Digite a quantidade desejada: ");
                int quantidade = scanner.nextInt();
                pedido.adicionarItem(new ItemPedido(produto, quantidade, produto.getValorDeVenda()));
                System.out.println("Produto " + produto.getNome() + " adicionado ao pedido.");
            } else {
                System.out.println("Produto não encontrado.");
            }

            System.out.println("Deseja adicionar outro produto? (1 - Sim / 2 - Não)");
            int opcao = scanner.nextInt();
            adicionarProdutos = opcao == 1;
        }
        configurarNotificacao(scanner, pedido);
        bancoDeDadosPedidos.salvar(pedido);
        return pedido;
    }

    private void configurarNotificacao(Scanner scanner, Pedido pedido) {
        System.out.println("Escolha o tipo de notificação desejada (1 - Whatsapp, 2 - SMS, 3 - E-mail): ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        CommunicationServices communicationService = null;
        switch (opcao) {
            case 1:
                communicationService = new WhatsappService();
                break;
            case 2:
                communicationService = new SmsService();
                break;
            case 3:
                communicationService = new EmailService();
                break;
            default:
                System.out.println("Opção inválida.");
                System.out.println("Deseja escolher outro tipo de notificação? (1 - Sim / 2 - Não)");
                int escolherNotificacao = scanner.nextInt();
                scanner.nextLine();
                if (escolherNotificacao == 1) {
                    configurarNotificacao(scanner, pedido);
                }
                return;
        }
        Notificacao notificacao = new Notificacao(communicationService);
        pedido.setNotificacao(notificacao);
    }
}