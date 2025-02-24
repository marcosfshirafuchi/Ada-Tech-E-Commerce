package Pedido;

import java.util.Scanner;

import Produtos.Produto;
import Clientes.Cliente;

import static BancoDeDados.BancoDeDadosClientes.*;
import static Produtos.ProdutoRepository.*;

public class CadastroPedido {

    public static Pedido cadastrarPedido() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um cliente: ");
        listarClientes();
        System.out.println("Digite o ID do cliente: ");
        int idCliente = scanner.nextInt();

        Cliente cliente = buscarClientePorId(idCliente);

        Pedido pedido = new Pedido(cliente);

        System.out.println("Cadastro de Pedido para " + cliente.getNome() + "\n");

        boolean adicionarProdutos = true;
        while (adicionarProdutos) {
            System.out.print("Escolha ID do produto a ser adicionado ao pedido: ");
            System.out.println();
            listarProdutos();
            System.out.println("Digite o ID do produto: ");
            int idProduto = scanner.nextInt();

            Produto produto = buscarProduto(idProduto);
            if (produto != null) {
                System.out.print("Digite a quantidade: ");
                int quantidade = scanner.nextInt();
                pedido.adicionarItem(produto, quantidade);
                System.out.println("Produto " + produto.getNome() + " adicionado ao pedido.");
            } else {
                System.out.println("Produto não encontrado.");
            }

            System.out.println("Deseja adicionar outro produto? (1 - Sim / 2 - Não)");
            int opcao = scanner.nextInt();
            if (opcao == 2) {
                adicionarProdutos = false;
            }
        }

        return pedido;
    }
}