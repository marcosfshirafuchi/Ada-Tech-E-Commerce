package Produtos;

public abstract class Produto {
    private static int contadorId = 1;
    private int id;
    private String nome;
    private Categoria categoria;
    private double valorDeProduto;
    private double valorDeVenda;
    private double desconto;

    public Produto(String nome, Categoria categoria, double valorDeProduto, double valorDeVenda, double desconto) {
        this.id = contadorId++;
        this.nome = nome;
        this.categoria = categoria;
        this.valorDeProduto = valorDeProduto;
        this.valorDeVenda = valorDeVenda;
        this.desconto = desconto;
    }

    public String getNome() {
        return nome;
    }

    public double getValorDeProduto() {return valorDeProduto;}

    public int getId() {return id;}

    public double getValorDeVenda() {
        return valorDeVenda;
    }

    public double getDesconto() {return desconto;}

    public Categoria getCategoria() {return categoria;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setValorDeProduto(double valorDeProduto) {
        this.valorDeProduto = valorDeProduto;
    }

    public void setValorDeVenda(double valorDeVenda) {
        this.valorDeVenda = valorDeVenda;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "Produto{" + "id = " + id + ", nome = " + nome + ", categoria = " + categoria + ", valorDeProduto = " + valorDeProduto + ", valorDeVenda = " + valorDeVenda + ", desconto = " + desconto + '}';
    }
}
