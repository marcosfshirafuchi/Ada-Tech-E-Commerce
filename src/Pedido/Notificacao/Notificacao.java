package Pedido.Notificacao;

public class Notificacao {
    private static CommunicationServices communicationServices;

    public Notificacao(CommunicationServices communicationServices) {
        this.communicationServices = communicationServices;
    }

    public static void enviarNotificacao(String mensagem) {
        communicationServices.enviarMensagem(mensagem);
    }
}
