package Produtos;

public class ProdutoService {

    private ProdutoRepository repository = new ProdutoRepository();

    public void atualizarProduto(int id, String novoNome, String novaCategoria, double novoValorDeVenda, double novoDesconto) {
        Produto produto = repository.buscarProduto(id);
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
