package Pedido;

import Clientes.Cliente;
import Frete.CalculadoraFrete;
import Pedido.Notificacao.Notificacao;
import Produtos.Produto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pedido {
    private int id;
    private Cliente cliente;
    private LocalDateTime dataCriacao;
    private List<ItemPedido> itens;
    private double valorTotal;
    private StatusPedido status;

    public Pedido(Cliente cliente, LocalDateTime dataCriacao, List<ItemPedido> itens, double valorTotal) {
        this.id = gerarId();
        this.cliente = cliente;
        this.dataCriacao = LocalDateTime.now();
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
        this.status = StatusPedido.ABERTO;
    }

    public int gerarId(){
        Random random = new Random();
        return random.nextInt(10000) + 1000;
    }
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public List<ItemPedido> getItens(){
        return itens;
    }

    public void setStatus(StatusPedido statusPedido) {
        this.status = statusPedido;
    }

    public void adicionarItem(Produto produto, int quantidade){
        try{
            if (status != StatusPedido.ABERTO){
                throw new IllegalStateException("Não é possível adicionar itens em um pedido que não está aberto.");
            }
            double valorDeVenda = produto.getValorDeVenda();
            ItemPedido item = new ItemPedido(produto, quantidade, valorDeVenda);
            itens.add(item);
            calcularTotal();
        } catch (IllegalStateException e){
            System.out.println("Erro ao adicionar item: " + e.getMessage());
        }
    }

    public void removerItem(Produto produto){
        try{
            if (status != StatusPedido.ABERTO){
                throw new IllegalStateException("Não é possível remover itens de um pedido que não está aberto.");
            }
            boolean removido = itens.removeIf(item -> item.getProduto().equals(produto));
            if (removido){
                calcularTotal();
            }
            else{
                throw new IllegalArgumentException("Produto não encontrado no pedido.");
            }
        } catch (IllegalStateException | IllegalArgumentException e){
            System.out.println("Erro ao remover item: " + e.getMessage());
        }
    }

    public void alterarQuantidade(Produto produto, int novaQuantidade){
        try{
            if (status != StatusPedido.ABERTO){
                throw new IllegalStateException("Não é possível alterar a quantidade de itens de um pedido que não está aberto.");
            }
            for (ItemPedido item : itens){
                if (item.getProduto().equals(produto)){
                    item.setQuantidade(novaQuantidade);
                    calcularTotal();
                    return;
                }
            }
            throw new IllegalArgumentException("\"Produto não encontrado no pedido.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Erro ao alterar quantidade: " + e.getMessage());
        }
    }

    public void calcularTotal(){
        for (ItemPedido item : itens){
           valorTotal = 0.0;
           valorTotal += item.calcularSubtotal();
        }
    }

    public double calcularFrete(CalculadoraFrete calculadoraFrete){
        return calculadoraFrete.calcularFrete(cliente);
    }

    public boolean podeFinalizar(){
        return status == StatusPedido.ABERTO && !itens.isEmpty() && valorTotal > 0;
    }

    public void finalizarPedido(){
        if (podeFinalizar()){
            status = StatusPedido.AGUARDANDO_PAGAMENTO;
            Notificacao.enviarNotificacao("Pedido aguardando pagamento. Total: R$ " + valorTotal);
        }
        else{
            System.out.println("Não foi possível finalizar o pedido. Verifique se o pedido está aberto, se há itens e se o valor total é maior que zero.");
        }
    }

    public void pagar(){
        if (status == StatusPedido.AGUARDANDO_PAGAMENTO){
            status = StatusPedido.PAGO;
            Notificacao.enviarNotificacao("Pedido pago. Total: R$ " + valorTotal);
        }
        else{
            System.out.println("Não foi possível pagar o pedido. Verifique se o pedido está aguardando pagamento.");
        }
    }

    public void entregar(){
        if (status == StatusPedido.PAGO){
            status = StatusPedido.FINALIZADO;
            Notificacao.enviarNotificacao("Pedido entregue.");
        }
        else{
            System.out.println("Não foi possível entregar o pedido. Verifique se o pedido está pago.");
        }
    }

}
