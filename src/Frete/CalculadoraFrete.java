package Frete;

import Clientes.Cliente;
import Clientes.Endereco;

public class CalculadoraFrete {
    public double calcularFrete(Cliente destinatario) {
        Endereco enderecoDestinatario = destinatario.getEndereco();
        Endereco enderecoRemetente = destinatario.getEndereco();

        if (enderecoRemetente == null || enderecoDestinatario == null) {
            throw new IllegalArgumentException("Erro ao buscar os endereços, verifique se os endereços são válidos.");
        }

        double valorBase = 10.0;
        if (enderecoRemetente.getCep().equals(enderecoDestinatario.getCep())) {
            return 0.0;
        }

        int distanciaCep = Math.abs(Integer.parseInt(enderecoRemetente.getCep().substring(0, 2)) - Integer.parseInt(enderecoDestinatario.getCep().substring(0, 2)));
        return valorBase + (distanciaCep * 0.5);
    }
}