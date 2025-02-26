package Pedido.Notificacao;

public class WhatsappService implements CommunicationServices {
    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Notificando cliente por Whatsapp: " + mensagem);
    }
}
