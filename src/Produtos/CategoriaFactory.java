package Produtos;

import java.util.Scanner;

public class CategoriaFactory {

    private static Scanner scanner = new Scanner(System.in);

    public static Produto criarProduto(String nome, String categoria, double valorDeProduto, double valorDeVenda, double desconto) {
        categoria = categoria.toLowerCase();

        while (!isCategoriaValida(categoria)) {
            System.out.println("Categoria inválida! Por favor, escolha uma das categorias abaixo:");
            System.out.println("Eletronicos, Livros, Roupas");
            System.out.print("Digite uma categoria válida: ");
            categoria = scanner.nextLine().toLowerCase();
        }

        return criarProdutoValido(nome, categoria, valorDeProduto, valorDeVenda, desconto);
    }

    protected static boolean isCategoriaValida(String categoria) {
        return categoria.equals("eletronicos") || categoria.equals("livros") || categoria.equals("roupas");
    }

    private static Produto criarProdutoValido(String nome, String categoria, double valorDeProduto, double valorDeVenda, double desconto) {
        switch (categoria) {
            case "eletronicos":
                return new Eletronicos(nome, valorDeProduto, valorDeVenda, desconto);
            case "livros":
                return new Livros(nome, valorDeProduto, valorDeVenda, desconto);
            case "roupas":
                return new Roupas(nome, valorDeProduto, valorDeVenda, desconto);
            default:
                throw new IllegalArgumentException("Categoria inválida.");
        }
    }
}
