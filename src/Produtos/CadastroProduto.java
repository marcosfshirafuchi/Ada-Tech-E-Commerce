package Produtos;

import java.util.Scanner;

public class CadastroProduto {
    private static Scanner scanner = new Scanner(System.in);

    public static Produto cadastrarProduto() {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();

        System.out.println("Digite a categoria do produto:");
        String categoria = scanner.nextLine();

        System.out.println("Digite o preço de custo do produto:");
        double valorDeProduto = scanner.nextDouble();

        System.out.println("Digite o preço de venda do produto:");
        double valorDeVenda = scanner.nextDouble();

        System.out.println("Digite o desconto do produto:");
        double desconto = scanner.nextDouble();
        scanner.nextLine();


        Produto produto = CategoriaFactory.criarProduto(nome, categoria, valorDeProduto, valorDeVenda, desconto);
        ProdutoRepository.listaProdutos.add(produto);
        return produto;
    }

}
