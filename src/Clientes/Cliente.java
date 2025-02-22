package Clientes;

public abstract class Cliente {
    private String nome;
    private String numeroDoDocumento;
    private Endereco endereco;
    private String telefone;
    private String tipoDeCliente;

    public Cliente(){

    }
    public Cliente(String nome, String documento, Endereco endereco, String telefone,String tipoDeCliente) {
        this.nome = nome;
        this.numeroDoDocumento = documento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipoDeCliente = tipoDeCliente;
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
                "nome='" + nome + '\'' +
                ", documento='" + numeroDoDocumento + '\'' +
                ", endereco=" + endereco +
                ", telefone='" + telefone + '\'' +
                ", tipoDeCliente='" + tipoDeCliente + '\'' +
                '}';
    }
}
