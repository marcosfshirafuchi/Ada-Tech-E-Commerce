package Pedido.Notificacao;

public class Notificacao {
    private CommunicationServices communicationServices;

    public Notificacao(CommunicationServices communicationServices) {
        this.communicationServices = communicationServices;
    }

    public void enviarNotificacao(String mensagem) {
        communicationServices.enviarMensagem(mensagem);
    }
}
