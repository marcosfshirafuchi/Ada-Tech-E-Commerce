package Pedido;

import Produtos.Produto;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double precoDeVenda;

    public ItemPedido(Produto produto, int quantidade, double precoDeVenda) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoDeVenda = precoDeVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoDeVenda() {
        return precoDeVenda;
    }

    public double calcularSubtotal() {
        return quantidade * precoDeVenda;
    }

    public double getSubtotal() {
        return calcularSubtotal();
    }
}
