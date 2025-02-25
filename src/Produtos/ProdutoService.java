package Produtos;

import java.util.List;

import static Produtos.ProdutoRepository.listaProdutos;

public class ProdutoService {

    public Produto buscarProduto(int id, List<Produto> listaProdutos) {
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

    public void atualizarProduto(int id, String novoNome, String novaCategoria, double novoValorDeVenda, double novoDesconto) {
        Produto produto = ProdutoRepository.buscarProduto(id);
            if(produto != null) {
                produto.setNome(novoNome);
                produto.setCategoria(novaCategoria);
                produto.setValorDeVenda(novoValorDeVenda);
                produto.setDesconto(novoDesconto);
                System.out.println("Produto " + produto.getId() + " atualizado com sucesso.");
                return;
            }
        System.out.println("Produto não encontrado.");
    }
}
