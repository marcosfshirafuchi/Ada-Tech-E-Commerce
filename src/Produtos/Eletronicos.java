package Produtos;

public class Eletronicos extends Produto {

    public Eletronicos(String nome, double valorDeProduto, double valorDeVenda) {
        super(nome, Categoria.ELETRONICOS, valorDeProduto, valorDeVenda);
    }
}