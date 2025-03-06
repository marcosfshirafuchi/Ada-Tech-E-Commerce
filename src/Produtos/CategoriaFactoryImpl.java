package Produtos;

public class CategoriaFactoryImpl implements CategoriaFactory {

    @Override
    public Produto criarProduto(String nome, Categoria categoria, double valorDeProduto, double valorDeVenda, double desconto) {
        switch (categoria) {
            case ELETRONICOS:
                return new Eletronicos(nome, valorDeProduto, valorDeVenda, desconto);
            case LIVROS:
                return new Livros(nome, valorDeProduto, valorDeVenda, desconto);
            case ROUPAS:
                return new Roupas(nome, valorDeProduto, valorDeVenda, desconto);
            default:
                throw new IllegalArgumentException("Categoria inválida: " + categoria);
        }
    }
}
