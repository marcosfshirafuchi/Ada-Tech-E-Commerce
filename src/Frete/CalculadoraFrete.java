package Frete;

import Clientes.Cliente;

public interface CalculadoraFrete {
    static String REMETENTE = "12345-678";

    double calcularFrete(String REMETENTE, Cliente cliente);
}
