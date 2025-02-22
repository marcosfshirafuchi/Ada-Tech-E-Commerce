package Produtos.Categorias;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;

public class Livros implements CategoriaProduto {
    public static final String NOME = "Livros";
    private String nomeInformado;

    public Livros(String nomeInformado) {
        this.nomeInformado = normalizar(nomeInformado);
    }

    @Override
    public String getNomeCategoria() {
        return isValid() ? NOME : nomeInformado;
    }

    @Override
    public boolean isValid() {
        List<String> nomesValidos = Arrays.asList("livro");
        return nomesValidos.contains(nomeInformado);
    }

    private String normalizar(String texto) {
        if (texto == null) return "";
        return texto.toLowerCase().trim();
    }
}
