package Pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import BancoDeDados.BancoDeDadosClientes;
import Produtos.Produto;
import Produtos.ProdutoRepository;
import Clientes.Cliente;

public class CadastroPedido {
    private BancoDeDadosClientes bancoDeDadosClientes = BancoDeDadosClientes.getInstancia();
    private PedidoRepository pedidoRepository = PedidoRepository.getInstancia();
    private ProdutoRepository produtoRepository = ProdutoRepository.getInstancia();

    public CadastroPedido(BancoDeDadosClientes bancoDeDadosClientes, PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
        this.bancoDeDadosClientes = bancoDeDadosClientes;
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    public Pedido cadastrarPedido() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um cliente: ");
        bancoDeDadosClientes.listarClientes();
        System.out.println("Digite o ID do cliente: ");
        int idCliente = scanner.nextInt();

        Cliente cliente = bancoDeDadosClientes.buscarClientePorId(idCliente);

        Pedido pedido = new Pedido(cliente);

        System.out.println("Cadastro de Pedido para " + cliente.getNome() + "\n");

        boolean adicionarProdutos = true;
        while (adicionarProdutos) {
            System.out.print("Escolha o produto para adicionar ao pedido: ");
            System.out.println();
            produtoRepository.listarProdutos();
            System.out.println("Digite o ID do produto: ");
            int idProduto = scanner.nextInt();

            Produto produto = produtoRepository.buscarProduto(idProduto);
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
        pedidoRepository.salvar(pedido);
        return pedido;
    }
}