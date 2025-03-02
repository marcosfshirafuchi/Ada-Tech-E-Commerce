package Frete;

import Clientes.Cliente;
import Clientes.Endereco;

public class FretePadrao implements CalculadoraFrete {
    @Override
    public double calcularFrete(String REMETENTE, Cliente cliente) {
        Endereco enderecoDestinatario = cliente.getEndereco();

        double valorBase = 10.0;

        int distanciaCep = Math.abs(Integer.parseInt(REMETENTE.substring(0, 2)) - Integer.parseInt(enderecoDestinatario.getCep().substring(0, 2)));
        return valorBase + (distanciaCep * 0.25);
    }
}
