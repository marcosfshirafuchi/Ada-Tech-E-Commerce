package Pedido.Pagamento;

import Pedido.Pedido;

public class PagamentoPix extends formaDePagamento {

    @Override
    protected String getMensagemPagamento(Pedido pedido) {
        return "Pedido pago com Pix. Total: R$ " + pedido.getValorTotal();
    }
}
