package Clientes;

public enum TipoDeCliente {
    PESSOA_FISICA("Pessoa Física"),
    PESSOA_JURIDICA("Pessoa Juridica");

    private final String tipoDeCliente;


    TipoDeCliente(String tipoDeCliente) {
        this.tipoDeCliente = tipoDeCliente;
    }

    public String getTipoDeCliente() {
        return tipoDeCliente;
    }
}
