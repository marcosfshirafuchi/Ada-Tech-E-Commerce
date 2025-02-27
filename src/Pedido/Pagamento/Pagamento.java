package Pedido.Pagamento;

import Pedido.Notificacao.Notificacao;
import Pedido.Pedido;
import Pedido.StatusPedido;

public class Pagamento {
    private Pedido pedido;
    private StatusPagamento status;


    public Pagamento(Pedido pedido) {
        this.pedido = pedido;
        this.status = StatusPagamento.PENDENTE;
    }

    public void processarPagamento() {
        if (pedido.getStatus() == StatusPedido.AGUARDANDO_PAGAMENTO) {
            pedido.setStatus(StatusPedido.PAGO);
            status = StatusPagamento.APROVADO;
            Notificacao.enviarNotificacao("Pedido pago. Total: R$ " + pedido.getValorTotal());
        } else {
            System.out.println("Não foi possível pagar o pedido. Verifique se o pedido está aguardando pagamento.");
        }
    }
}