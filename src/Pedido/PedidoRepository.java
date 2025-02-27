package Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private static PedidoRepository instancia;
    private List<Pedido> pedidos;

    private PedidoRepository() {
        pedidos = new ArrayList<>();
    }

    public static synchronized PedidoRepository getInstancia() {
        if (instancia == null) {
            instancia = new PedidoRepository();
        }
        return instancia;
    }

    public void salvar(Pedido pedido) {
        pedidos.removeIf(p -> p.getId() == pedido.getId());
        pedidos.add(pedido);
    }

    public void listarPedidos() {
        for(Pedido pedido : pedidos) {
            System.out.println("Pedido ID: " + pedido.getId() + "\nCliente: " + pedido.getCliente() + "\nStatus: " + pedido.getStatus() + "\nData de criação: " + pedido.getDataCriacao() + "\nValor total: " + pedido.getValorTotal());
        }
    }

    public Pedido buscarPedidoPorId(int id) {
        for(Pedido pedido : pedidos) {
            if(pedido.getId() == id) {
                return pedido;
            }
        }
        System.out.println("Pedido não encontrado");
        return null;
    }

}
