package Produtos;

import java.util.Scanner;

import static Produtos.ProdutoRepository.buscarProduto;

public class ProdutoService {

    private static Scanner scanner = new Scanner(System.in);

    public static void atualizarProduto(int id) {
        Produto produto = buscarProduto(id);

        if (produto != null) {
            System.out.println("Atualização do Produto: ");

            System.out.println("Nome atual: " + produto.getNome());
            System.out.print("Digite o novo nome (ou pressione Enter para manter): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) {
                produto.setNome(novoNome);
            }

            System.out.println("Categoria atual: " + produto.getCategoria());
            System.out.print("Digite a nova categoria (ou pressione Enter para manter): ");
            String novaCategoria = scanner.nextLine();
            if (!novaCategoria.isEmpty()) {
                while (!CategoriaFactory.isCategoriaValida(novaCategoria.toLowerCase())) {
                    System.out.println("Categoria inválida! Por favor, escolha entre: Eletronicos, Livros, Roupas");
                    novaCategoria = scanner.nextLine();
                }
                produto.setCategoria(novaCategoria);
            }

            System.out.println("Preço de venda atual: " + produto.getValorDeVenda());
            System.out.print("Digite o novo preço de venda: ");
            double novoValorDeVenda = scanner.nextDouble();
            if (novoValorDeVenda > produto.getValorDeProduto() && novoValorDeVenda >= 0) {
                produto.setValorDeVenda(novoValorDeVenda);
            } else {
                System.out.println("Erro: O preço de venda não pode ser inferior ao preço de custo.");
                return;
            }

            System.out.println("Desconto atual: " + produto.getDesconto() + "%");
            System.out.print("Digite o novo desconto (em %): ");
            double novoDesconto = scanner.nextDouble();
            if (novoDesconto >= 0 && novoDesconto <= 100) {
                produto.setDesconto(novoDesconto);
            } else {
                System.out.println("Erro: O desconto deve ser entre 0% e 100%.");
                return;
            }

            System.out.println("Produto " + produto.getId() + " atualizado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
