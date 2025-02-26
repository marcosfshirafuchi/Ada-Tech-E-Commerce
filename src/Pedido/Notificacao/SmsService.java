package Pedido.Notificacao;

public class SmsService implements CommunicationServices {
    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Notificando cliente por SMS: " + mensagem);
    }
}
