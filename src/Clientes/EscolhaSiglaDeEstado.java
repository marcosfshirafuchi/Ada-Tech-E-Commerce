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

    public static EstadosDoBrasil buscarEstadoBrasileiroEscolhido(int codigo){
        EstadosDoBrasil estado = null;
        switch (codigo){
            case 1 :
                estado = EstadosDoBrasil.ACRE;
                break;
            case 2 :
                estado = EstadosDoBrasil.ALAGOAS;
                break;
            case 3 :
                estado = EstadosDoBrasil.AMAPA;
                break;
            case 4:
                estado = EstadosDoBrasil.AMAZONAS;
                break;
            case 5 :
                estado = EstadosDoBrasil.BAHIA;
                break;
            case 6 :
                estado = EstadosDoBrasil.CEARA;
                break;
            case 7 :
                estado = EstadosDoBrasil.DISTRITO_FEDERAL;
                break;
            case 8 :
                estado = EstadosDoBrasil.ESPIRITO_SANTO;
                break;
            case 9 :
                estado = EstadosDoBrasil.GOIAS;
                break;
            case 10 :
                estado = EstadosDoBrasil.MARANHAO;
                break;
            case 11 :
                estado = EstadosDoBrasil.MATO_GROSSO;
                break;
            case 12 :
                estado = EstadosDoBrasil.MATO_GROSSO_DO_SUL;
                break;
            case 13 :
                estado = EstadosDoBrasil.MINAS_GERAIS;
                break;
            case 14 :
                estado = EstadosDoBrasil.PARA;
                break;
            case 15 :
                estado = EstadosDoBrasil.PARAIBA;
                break;
            case 16 :
                estado = EstadosDoBrasil.PARANA;
                break;
            case 17 :
                estado = EstadosDoBrasil.PERNAMBUCO;
                break;
            case 18 :
                estado = EstadosDoBrasil.PIAUI;
                break;
            case 19 :
                estado = EstadosDoBrasil.RIO_DE_JANEIRO;
                break;
            case 20 :
                estado = EstadosDoBrasil.RIO_GRANDE_DO_NORTE;
                break;
            case 21 :
                estado = EstadosDoBrasil.RIO_GRANDE_DO_SUL;
                break;
            case 22 :
                estado = EstadosDoBrasil.RONDONIA;
                break;
            case 23 :
                estado = EstadosDoBrasil.RORAIMA;
                break;
            case 24 :
                estado = EstadosDoBrasil.SANTA_CATARINA;
                break;
            case 25 :
                estado = EstadosDoBrasil.SAO_PAULO;
                break;
            case 26 :
                estado = EstadosDoBrasil.SERGIPE;
                break;
            case 27 :
                estado = EstadosDoBrasil.TOCANTINS;
                break;
        }
        return estado;
    }
}
