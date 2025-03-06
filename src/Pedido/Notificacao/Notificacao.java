package Pedido.Notificacao;

import Clientes.Cliente;

public class Notificacao {
    private CommunicationServices communicationServices;

    public Notificacao(CommunicationServices communicationServices) {
        this.communicationServices = communicationServices;
    }

    public void enviarNotificacao(Cliente cliente, String mensagem) {
        communicationServices.enviarMensagem(cliente, mensagem);
    }
}
