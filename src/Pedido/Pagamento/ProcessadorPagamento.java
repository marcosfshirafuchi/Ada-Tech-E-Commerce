package Pedido.Pagamento;

import Pedido.Pedido;

public class ProcessadorPagamento {

    public void processarPagamento(Pedido pedido, int opcaoPagamento) {
        formaDePagamento formaDePagamento;

        switch (opcaoPagamento) {
            case 1:
                formaDePagamento = new PagamentoCartao();
                break;
            case 2:
                formaDePagamento = new PagamentoPix();
                break;
            default:
                System.out.println("Opção de pagamento inválida.");
                return;
        }

        formaDePagamento.processarPagamento(pedido);
    }
}
