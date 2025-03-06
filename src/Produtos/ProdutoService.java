package Produtos;

import java.util.Scanner;
import static ValidacaoInput.ValidacaoInput.obterValorMonetarioValido;

public class ProdutoService {
    BancoDeDados.BancoDeDadosProdutos bancoDeDadosProdutos = BancoDeDados.BancoDeDadosProdutos.getInstancia();

    private static Scanner scanner = new Scanner(System.in);

    public void atualizarProduto(int id) {
        Produto produto = bancoDeDadosProdutos.buscarPorId(id);

        if (produto != null) {
            System.out.println("Atualização do Produto: ");

            System.out.println("Categoria atual: " + produto.getCategoria());
            Categoria.printCategorias();
            System.out.print("Digite o número da nova categoria (ou pressione Enter para manter): ");
            String novaCategoriaInput = scanner.nextLine();
            if (!novaCategoriaInput.isEmpty()) {
                try {
                    int novaCategoriaIndex = Integer.parseInt(novaCategoriaInput);
                    Categoria novaCategoria = Categoria.fromInt(novaCategoriaIndex);
                    produto.setCategoria(novaCategoria);
                } catch (Exception e) {
                    System.out.println("Erro: Categoria inválida. A atualização foi cancelada.");
                    return;
                }
            }

            System.out.println("Nome atual: " + produto.getNome());
            System.out.print("Digite o novo nome (ou pressione Enter para manter): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) {
                produto.setNome(novoNome);
            }

            System.out.println("Preço de custo atual: R$ " + String.format("%.2f", produto.getValorDeProduto()));
            System.out.print("Digite o novo preço de custo (ou pressione Enter para manter): ");
            double novoValorDeCusto = obterValorMonetarioValido(scanner);
            if (novoValorDeCusto > 0) {
                produto.setValorDeProduto(novoValorDeCusto);
            } else {
                System.out.println("Erro: O preço de custo deve ser um valor positivo.");
                return;
            }

            System.out.println("Preço de venda atual: R$ " + String.format("%.2f", produto.getValorDeVenda()));
            System.out.print("Digite o novo preço de venda (ou pressione Enter para manter): ");
            double novoValorDeVenda = obterValorMonetarioValido(scanner);
            if (novoValorDeVenda > produto.getValorDeProduto() && novoValorDeVenda >= 0) {
                produto.setValorDeVenda(novoValorDeVenda);
            } else {
                System.out.println("Erro: O preço de venda não pode ser inferior ao preço de custo.");
                return;
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
