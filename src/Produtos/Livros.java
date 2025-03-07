package Produtos;

public class Livros extends Produto {

    public Livros(String nome, double valorDeProduto, double valorDeVenda) {
        super(nome, Categoria.LIVROS, valorDeProduto, valorDeVenda);
    }
}