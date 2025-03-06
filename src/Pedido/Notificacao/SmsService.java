package Pedido.Notificacao;

import Clientes.Cliente;

public class SmsService implements CommunicationServices {
    @Override
    public void enviarMensagem(Cliente cliente, String mensagem) {
        System.out.println("Notificando cliente por SMS no telefone " + cliente.getTelefone() + ": " + mensagem);
    }
}
