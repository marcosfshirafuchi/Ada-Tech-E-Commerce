package Produtos;

public interface CategoriaFactory {
    Produto criarProduto(String nome, Categoria categoria, double valorDeProduto, double valorDeVenda);
}
