package Pedido.Pagamento;

import Pedido.Pedido;

public class PagamentoCartao extends formaDePagamento {

    @Override
    protected String getMensagemPagamento(Pedido pedido) {
        return "Pedido pago com cartão. Total: R$ " + pedido.getValorTotal();
    }
}