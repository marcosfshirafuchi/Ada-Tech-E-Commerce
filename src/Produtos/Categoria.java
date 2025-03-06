package Produtos;

public enum Categoria {
    ELETRONICOS,
    LIVROS,
    ROUPAS;

    public static Categoria fromInt(int index) {
        switch (index) {
            case 1: return ELETRONICOS;
            case 2: return LIVROS;
            case 3: return ROUPAS;
            default: throw new IllegalArgumentException("Índice de categoria inválido: " + index);
        }
    }

    public static void printCategorias() {
        System.out.println("Escolha a categoria do produto:");
        System.out.println("1 - Eletrônicos");
        System.out.println("2 - Livros");
        System.out.println("3 - Roupas");
    }
}
