package Frete;

import Clientes.Cliente;

public interface CalculadoraFrete {
    String REMETENTE = "12345-678";

    double calcularFrete(String REMETENTE, Cliente cliente);
}
