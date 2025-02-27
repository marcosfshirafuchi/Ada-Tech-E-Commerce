package Pedido;

import Clientes.Cliente;
import Frete.CalculadoraFrete;

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

    public Pedido(Cliente cliente) {
        this.id = gerarId();
        this.cliente = cliente;
        this.dataCriacao = LocalDateTime.now();
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
        this.status = StatusPedido.ABERTO;
    }

    private int gerarId(){
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public List<ItemPedido> getItens(){
        return itens;
    }

    public void setStatus(StatusPedido statusPedido) {
        this.status = statusPedido;
    }


    public void adicionarItem(ItemPedido item) {
            if (status != StatusPedido.ABERTO) {
                throw new IllegalStateException("Não é possível adicionar itens em um pedido que não está aberto.");
            }

            itens.add(item);
            calcularTotal();
    }

    public void removerItem(ItemPedido item){
        if (status != StatusPedido.ABERTO) {
            throw new IllegalStateException("Não é possível remover itens de um pedido que não está aberto.");
            }
        if (itens.remove(item)) {
                calcularTotal();
                System.out.println("Item removido com sucesso.");
        } else {
                throw new IllegalArgumentException("Item não encontrado no pedido.");
        }
    }

    public void alterarQuantidade(ItemPedido item, int novaQuantidade){
            if (status != StatusPedido.ABERTO) {
                throw new IllegalStateException("Não é possível alterar a quantidade de itens de um pedido que não está aberto.");
            }

            for (ItemPedido i : itens){
                if (i.equals(item)) {
                    i.setQuantidade(novaQuantidade);
                    calcularTotal();
                    return;
                }
            }
                throw new IllegalArgumentException("Produto não encontrado no pedido.");
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

}
