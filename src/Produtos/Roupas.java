package Produtos;

public class Roupas extends Produto {

    public Roupas(String nome, double valorDeProduto, double valorDeVenda, double desconto) {
        super(nome, Categoria.ROUPAS, valorDeProduto, valorDeVenda, desconto);
    }
}