package Produtos;

import java.util.Scanner;

public class ProdutoService {
    BancoDeDados.BancoDeDadosProdutos bancoDeDadosProdutos = BancoDeDados.BancoDeDadosProdutos.getInstancia();
    CategoriaFactory categoriaFactory = new CategoriaFactory();

    private static Scanner scanner = new Scanner(System.in);

    public void atualizarProduto(int id) {
        Produto produto = bancoDeDadosProdutos.buscarPorId(id);

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
                while (!categoriaFactory.isCategoriaValida(novaCategoria.toLowerCase())) {
                    System.out.println("Categoria inválida! Por favor, escolha entre: Eletronicos, Livros, Roupas");
                    novaCategoria = scanner.nextLine();
                }
                produto.setCategoria(novaCategoria);
            }

            System.out.println("Preço de venda atual: R$ " + String.format("%.2f", produto.getValorDeVenda()));
            System.out.print("Digite o novo preço de venda (ou pressione Enter para manter): ");
            String inputValorVenda = scanner.nextLine();
            if (!inputValorVenda.isEmpty()) {
                try{
                    double novoValorDeVenda = Double.parseDouble(inputValorVenda);
                    if (novoValorDeVenda > produto.getValorDeProduto() && novoValorDeVenda >= 0) {
                        produto.setValorDeVenda(novoValorDeVenda);
                    } else {
                        System.out.println("Erro: O preço de venda não pode ser inferior ao preço de custo.");
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Erro: valor inválido. A atualização foi cancelada.");
                    return;
                }
            }

            System.out.println("Desconto atual: " + String.format("%.2f", produto.getDesconto()) + "%");
            System.out.print("Digite o novo desconto em % (ou pressione Enter para manter): ");
            String inputNovoDesconto = scanner.nextLine();
            if (!inputNovoDesconto.isEmpty()) {
                try {
                    double novoDesconto = Double.parseDouble(inputNovoDesconto);
                    if (novoDesconto >= 0 && novoDesconto <= 100) {
                        produto.setDesconto(novoDesconto);
                    } else {
                        System.out.println("Erro: O desconto deve ser entre 0% e 100%.");
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Erro: valor inválido. A atualização foi cancelada.");
                    return;
                }
            }

            System.out.println("Produto " + produto.getId() + " atualizado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
