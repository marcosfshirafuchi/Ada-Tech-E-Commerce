package Produtos;

import Produtos.Categorias.CategoriaProduto;
import Produtos.Categorias.Eletronicos;
import Produtos.Categorias.Livros;
import Produtos.Categorias.Roupas;

import java.util.Scanner;

public class CadastrarProduto {
    private static Scanner scanner = new Scanner(System.in);

    public static void cadastrarProduto() {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();

        System.out.println("Digite o preço de custo do produto:");
        double valorDeProduto = scanner.nextDouble();

        System.out.println("Digite o preço de venda do produto:");
        double valorDeVenda = scanner.nextDouble();

        System.out.println("Digite o desconto do produto:");
        double desconto = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Escolha a categoria do produto:");
        System.out.println("1 - Eletrônicos");
        System.out.println("2 - Livros");
        System.out.println("3 - Roupas");
        int opcaoCategoria = scanner.nextInt();
        scanner.nextLine();

        CategoriaProduto categoria = definirCategoria(opcaoCategoria);

        if (categoria == null) {
            System.out.println("Categoria inválida. Produto não cadastrado.");
            return;
        }

        Produto novoProduto = new Produto(nome, categoria, valorDeProduto, valorDeVenda, desconto);
        ProdutoRepository.listaProdutos.add(novoProduto);
    }

    private static CategoriaProduto definirCategoria(int opcaoCategoria) {
        switch (opcaoCategoria) {
            case 1:
                return new Eletronicos("Eletrônicos");
            case 2:
                return new Livros("Livros");
            case 3:
                return new Roupas("Roupas");
            default:
                return null;
        }
    }
}
