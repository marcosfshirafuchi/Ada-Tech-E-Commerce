package Clientes;

public class PessoaFisica extends Cliente{
    public PessoaFisica() {
    }

    public PessoaFisica(int idCliente, String nome, String numeroDoDocumento, Endereco endereco, String telefone, String tipoDeCliente) {
        super(idCliente, nome, numeroDoDocumento, endereco, telefone, tipoDeCliente);
    }

    @Override
    public String formatarNumeroDeDocumentoFormatado(String numeroDodocumento) {
        return(numeroDodocumento.substring(0, 3) + "." + numeroDodocumento.substring(3, 6) + "." +
                numeroDodocumento.substring(6, 9) + "-" + numeroDodocumento.substring(9, 11));
    }
}
