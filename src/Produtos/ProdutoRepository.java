package Produtos;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    public static List<Produto> listaProdutos = new ArrayList<>();

    public static void listarProdutos() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado");
        } else {
            for (Produto produto : listaProdutos) {
                System.out.println(produto);
            }
        }
    }

    public static Produto buscarProduto(int id) {
        for (Produto produto : listaProdutos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }
}


