package Produtos;

public class Livros extends Produto {

    public Livros(String nome, double valorDeProduto, double valorDeVenda, double desconto) {
        super(nome, Categoria.LIVROS, valorDeProduto, valorDeVenda, desconto);
    }
}