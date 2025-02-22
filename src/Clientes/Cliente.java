package Clientes;

public abstract class Cliente {
    private String nome;
    private String documento;
    private Endereco endereco;
    private String telefone;
    private String tipoDeCliente;

    public Cliente(){

    }
    public Cliente(String nome, String documento, Endereco endereco, String telefone,String tipoDeCliente) {
        this.nome = nome;
        this.documento = documento;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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
                ", documento='" + documento + '\'' +
                ", endereco=" + endereco +
                ", telefone='" + telefone + '\'' +
                ", tipoDeCliente='" + tipoDeCliente + '\'' +
                '}';
    }
}
