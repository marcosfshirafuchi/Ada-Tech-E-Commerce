package Pedido.Notificacao;

public class EmailService implements CommunicationServices {
    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Notificando cliente por Email: " + mensagem);
    }
}
