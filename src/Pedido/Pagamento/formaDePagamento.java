package Pedido.Pagamento;

import BancoDeDados.BancoDeDadosPedidos;
import Pedido.Pedido;
import Pedido.StatusPedido;

public abstract class formaDePagamento {
    protected BancoDeDadosPedidos bancoDeDadosPedidos = BancoDeDadosPedidos.getInstancia();

    public void processarPagamento(Pedido pedido) {
        try {
            if (pedido.getStatus() == StatusPedido.AGUARDANDO_PAGAMENTO) {
                pedido.alterarStatus(StatusPedido.PAGO);
                pedido.enviarNotificacao(pedido.getCliente(), getMensagemPagamento(pedido));
                bancoDeDadosPedidos.salvar(pedido);
            } else {
                throw new IllegalStateException("Não foi possível pagar o pedido. Verifique se o pedido está aguardando pagamento.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Erro ao pagar pedido: " + e.getMessage());
        }
    }

    protected abstract String getMensagemPagamento(Pedido pedido);
}
