package BancoDeDados;

import Produtos.Produto;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDadosProdutos implements BancoDeDados<Produto> {
    private static BancoDeDadosProdutos instancia;
    private List<Produto> listaProdutos;

    private BancoDeDadosProdutos() {
        listaProdutos = new ArrayList<>();
    }

    public static synchronized BancoDeDadosProdutos getInstancia() {
        if (instancia == null) {
            instancia = new BancoDeDadosProdutos();
        }
        return instancia;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    @Override
    public void salvar(Produto produto) {
        listaProdutos.removeIf(p -> p.getId() == produto.getId());
        listaProdutos.add(produto);
    }

    @Override
    public void listarTodos() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado");
        } else {
            for (Produto produto : listaProdutos) {
                System.out.println(produto);
            }
        }
    }

    @Override
    public Produto buscarPorId(int id) {
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


