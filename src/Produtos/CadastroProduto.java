package Produtos;

import java.util.Scanner;

import static FuncoesDaMain.FuncoesDaMain.escolherCadastroProduto;

public class CadastroProduto {
    private static Scanner scanner = new Scanner(System.in);
    CategoriaFactory categoriaFactory = new CategoriaFactory();
    ProdutoRepository produtoRepository = ProdutoRepository.getInstancia();

    public void cadastrarProduto() {
        boolean cadastrarNovoProduto = true;

        while (cadastrarNovoProduto) {
            System.out.println("Digite o nome do produto:");
            String nome = scanner.nextLine();

        String categoria;
        do {
            System.out.println("Digite a categoria do produto (Eletronicos, Livros, Roupas):");
            categoria = scanner.nextLine().toLowerCase();
            if (!categoriaFactory.isCategoriaValida(categoria)) {
                System.out.println("Categoria inválida! Por favor, escolha entre: Eletronicos, Livros, Roupas");
            }
        } while (!categoriaFactory.isCategoriaValida(categoria));

        double valorDeProduto;
        do {
            System.out.println("Digite o preço de custo do produto:");
            valorDeProduto = scanner.nextDouble();
            if (valorDeProduto <= 0) {
                System.out.println("Preço de custo deve ser um valor positivo.");
            }
        } while (valorDeProduto <= 0);

        double valorDeVenda;
        do {
            System.out.println("Digite o preço de venda do produto:");
            valorDeVenda = scanner.nextDouble();
            if (valorDeVenda <= valorDeProduto) {
                System.out.println("Preço de venda deve ser superior ao preço de custo.");
            }
        } while (valorDeVenda <= valorDeProduto);

        double desconto;
        do {
            System.out.println("Digite o desconto do produto (0 a 100):");
            desconto = scanner.nextDouble();
            if (desconto < 0 || desconto > 100) {
                System.out.println("Desconto deve ser entre 0% e 100%.");
            }
        } while (desconto < 0 || desconto > 100);

        Produto produto = categoriaFactory.criarProduto(nome, categoria, valorDeProduto, valorDeVenda, desconto);
        produtoRepository.adicionarProduto(produto);
        System.out.println("Produto cadastrado com sucesso!");

            System.out.println("Deseja cadastrar outro produto? (1 - Sim / 2 - Não)");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            cadastrarNovoProduto = opcao == 1;
        }
    }
}
