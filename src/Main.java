import java.util.Scanner;

import static FuncoesDaMain.FuncoesDaMain.*;

public class Main {
    /**
     * <h1> Desenvolva + | #1322 - Projeto de POO 2:
     * Ada Commerce - E-Commerce  </h1>
     * <br>Descrição Geral<br><br>
     * A Ada tech pretendo realizar a venda de produtos através de um E-Commerce e, para isso, nos
     * contratou com a finalidade de desenvolvermos todo o fluxo necessário. Nesse E-Commerce temos
     * algumas necessidades que serão descritas abaixo.<br><br>
     * • Cadastrar, listar, atualizar os clientes da base. Não é necessário a ação de excluir clientes,
     * pois esses devem permanecer na base como histórico.<br><br>
     * • Cadastrar, listar, atualizar os produtos da base. Não é necessário a ação de excluir produtos,
     * pois esses devem permanecer na base como histórico.<br><br>
     * • Criar uma venda para um cliente. Nessa venda deve ser possível: Adicionar item (produto)
     * com quantidade e preço, remover item (produto), alterar quantidade do item (produto),
     * realizar o pagamento e a entrega.<br><br>
     * Regras importantes que foram levantadas junto ao nosso cliente.<br><br>
     * • Todo cliente cadastrado precisa ter o documento de identificação.<br><br>
     * • Um pedido sempre deve ter a data em que foi criado.<br><br>
     * • Um pedido sempre deve iniciar com o status igual a aberto.<br><br>
     * • Pedidos com status igual a aberto podem receber itens (produto), alterar quantidade e
     * remover item.<br><br>
     * • Os produtos adicionados ao pedido devem ter um valor de venda informado, pois esse valor
     * pode ser diferente do valor do produto.<br><br>
     * • Para que o cliente possa realizar a ação de finalizar o pedido, o pedido deve ter ao menos um
     * item e o valor deve ser maior que zero. Também deve-se alterar o status do pagamento para:
     * "Aguardando pagamento" e notificar o cliente via e-mail.<br><br>
     * • A ação de pagar deve acontecer apenas sobre vendas que estejam com o status igual a
     * "Aguardando pagamento" e, após o pagamento acontecer com sucesso, deve-se alterar o
     * status do pagamento para "Pago" e, também, notificar o cliente.<br><br>
     * • Após o pagamento realizado o pedido pode ser entregue ao cliente e o status alterado para
     * "Finalizado". Não esqueça de notificar o cliente sobre a entrega.<br><br>
     * Dicas importantes para o desenvolvimento do projeto.<br><br>
     * • Lembra-se de utilizar os conceitos aprendidos em sala de aula. Os princípios de orientação a
     * objetos e também de SOLID.<br><br>
     * • Nesse momento podemos trabalhar com uma base de dados em memória, afim de
     * simplificar o exercício. Porém, se desejar, faça a persistência em arquivos. Item bônus, não
     * obrigatório.<br><br>
     * Entrega. <br><br>
     * • Entregar o link do repositório do projeto no GitHub. <br><br>
     * <p>
     * <b>Note:</b> Desenvolvido na linguagem Java.
     *
     * @authors
     * Alan Cleber<br>
     * Aline Wornath<br>
     * Marcos Ferreira Shirafuchi<br>
     * @version 1.0
     * @since 06/03/2025
     */
    public static int obterOpcaoValida(Scanner scanner) {
        while (true) {
            String entrada = scanner.nextLine();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("\n------------------------------");
                System.out.println("Entrada inválida! Digite um número válido.");
                System.out.println("------------------------------\n");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("**************Ada Commerce - E-Commerce**************\n");

        int opcao;
        boolean loop = true;

        while(loop) {
            System.out.println("Escolha o tipo de serviço que deseja executar: \n");

            System.out.println("1 - Menu de Cliente");
            System.out.println("2 - Menu de Produto");
            System.out.println("3 - Menu de Pedido");
            System.out.println("4 - Sair do sistema \n");

            System.out.print("Digite a opção desejada: ");
            opcao = obterOpcaoValida(scanner);

            switch (opcao){
                case 1:
                    System.out.println("");
                    escolherCadastroCliente();
                    break;
                case 2:
                    escolherCadastroProduto();
                    break;
                case 3:
                    escolherCadastroPedido();
                    break;
                case 4:
                    System.out.println("**********Lista de clientes cadastrados**********");
                    System.out.println("Saindo do sistema.");
                    loop = false;
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
                    System.out.println("------------------------------");
            }
        }
    }
}