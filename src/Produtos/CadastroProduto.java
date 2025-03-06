package Produtos;

import BancoDeDados.BancoDeDadosProdutos;
import java.util.Scanner;
import static ValidacaoInput.ValidacaoInput.obterValorMonetarioValido;

public class CadastroProduto {
    private static Scanner scanner = new Scanner(System.in);
    CategoriaFactoryImpl categoriaFactory = new CategoriaFactoryImpl();
    BancoDeDadosProdutos bancoDeDadosProdutos = BancoDeDadosProdutos.getInstancia();

    public void cadastrarProduto() {
        boolean cadastrarNovoProduto = true;

        while (cadastrarNovoProduto) {
            Categoria.printCategorias();
            int categoriaIndex = scanner.nextInt();
            scanner.nextLine();
            Categoria categoria = Categoria.fromInt(categoriaIndex);

            System.out.println("Digite o nome do produto:");
            String nome = scanner.nextLine();

            double valorDeProduto;
            do {
                System.out.println("Digite o preço de custo do produto:");
                valorDeProduto = obterValorMonetarioValido(scanner);
                if (valorDeProduto <= 0) {
                    System.out.println("Preço de custo deve ser um valor positivo.");
                }
            } while (valorDeProduto <= 0);

            double valorDeVenda;
            do {
                System.out.println("Digite o preço de venda do produto:");
                valorDeVenda = obterValorMonetarioValido(scanner);
                if (valorDeVenda <= valorDeProduto) {
                    System.out.println("Preço de venda deve ser superior ao preço de custo.");
                }
            } while (valorDeVenda <= valorDeProduto);

            double desconto;
            do {
                System.out.println("Digite o desconto do produto (0 a 100):");
                desconto = scanner.nextDouble();
                scanner.nextLine();
                if (desconto < 0 || desconto > 100) {
                    System.out.println("Desconto deve ser entre 0% e 100%.");
                }
            } while (desconto < 0 || desconto > 100);

            Produto produto = categoriaFactory.criarProduto(nome, categoria, valorDeProduto, valorDeVenda, desconto);
            bancoDeDadosProdutos.salvar(produto);
            System.out.println("Produto cadastrado com sucesso!");

            System.out.println("Resumo do produto cadastrado:");
            System.out.println("Id: " + produto.getId());
            System.out.println("Nome: " + nome);
            System.out.println("Categoria: " + categoria);
            System.out.println("Preço de custo: R$ " + String.format("%.2f", valorDeProduto));
            System.out.println("Preço de venda: R$ " + String.format("%.2f", valorDeVenda));
            System.out.println("Desconto: " + String.format("%.2f", desconto) + "%");

            System.out.println("Deseja cadastrar outro produto? (1 - Sim / 2 - Não)");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            cadastrarNovoProduto = opcao == 1;
        }
    }
}
