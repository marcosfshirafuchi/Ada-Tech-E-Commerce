package Pedido.Notificacao;

import Clientes.Cliente;

public class WhatsappService implements CommunicationServices {
    @Override
    public void enviarMensagem(Cliente cliente, String mensagem) {
        System.out.println("Notificando cliente por Whatsapp no telefone " + cliente.getTelefone() + ": " + mensagem);
    }
}
