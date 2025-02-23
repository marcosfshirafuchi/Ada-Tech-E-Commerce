package Clientes;

public abstract class Cliente implements NumeroDeDocumentoFormatado {
    //private static int cont = 1;
    private int idCliente;
    private String nome;
    private String numeroDoDocumento;
    private Endereco endereco;
    private String telefone;
    private String tipoDeCliente;

    public Cliente(){

    }

    public Cliente(int idCliente, String nome, String numeroDoDocumento, Endereco endereco, String telefone, String tipoDeCliente) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.numeroDoDocumento = formatarNumeroDeDocumentoFormatado(numeroDoDocumento);
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipoDeCliente = tipoDeCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroDoDocumento() {
        return numeroDoDocumento;
    }

    public void setNumeroDoDocumento(String numeroDoDocumento) {
        this.numeroDoDocumento = numeroDoDocumento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoDeCliente() {
        return tipoDeCliente;
    }

    public void setTipoDeCliente(String tipoDeCliente) {
        this.tipoDeCliente = tipoDeCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", numeroDoDocumento='" + numeroDoDocumento + '\'' +
                ", endereco=" + endereco +
                ", telefone='" + telefone + '\'' +
                ", tipoDeCliente='" + tipoDeCliente + '\'' +
                '}';
    }
}
