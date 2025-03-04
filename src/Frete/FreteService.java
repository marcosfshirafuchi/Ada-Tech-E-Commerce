package Frete;

import Clientes.Cliente;

public class FreteService {
    private CalculadoraFrete calculadoraFrete;

    public FreteService(CalculadoraFrete calculadoraFrete) {
        this.calculadoraFrete = calculadoraFrete;
    }

    public double calcularFrete(Cliente cliente) {
        return calculadoraFrete.calcularFrete(CalculadoraFrete.REMETENTE, cliente);
    }
}
