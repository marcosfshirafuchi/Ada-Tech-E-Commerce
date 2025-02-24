package Pedido;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorPedidos {
    private static List<Pedido> pedidos = new ArrayList<Pedido>();

    public static void criarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void alterarStatus(Pedido pedido, StatusPedido novoStatus) {
        pedido.setStatus(novoStatus);
    }

    public void listarPedidos() {
        for(Pedido pedido : pedidos) {
            System.out.println("Pedido ID: " + pedido.getId() + "\nCliente: " + pedido.getCliente() + "\nStatus: " + pedido.getStatus());
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
