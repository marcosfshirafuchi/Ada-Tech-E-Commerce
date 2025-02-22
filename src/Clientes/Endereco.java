package Clientes;

public class Endereco {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private EstadosBrasil estados;

    public Endereco(){

    }
    public Endereco(String cep, String logradouro, String numero, String complemento, String bairro, String cidade, EstadosBrasil estados) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estados = estados;
    }

    public Endereco(String cep, String logradouro, String numero, String bairro, String cidade, EstadosBrasil estados) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estados = estados;
    }



    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", Cidade='" + cidade + '\'' +
                ", estado= " + estados.getSigla() +
                '}';
    }
}
