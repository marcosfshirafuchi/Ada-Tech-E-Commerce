package Clientes;

public class PessoaFisica extends Cliente{
    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String documento, Endereco endereco, String telefone, String tipoDeCliente) {
        super(nome, documento, endereco, telefone, tipoDeCliente);
    }
}
