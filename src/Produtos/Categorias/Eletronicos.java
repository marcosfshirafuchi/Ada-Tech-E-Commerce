package Produtos.Categorias;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;

public class Eletronicos implements CategoriaProduto{
    public static final String NOME = "Eletrônicos";
    private String nomeInformado;

    public Eletronicos(String nomeInformado) {
        this.nomeInformado = normalizar(nomeInformado);
    }

    @Override
    public String getNomeCategoria() {
        return isValid() ? NOME : nomeInformado;
    }

    @Override
    public boolean isValid() {
        List<String> nomesValidos = Arrays.asList("eletronicos", "eletronico");
        return nomesValidos.contains(nomeInformado);
    }

    private String normalizar(String texto) {
        if (texto == null) return "";
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[^\\p{ASCII}]", "");
        return texto.toLowerCase().trim();
    }
}
