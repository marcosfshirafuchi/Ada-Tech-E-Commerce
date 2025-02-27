package Pedido;

import Pedido.Notificacao.Notificacao;
import Produtos.Produto;

public class PedidoService {
    private PedidoRepository pedidoRepository;

    public PedidoService(){
        this.pedidoRepository = PedidoRepository.getInstancia();
    }

    public void adicionarItem(Pedido pedido, Produto produto, int quantidade){
        try{
            if (pedido.getStatus() != StatusPedido.ABERTO){
                throw new IllegalStateException("Não é possível adicionar itens em um pedido que não está aberto.");
            }
            double valorDeVenda = produto.getValorDeVenda();
            ItemPedido item = new ItemPedido(produto, quantidade, valorDeVenda);
            pedido.adicionarItem(item);
            pedidoRepository.salvar(pedido);
        } catch (IllegalStateException e){
            System.out.println("Erro ao adicionar item: " + e.getMessage());
        }
    }

    public void removerItem(Pedido pedido, ItemPedido item){
        try {
            if (pedido.getStatus() != StatusPedido.ABERTO) {
                throw new IllegalStateException("Não é possível remover itens de um pedido que não está aberto.");
            }
            pedido.removerItem(item);
            pedidoRepository.salvar(pedido);

        } catch (IllegalStateException e) {
            System.out.println("Erro ao remover item: " + e.getMessage());
        }
    }

    public void alterarQuantidade(Pedido pedido, ItemPedido item, int novaQuantidade) {
        try {
            if (pedido.getStatus() != StatusPedido.ABERTO) {
                throw new IllegalStateException("Não é possível alterar a quantidade de itens de um pedido que não está aberto.");
            }
            pedido.alterarQuantidade(item, novaQuantidade);
            pedidoRepository.salvar(pedido);
        } catch (IllegalStateException e) {
            System.out.println("Erro ao alterar quantidade do item: " + e.getMessage());
        }
    }

    public void finalizarPedido(Pedido pedido){
        try {
            if (pedido.podeFinalizar()) {
                pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
                Notificacao.enviarNotificacao("Pedido aguardando pagamento. Total: R$ " + pedido.getValorTotal());
                pedidoRepository.salvar(pedido);
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
                pedido.setStatus(StatusPedido.PAGO);
                Notificacao.enviarNotificacao("Pedido pago. Total: R$ " + pedido.getValorTotal());
                pedidoRepository.salvar(pedido);
            } else {
                throw new IllegalStateException("Não foi possível pagar o pedido. Verifique se o pedido está aguardando pagamento.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Erro ao pagar pedido: " + e.getMessage());
        }
    }

    public void entregar(Pedido pedido){
        try {
            if (pedido.getStatus() == StatusPedido.PAGO) {
                pedido.setStatus(StatusPedido.FINALIZADO);
                Notificacao.enviarNotificacao("Pedido entregue.");
                pedidoRepository.salvar(pedido);
            } else {
                throw new IllegalStateException("Não foi possível entregar o pedido. Verifique se o pedido está pago.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Erro ao entregar pedido: " + e.getMessage());
        }
    }
}
