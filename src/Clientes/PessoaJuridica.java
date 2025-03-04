package Clientes;

public class PessoaJuridica extends Cliente {

    public PessoaJuridica() {
    }

    public PessoaJuridica(int idCliente, String nome, String numeroDoDocumento, Endereco endereco, String telefone, String email,String tipoDeCliente) {
        super(idCliente, nome, numeroDoDocumento, endereco, telefone, email,tipoDeCliente);
    }

    @Override
    public String formatarNumeroDeDocumentoFormatado(String numeroDodocumento) {
        return(numeroDodocumento.substring(0, 2) + "." + numeroDodocumento.substring(2, 5) + "." +
                numeroDodocumento.substring(5, 8) + "." + numeroDodocumento.substring(8, 12) + "-" +
                numeroDodocumento.substring(12, 14));
    }
}