package Pedido.Notificacao;

import Clientes.Cliente;

public interface CommunicationServices {
    void enviarMensagem(Cliente cliente, String mensagem);
}
