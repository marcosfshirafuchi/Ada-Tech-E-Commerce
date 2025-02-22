package Clientes;

public class EscolhaSiglaDeEstado {
    public static void imprimirSiglaDosEstadosBrasileiros(){
        System.out.println("\n1 - Acre (AC)\n" +
                "2 - Alagoas (AL)\n" +
                "3 - Amapá (AP)\n" +
                "4 - Amazonas (AM)\n" +
                "5 - Bahia (BA)\n" +
                "6 - Ceará (CE)\n" +
                "7 - Distrito Federal (DF)\n" +
                "8 - Espírito Santo (ES)\n" +
                "9 - Goiás (GO)\n" +
                "10 - Maranhão (MA)\n" +
                "11 - Mato Grosso (MT)\n" +
                "12 - Mato Grosso do Sul (MS)\n" +
                "13 - Minas Gerais (MG)\n" +
                "14 - Pará (PA)\n" +
                "15 - Paraíba (PB)\n" +
                "16 - Paraná (PR)\n" +
                "17 - Pernambuco (PE)\n" +
                "18 - Piauí (PI)\n" +
                "19 - Rio de Janeiro (RJ)\n" +
                "20 - Rio Grande do Norte (RN)\n" +
                "21 - Rio Grande do Sul (RS)\n" +
                "22 - Rondônia (RO)\n" +
                "23 - Roraima (RR)\n" +
                "24 - Santa Catarina (SC)\n" +
                "25 - São Paulo (SP)\n" +
                "26 - Sergipe (SE)\n" +
                "27 - Tocantins (TO)");
    }

    public static EstadosBrasil buscarEstadoBrasileiroEscolhido(int codigo){
        EstadosBrasil estado = null;
        switch (codigo){
            case 1 :
                estado = EstadosBrasil.ACRE;
                break;
            case 2 :
                estado = EstadosBrasil.ALAGOAS;
                break;
            case 3 :
                estado = EstadosBrasil.AMAPA;
                break;
            case 4:
                estado = EstadosBrasil.AMAZONAS;
                break;
            case 5 :
                estado = EstadosBrasil.BAHIA;
                break;
            case 6 :
                estado = EstadosBrasil.CEARA;
                break;
            case 7 :
                estado = EstadosBrasil.DISTRITO_FEDERAL;
                break;
            case 8 :
                estado = EstadosBrasil.ESPIRITO_SANTO;
                break;
            case 9 :
                estado = EstadosBrasil.GOIAS;
                break;
            case 10 :
                estado = EstadosBrasil.MARANHAO;
                break;
            case 11 :
                estado = EstadosBrasil.MATO_GROSSO;
                break;
            case 12 :
                estado = EstadosBrasil.MATO_GROSSO_DO_SUL;
                break;
            case 13 :
                estado = EstadosBrasil.MINAS_GERAIS;
                break;
            case 14 :
                estado = EstadosBrasil.PARA;
                break;
            case 15 :
                estado = EstadosBrasil.PARAIBA;
                break;
            case 16 :
                estado = EstadosBrasil.PARANA;
                break;
            case 17 :
                estado = EstadosBrasil.PERNAMBUCO;
                break;
            case 18 :
                estado = EstadosBrasil.PIAUI;
                break;
            case 19 :
                estado = EstadosBrasil.RIO_DE_JANEIRO;
                break;
            case 20 :
                estado = EstadosBrasil.RIO_GRANDE_DO_NORTE;
                break;
            case 21 :
                estado = EstadosBrasil.RIO_GRANDE_DO_SUL;
                break;
            case 22 :
                estado = EstadosBrasil.RONDONIA;
                break;
            case 23 :
                estado = EstadosBrasil.RORAIMA;
                break;
            case 24 :
                estado = EstadosBrasil.SANTA_CATARINA;
                break;
            case 25 :
                estado = EstadosBrasil.SAO_PAULO;
                break;
            case 26 :
                estado = EstadosBrasil.SERGIPE;
                break;
            case 27 :
                estado = EstadosBrasil.TOCANTINS;
                break;
        }
        return estado;
    }
}
