import java.util.Scanner;

public class App {
    //Nessa classe que vai ficar toda a lógica do negocio
    // Ela contém o método Main() onde o programa começa a ser executado
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int op;
        do {
            System.out.println(">>> MENU PRINCIPAL <<<");
            System.out.println("[1] GESTÃO CLIENTES");
            System.out.println("[2] GESTÃO IMOVEIS");
            System.out.println("[3] GESTÃO FATURAS");
            System.out.println("[4] GESTÃO PAGAMENTOS");
            System.out.println("[5] GESTÃO FALHAS");
            System.out.println("[0] SAIR");
            op = ler.nextInt();

            switch (op){
                case 1:
                    ler.nextLine();
                    subMenu(1);
                break;

                case 2:
                    ler.nextLine();
                    subMenu(2);
                break;

                case 3:
                    System.out.println("Em construcao");
                break;

                case 4:
                    System.out.println("Em construcao");
                break;

                case 5:
                    System.out.println("Em construcao");
                break;

                case 0:
                break;

                default:
                    System.out.println("Ops... Opcao invalida!");
            }


        }while(op != 0);
    }

    public static void subMenu(int gestão){
        Scanner ler = new Scanner(System.in);
        int op;
        do{
            if(gestão == 1){
                System.out.println(">>> GESTAO DE CLIENTES <<<");
            }else{
                System.out.println(">>> GESTAO DE IMOVEIS <<<");
            }
            System.out.println("[1] INCLUIR");
            System.out.println("[2] CONSULTAR");
            System.out.println("[3] LISTAR");
            System.out.println("[4] EXCLUIR");
            System.out.println("[5] ALTERAR");
            System.out.println("[0] SAIR");
            op = ler.nextInt();

            switch (op){
                case 1:

                break;

                case 2:

                break;

                case 3:
                    System.out.println("Em construcao");
                break;

                case 4:
                    System.out.println("Em construcao");
                break;

                case 5:
                    System.out.println("Em construcao");
                break;

                case 0:
                break;

                default:
                    System.out.println("Ops... Opcao invalida!");
            }
        }while(op != 0);
    }
}
