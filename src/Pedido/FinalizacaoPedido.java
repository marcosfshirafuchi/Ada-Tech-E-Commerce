package Pedido;

import Frete.CalculadoraFrete;
import BancoDeDados.BancoDeDadosPedidos;
import Pedido.PedidoService;

public class FinalizacaoPedido {
    private BancoDeDadosPedidos bancoDeDadosPedidos;
    private CalculadoraFrete calculadoraFrete;
    private PedidoService pedidoService = new PedidoService();

    public FinalizacaoPedido(CalculadoraFrete calculadoraFrete) {
        this.bancoDeDadosPedidos = BancoDeDadosPedidos.getInstancia();
        this.calculadoraFrete = calculadoraFrete;
    }

    public void finalizarPedido(Pedido pedido) {
        try {
            if (pedido.podeFinalizar()) {
                double frete = calculadoraFrete.calcularFrete(CalculadoraFrete.REMETENTE, pedido.getCliente());
                double valorComDesconto = pedidoService.aplicarDesconto(pedido, pedido.getDesconto());
                pedido.alterarStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
                pedido.enviarNotificacao(pedido.getCliente(), "Pedido aguardando pagamento. Total: R$ " + String.format("%.2f", valorComDesconto));
                bancoDeDadosPedidos.salvar(pedido);
                System.out.println("Valor dos itens: R$ " + String.format("%.2f", pedido.getValorTotal()));
                System.out.println("Valor do frete: R$ " + String.format("%.2f", frete));
                System.out.println(pedido.getDesconto().toString());
                System.out.println("Valor total a pagar: R$ " + String.format("%.2f", valorComDesconto + frete));
            } else {
                throw new IllegalStateException("Não foi possível finalizar o pedido. Verifique se o pedido está aberto, se há itens e se o valor total é maior que zero.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Erro ao finalizar pedido: " + e.getMessage());
        }
    }
}
