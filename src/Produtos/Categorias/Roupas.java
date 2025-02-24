package Produtos.Categorias;

import java.util.Arrays;
import java.util.List;

public class Roupas implements CategoriaProduto{
    public static final String NOME = "Roupas";
    private String nomeInformado;

    public Roupas(String nomeInformado) {
        this.nomeInformado = normalizar(nomeInformado);
    }

    @Override
    public String getNomeCategoria() {
        return isValid() ? NOME : nomeInformado;
    }

    @Override
    public boolean isValid() {
        List<String> nomesValidos = Arrays.asList("roupa");
        return nomesValidos.contains(nomeInformado);
    }

    private String normalizar(String texto) {
        if (texto == null) return "";
        return texto.toLowerCase().trim();
    }
}
