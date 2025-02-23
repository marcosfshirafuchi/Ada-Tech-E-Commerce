package Clientes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class ConsultaCEP {

    public static boolean buscarEndereco(String cep) {
        return obterEndereco(cep) != null;
    }

    public static Endereco obterEndereco(String cep) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Valida o formato do CEP (com ou sem hífen)
            if (!cep.matches("^\\d{5}-?\\d{3}$")) {
                System.out.println("Formato de CEP inválido!");
                return null;
            }

            // Remove o hífen do CEP, se existir
            cep = cep.replace("-", "");

            // URL da API do ViaCEP
            String urlString = "https://viacep.com.br/ws/" + cep + "/json/";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Converte a resposta JSON em uma String
            String json = response.toString();

            // Verifica se o CEP é inválido
            if (json.contains("\"erro\"")) {
                System.out.println("CEP não encontrado.");
                return null;
            }

            // Extrai os dados manualmente
            String logradouro = extrairValor(json, "logradouro");
            String bairro = extrairValor(json, "bairro");
            String cidade = extrairValor(json, "localidade");
            String estado = extrairValor(json, "uf");


                return new Endereco(cep,logradouro,bairro,cidade,estado);

            // Retorna um objeto Endereco
           // return new Endereco2(cep,logradouro, numero, bairro, cidade, estado);

        } catch (Exception e) {
            System.out.println("Erro ao consultar o CEP: " + e.getMessage());
            return null;
        }

    }

    // Método para extrair valores do JSON manualmente
    private static String extrairValor(String json, String chave) {
        int startIndex = json.indexOf("\"" + chave + "\":");
        if (startIndex == -1) return "Não encontrado";

        startIndex += chave.length() + 3; // Pula a chave e os caracteres `":`
        int endIndex = json.indexOf("\",", startIndex);
        if (endIndex == -1) endIndex = json.indexOf("\"}", startIndex);

        return json.substring(startIndex, endIndex).replace("\"", "");
    }
}
