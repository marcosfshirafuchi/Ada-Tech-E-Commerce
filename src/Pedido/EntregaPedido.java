package Pedido;

import BancoDeDados.BancoDeDadosPedidos;

public class EntregaPedido {
    private BancoDeDadosPedidos bancoDeDadosPedidos;

    public EntregaPedido() {
        this.bancoDeDadosPedidos = BancoDeDadosPedidos.getInstancia();
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
