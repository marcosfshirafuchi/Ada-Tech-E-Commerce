package Produtos;

public class Produto {
    private int id;
    private String nome;
    private String categoria;
    private double valorDeProduto;
    private double valorDeVenda;
    private double desconto;

    public Produto(int id, String nome, String categoria, double valorDeProduto, double valorDeVenda, double desconto) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.valorDeProduto = valorDeProduto;
        this.valorDeVenda = valorDeVenda;
        this.desconto = desconto;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setValorDeVenda(double valorDeVenda) {
        this.valorDeVenda = valorDeVenda;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "Produto{" + "id = " + id + ", nome = " + nome + ", categoria = " + categoria + '}';
    }
}
