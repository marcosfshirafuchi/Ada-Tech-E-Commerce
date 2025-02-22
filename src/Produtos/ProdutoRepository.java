package Produtos;

import Produtos.Categorias.CategoriaProduto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    public static List<Produto> listaProdutos = new ArrayList<Produto>();

    public static void cadastrarProduto(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("Produto " + produto.getNome() +" cadastrado com sucesso!");
    }

    public static void listarProdutos() {
        for (Produto produto : listaProdutos) {
            System.out.println(produto);
        }
    }

    public static void atualizarProduto(int id, String novoNome, CategoriaProduto novaCategoria, double novoValorDeVenda, double novoDesconto) {
        for (Produto produto : listaProdutos) {
            if(produto.getId() == id) {
                produto.setNome(novoNome);
                produto.setCategoria(novaCategoria);
                produto.setValorDeVenda(novoValorDeVenda);
                produto.setDesconto(novoDesconto);
                System.out.println("Produto " + produto.getId() + " atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

}
