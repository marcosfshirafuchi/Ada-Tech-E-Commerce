package Pedido;

import Frete.CalculadoraFrete;
import BancoDeDados.BancoDeDadosPedidos;

public class FinalizacaoPedido {
    private BancoDeDadosPedidos bancoDeDadosPedidos;
    private CalculadoraFrete calculadoraFrete;

    public FinalizacaoPedido(CalculadoraFrete calculadoraFrete) {
        this.bancoDeDadosPedidos = BancoDeDadosPedidos.getInstancia();
        this.calculadoraFrete = calculadoraFrete;
    }

    public void finalizarPedido(Pedido pedido) {
        try {
            if (pedido.podeFinalizar()) {
                double frete = calculadoraFrete.calcularFrete(CalculadoraFrete.REMETENTE, pedido.getCliente());
                pedido.alterarStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
                pedido.enviarNotificacao(pedido.getCliente(), "Pedido aguardando pagamento. Total: R$ " + pedido.getValorTotal());
                bancoDeDadosPedidos.salvar(pedido);
                System.out.println("Valor dos itens: R$ " + pedido.getValorTotal());
                System.out.println("Valor do frete: R$ " + frete);
                System.out.println("Valor total: R$ " + (pedido.getValorTotal() + frete));
            } else {
                throw new IllegalStateException("Não foi possível finalizar o pedido. Verifique se o pedido está aberto, se há itens e se o valor total é maior que zero.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Erro ao finalizar pedido: " + e.getMessage());
        }
    }
}
