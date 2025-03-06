package BancoDeDados;

import Pedido.Pedido;
import Pedido.ItemPedido;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDadosPedidos implements BancoDeDados<Pedido> {
    private static BancoDeDadosPedidos instancia;
    private List<Pedido> pedidos;

    private BancoDeDadosPedidos() {
        pedidos = new ArrayList<>();
    }

    public static synchronized BancoDeDadosPedidos getInstancia() {
        if (instancia == null) {
            instancia = new BancoDeDadosPedidos();
        }
        return instancia;
    }

    @Override
    public void salvar(Pedido pedido) {
        pedidos.removeIf(p -> p.getId() == pedido.getId());
        pedidos.add(pedido);
    }

    @Override
    public void listarTodos() {
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos cadastrados.");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for(Pedido pedido : pedidos) {
            System.out.println("ID do Pedido: " + pedido.getId() + "\nCliente: " + pedido.getCliente() + "\nStatus: " + pedido.getStatus() + "\nData de criação: " + pedido.getDataCriacao().format(formatter) + "\nValor total: " + String.format("%.2f", pedido.getValorTotal()));
            System.out.println("Itens do pedido: ");
            for(ItemPedido item : pedido.getItens()) {
                System.out.println("ID do Produto: " + item.getProduto().getId()+ "\nProduto: " + item.getProduto().getNome() + "\nQuantidade: " + item.getQuantidade() + "\nPreço de venda: " + String.format("%.2f", item.getPrecoDeVenda()) + "\nSubtotal: " + String.format("%.2f", item.getSubtotal()));
                System.out.println("-------------------------------------------------");
            }
            System.out.println();
        }

    }

    public void listarPedidosSimplificado(){
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos cadastrados.");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for(Pedido pedido : pedidos) {
            System.out.println("ID do Pedido: " + pedido.getId() + "\nCliente: " + pedido.getCliente().getNome() + "\nData de criação: " + pedido.getDataCriacao().format(formatter));
            System.out.println();
        }
    }

    @Override
    public Pedido buscarPorId(int id) {
        for(Pedido pedido : pedidos) {
            if(pedido.getId() == id) {
                return pedido;
            }
        }
        System.out.println("Pedido não encontrado");
        return null;
    }

}
