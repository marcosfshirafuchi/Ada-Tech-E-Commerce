package Produtos;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    private static List<Produto> listaProdutos = new ArrayList<>();

    public static List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void listarProdutos() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado");
        } else {
            for (Produto produto : listaProdutos) {
                System.out.println(produto);
            }
        }
    }

    public void adicionarProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    public Produto buscarProduto(int id) {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado");
        } else {
            for (Produto produto : listaProdutos) {
                if (produto.getId() == id) {
                    return produto;
                }
            }
        }
        return null;
    }
}


