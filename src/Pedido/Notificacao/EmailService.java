package Pedido.Notificacao;

import Clientes.Cliente;

public class EmailService implements CommunicationServices {
    @Override
    public void enviarMensagem(Cliente cliente, String mensagem) {
        System.out.println("Notificando cliente por E-mail, no e-mail " + cliente.getEmail() + ": "+ mensagem);
    }
}
