package Pedido;

import Clientes.Cliente;
import Frete.CalculadoraFrete;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorPedidos {
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public Pedido criarPedido(int id, Cliente cliente, String remetente, CalculadoraFrete calculadoraFrete) {
        Pedido pedido = new Pedido(cliente);
        pedidos.add(pedido);
        return pedido;
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
