package Clientes;

public class PessoaJuridica extends Cliente {

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, String documento, Endereco endereco, String telefone, String tipoDeCliente) {
        super(nome, documento, endereco, telefone, tipoDeCliente);
    }
}