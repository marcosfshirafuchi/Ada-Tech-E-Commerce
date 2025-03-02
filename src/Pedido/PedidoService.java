package Pedido;

import BancoDeDados.BancoDeDadosPedidos;
import Produtos.Produto;
import BancoDeDados.BancoDeDadosProdutos;
import Frete.CalculadoraFrete;
import Frete.FretePadrao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PedidoService {
    private BancoDeDadosPedidos bancoDeDadosPedidos;
    private BancoDeDadosProdutos bancoDeDadosProdutos;
    private CalculadoraFrete calculadoraFrete;
    Scanner scanner = new Scanner(System.in);

    public PedidoService(CalculadoraFrete calculadoraFrete) {
        this.bancoDeDadosPedidos = BancoDeDadosPedidos.getInstancia();
        this.bancoDeDadosProdutos = BancoDeDadosProdutos.getInstancia();
        this.calculadoraFrete = calculadoraFrete;
    }

    public void adicionarItem(Pedido pedido, int idProduto, int quantidade) {
        Produto produto = bancoDeDadosProdutos.buscarPorId(idProduto);
        if (produto != null) {
            try {
                ItemPedido item = new ItemPedido(produto, quantidade, produto.getValorDeVenda());
                pedido.adicionarItem(item);
                bancoDeDadosPedidos.salvar(pedido);
                System.out.println("Item adicionado ao pedido.");
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("Erro ao adicionar item: " + e.getMessage());
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void removerItem(Pedido pedido, int idProduto) {
        try {
            Produto produto = bancoDeDadosProdutos.buscarPorId(idProduto);
            if (produto != null) {
                try {
                    ItemPedido item = new ItemPedido(produto, 0, 0);
                    pedido.removerItem(item);
                    bancoDeDadosPedidos.salvar(pedido);
                    System.out.println("Item removido do pedido.");
                } catch (IllegalStateException | IllegalArgumentException e) {
                    System.out.println("Erro ao remover item: " + e.getMessage());
                }
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Por favor, digite um número inteiro.");
            scanner.nextLine();
        }
    }

    public void alterarQuantidade(Pedido pedido, int idProduto, int novaQuantidade) {
        Produto produto = bancoDeDadosProdutos.buscarPorId(idProduto);
        if (produto != null) {
            ItemPedido item = new ItemPedido(produto, 0, 0);
            while (true) {
                try {
                    System.out.println("Digite a nova quantidade: ");
                    novaQuantidade = scanner.nextInt();
                    scanner.nextLine();
                    pedido.alterarQuantidade(item, novaQuantidade);
                    bancoDeDadosPedidos.salvar(pedido);
                    System.out.println("Quantidade alterada com sucesso.");
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, digite um número inteiro.");
                    scanner.nextLine();
                } catch (IllegalStateException e) {
                    System.out.println("Erro ao alterar quantidade do item: " + e.getMessage());
                    break;
                }
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void finalizarPedido(Pedido pedido) {
            try {
                if (pedido.podeFinalizar()) {
                    double frete = pedido.calcularFrete(calculadoraFrete, pedido.getCliente());
                    pedido.alterarStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
                    pedido.enviarNotificacao("Pedido aguardando pagamento. Total: R$ " + pedido.getValorTotal());
                    bancoDeDadosPedidos.salvar(pedido);
                    System.out.println("Valor dos itens: R$ " + pedido.getValorTotal());
                    System.out.println("Valor do frete: R$ " + pedido.getValorFrete());
                    System.out.println("Valor total: R$ " + (pedido.getValorTotal() + pedido.getValorFrete()));
                } else {
                    throw new IllegalStateException("Não foi possível finalizar o pedido. Verifique se o pedido está aberto, se há itens e se o valor total é maior que zero.");
                }
            } catch (IllegalStateException e) {
                System.out.println("Erro ao finalizar pedido: " + e.getMessage());
            }
    }

    public void pagar(Pedido pedido) {
        try {
            if (pedido.getStatus() == StatusPedido.AGUARDANDO_PAGAMENTO) {
                pedido.alterarStatus(StatusPedido.PAGO);
                pedido.enviarNotificacao("Pedido pago. Total: R$ " + pedido.getValorTotal());
                bancoDeDadosPedidos.salvar(pedido);
                System.out.println("Pedido pago com sucesso.");
            } else {
                throw new IllegalStateException("Não foi possível pagar o pedido. Verifique se o pedido está aguardando pagamento.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Erro ao pagar pedido: " + e.getMessage());
        }
    }

    public void entregar(Pedido pedido) {
        try {
            if (pedido.getStatus() == StatusPedido.PAGO) {
                pedido.alterarStatus(StatusPedido.FINALIZADO);
                pedido.enviarNotificacao("Pedido entregue.");
                bancoDeDadosPedidos.salvar(pedido);
                System.out.println("Pedido entregue com sucesso.");
            } else {
                throw new IllegalStateException("Não foi possível entregar o pedido. Verifique se o pedido está pago.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Erro ao entregar pedido: " + e.getMessage());
        }
    }
}
