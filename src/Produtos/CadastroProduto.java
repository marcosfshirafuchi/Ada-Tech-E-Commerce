package Produtos;

import java.util.Scanner;

public class CadastroProduto {
    private static Scanner scanner = new Scanner(System.in);

    public static Produto cadastrarProduto() {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();

        String categoria;
        do {
            System.out.println("Digite a categoria do produto (Eletronicos, Livros, Roupas):");
            categoria = scanner.nextLine().toLowerCase();
            if (!CategoriaFactory.isCategoriaValida(categoria)) {
                System.out.println("Categoria inválida! Por favor, escolha entre: Eletronicos, Livros, Roupas");
            }
        } while (!CategoriaFactory.isCategoriaValida(categoria));

        double valorDeProduto;
        do {
            System.out.println("Digite o preço de custo do produto:");
            valorDeProduto = scanner.nextDouble();
            if (valorDeProduto <= 0) {
                System.out.println("Preço de custo deve ser um valor positivo.");
            }
        } while (valorDeProduto <= 0);

        double valorDeVenda;
        do {
            System.out.println("Digite o preço de venda do produto:");
            valorDeVenda = scanner.nextDouble();
            if (valorDeVenda <= valorDeProduto) {
                System.out.println("Preço de venda deve ser superior ao preço de custo.");
            }
        } while (valorDeVenda <= valorDeProduto);

        double desconto;
        do {
            System.out.println("Digite o desconto do produto (0 a 100):");
            desconto = scanner.nextDouble();
            if (desconto < 0 || desconto > 100) {
                System.out.println("Desconto deve ser entre 0% e 100%.");
            }
        } while (desconto < 0 || desconto > 100);

        Produto produto = CategoriaFactory.criarProduto(nome, categoria, valorDeProduto, valorDeVenda, desconto);
        ProdutoRepository.adicionarProduto(produto);
        System.out.println("Produto cadastrado com sucesso!");
        return produto;
    }
}
