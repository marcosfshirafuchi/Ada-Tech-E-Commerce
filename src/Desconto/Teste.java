package Desconto;

public class Teste {
    public static void main(String[] args) {
        System.out.println(aplicarDesconto(100.0));

        //aplicarDesconto(100.0);

    }
    public static double aplicarDesconto(double valorPedido) {
        double valorDesconto = 10.0;
        return valorPedido - (valorPedido * valorDesconto / 100);

    }

}
