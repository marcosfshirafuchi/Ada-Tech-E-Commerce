package Produtos;

public class CategoriaFactoryImpl implements CategoriaFactory {

    @Override
    public Produto criarProduto(String nome, Categoria categoria, double valorDeProduto, double valorDeVenda) {
        switch (categoria) {
            case ELETRONICOS:
                return new Eletronicos(nome, valorDeProduto, valorDeVenda);
            case LIVROS:
                return new Livros(nome, valorDeProduto, valorDeVenda);
            case ROUPAS:
                return new Roupas(nome, valorDeProduto, valorDeVenda);
            default:
                throw new IllegalArgumentException("Categoria inválida: " + categoria);
        }
    }
}
