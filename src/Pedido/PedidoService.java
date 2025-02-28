package Pedido;

import Pedido.Notificacao.Notificacao;
import Produtos.Produto;
import Produtos.ProdutoRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PedidoService {
    private PedidoRepository pedidoRepository;
    private ProdutoRepository produtoRepository;
    Scanner scanner = new Scanner(System.in);

    public PedidoService() {
        this.pedidoRepository = PedidoRepository.getInstancia();
        this.produtoRepository = ProdutoRepository.getInstancia();
    }

    public void adicionarItem(int idPedido, int idProduto, int quantidade) {
        Pedido pedido = pedidoRepository.buscarPedido(idPedido);
        if (pedido != null) {
            Produto produto = produtoRepository.buscarProduto(idProduto);
            if (produto != null) {
                try {
                    ItemPedido item = new ItemPedido(produto, quantidade, produto.getValorDeVenda());
                    pedido.adicionarItem(item);
                    pedidoRepository.salvar(pedido);
                    System.out.println("Item adicionado ao pedido.");
                } catch (IllegalStateException | IllegalArgumentException e) {
                    System.out.println("Erro ao adicionar item: " + e.getMessage());
                }
            } else {
                System.out.println("Produto não encontrado.");
            }
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    public void removerItem(Pedido pedido, int idProduto){
        Produto produto = produtoRepository.buscarProduto(idProduto);
        if (produto != null) {
            try {
                ItemPedido item = new ItemPedido(produto, 0, 0);
                pedido.removerItem(item);
                pedidoRepository.salvar(pedido);
                System.out.println("Item removido do pedido.");
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("Erro ao remover item: " + e.getMessage());
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void alterarQuantidade(int idPedido, int idProduto, int novaQuantidade) {
        Pedido pedido = pedidoRepository.buscarPedido(idPedido);
        if (pedido != null) {
            Produto produto = produtoRepository.buscarProduto(idProduto);
            if (produto != null) {
                ItemPedido item = new ItemPedido(produto, 0, 0);
                while (true) {
                    try {
                        System.out.println("Digite a nova quantidade: ");
                        novaQuantidade = scanner.nextInt();
                        scanner.nextLine();
                        pedido.alterarQuantidade(item, novaQuantidade);
                        pedidoRepository.salvar(pedido);
                        System.out.println("Quantidade alterada com sucesso.");
                        return;
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, digite um número inteiro.");
                        scanner.nextLine();
                    } catch (IllegalStateException e) {
                        System.out.println("Erro ao alterar quantidade do item: " + e.getMessage());
                    }
                }
            } else {
                System.out.println("Produto não encontrado.");
            }
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    public void finalizarPedido(int idPedido){
        Pedido pedido = pedidoRepository.buscarPedido(idPedido);
        if (pedido != null) {
            try {
                if (pedido.podeFinalizar()) {
                    pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
                    Notificacao.enviarNotificacao("Pedido aguardando pagamento. Total: R$ " + pedido.getValorTotal());
                    pedidoRepository.salvar(pedido);
                    System.out.println("Pedido finalizado com sucesso.");
                } else {
                    throw new IllegalStateException("Não foi possível finalizar o pedido. Verifique se o pedido está aberto, se há itens e se o valor total é maior que zero.");
                }
            } catch (IllegalStateException e) {
                System.out.println("Erro ao finalizar pedido: " + e.getMessage());
            }
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    public void pagar(int idPedido) {
        Pedido pedido = pedidoRepository.buscarPedido(idPedido);
        if (pedido != null) {
            try {
                if (pedido.getStatus() == StatusPedido.AGUARDANDO_PAGAMENTO) {
                    pedido.setStatus(StatusPedido.PAGO);
                    Notificacao.enviarNotificacao("Pedido pago. Total: R$ " + pedido.getValorTotal());
                    pedidoRepository.salvar(pedido);
                    System.out.println("Pedido pago com sucesso.");
                } else {
                    throw new IllegalStateException("Não foi possível pagar o pedido. Verifique se o pedido está aguardando pagamento.");
                }
        } catch (IllegalStateException e) {
            System.out.println("Erro ao pagar pedido: " + e.getMessage());
        }
    } else {
        System.out.println("Pedido não encontrado.");
        }
    }

    public void entregar(int idPedido){
        Pedido pedido = pedidoRepository.buscarPedido(idPedido);
        if (pedido != null) {
            try {
                if (pedido.getStatus() == StatusPedido.PAGO) {
                    pedido.setStatus(StatusPedido.FINALIZADO);
                    Notificacao.enviarNotificacao("Pedido entregue.");
                    pedidoRepository.salvar(pedido);
                    System.out.println("Pedido entregue com sucesso.");
                } else {
                    throw new IllegalStateException("Não foi possível entregar o pedido. Verifique se o pedido está pago.");
                }
            } catch (IllegalStateException e) {
                System.out.println("Erro ao entregar pedido: " + e.getMessage());
            }
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }
}
