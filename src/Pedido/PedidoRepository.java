package Pedido;

import java.time.format.DateTimeFormatter;
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
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos cadastrados.");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for(Pedido pedido : pedidos) {
            System.out.println("ID do Pedido: " + pedido.getId() + "\nCliente: " + pedido.getCliente() + "\nStatus: " + pedido.getStatus() + "\nData de criação: " + pedido.getDataCriacao().format(formatter) + "\nValor total: " + pedido.getValorTotal());
            System.out.println("Itens do pedido: ");
            for(ItemPedido item : pedido.getItens()) {
                System.out.println("ID do Produto: " + item.getProduto().getId()+ "\nProduto: " + item.getProduto().getNome() + "\nQuantidade: " + item.getQuantidade() + "\nPreço de venda: " + item.getPrecoDeVenda() + "\nSubtotal: " + item.getSubtotal());
                System.out.println("-------------------------------------------------");
            }
            System.out.println();
        }

    }

    public Pedido buscarPedido(int id) {
        for(Pedido pedido : pedidos) {
            if(pedido.getId() == id) {
                return pedido;
            }
        }
        System.out.println("Pedido não encontrado");
        return null;
    }

}
