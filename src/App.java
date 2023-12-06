import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    //Nessa classe que vai ficar toda a lógica do negocio
    // Ela contém o método Main() onde o programa começa a ser executado

    static Scanner ler = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    static ArrayList<Imovel> imoveis = new ArrayList<Imovel>();


    public static void main(String[] args) {
        //Scanner ler = new Scanner(System.in)
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

    public static void subMenu(int gestao){
        int op;
        do{
            if(gestao == 1){
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
                    incluirClienteImovel(gestao);
                break;

                case 2:
                    consultarClienteImovel(gestao);
                break;

                case 3:
                    listarImovelCliente(gestao);
                break;

                case 4:
                    excluirClienteImovel(gestao);
                break;

                case 5:
                    alterarClienteImovel(gestao);
                break;

                case 0:
                break;

                default:
                    System.out.println("Ops... Opcao invalida!");
            }
        }while(op != 0);
    }

    public static void incluirClienteImovel(int gestao){
        if(gestao == 1){
            String nome, cpf, matricula;
            int escolha;
            ler.nextLine();

            System.out.println("Infome o nome do cliente: ");
            nome = ler.nextLine();

            System.out.println("Infome o cpf do cliente: ");
            cpf = ler.nextLine();

            Cliente cliente = new Cliente (nome, cpf);
            clientes.add(cliente);
            while (true){
                System.out.println("Escolha qual imovel vc deseja: ");
                listarImovelCliente(2);
                matricula = ler.nextLine();
                int retorno = buscaImovel(matricula);
                if( retorno != -1){
                    cliente.adicionarImovel(imoveis.get(retorno));
                    System.out.println("Deseja adquirir outro imovel? 1-SIM/2-NAO");
                    escolha = ler.nextInt();
                    if(escolha != 1){
                        break;
                    }
                }else{
                    System.out.println("Imovel invalido!");
                }

            }

        }else{
            String matricula, endereco;
            double ultimaLeitura,penultimaLeitura;
            ler.nextLine();

            System.out.println("Informe a matricula do imovel: ");
            matricula = ler.nextLine();

            System.out.println("Informe o endereco do imovel: ");
            endereco = ler.nextLine();

            System.out.println("Informe o valor da ultima leitura: ");
            ultimaLeitura = ler.nextDouble();

            System.out.println("Informe o valor da penultima leitura: ");
            penultimaLeitura = ler.nextDouble();

            Imovel imovel = new Imovel(matricula, endereco, ultimaLeitura, penultimaLeitura);
            imoveis.add(imovel);
        }
    }

    public static void listarImovelCliente(int gestao){
        if(gestao == 1){
            for(Cliente cl : clientes){
                System.out.println("Nome: " + cl.getNome());
                System.out.println("CPF: " + cl.getCpf());
                System.out.println("Imoveis que "+ cl.getNome() +" possui: ");
                if(cl.getImoveisCliente().isEmpty()){
                    System.out.println("Nao possui nenhum imovel!");
                    System.out.println("----------------------------");
                }else{
                    for(int i = 0; i<cl.getImoveisCliente().size(); i++){
                        System.out.println("Matricula: "+ cl.getImoveisCliente().get(i).getMatricula());
                        System.out.println("Endereco: "+ cl.getImoveisCliente().get(i).getEndereco());
                        System.out.println("----------------------------------");
                    }
                }
            }
        }else{
            for(int i = 0; i<imoveis.size(); i++){
                System.out.println("Matricula: "+ imoveis.get(i).getMatricula());
                System.out.println("Endereco: "+ imoveis.get(i).getEndereco());
                System.out.println("----------------------------------");
            }
        }
    }

    public static void consultarClienteImovel(int gestao){
        if(gestao == 1){
            String cpf;
            ler.nextLine();

            System.out.println("Informe o cpf do cliente que deseja consultar: ");
            cpf = ler.nextLine();

            int retono = buscaCliente(cpf);
            if(retono != -1){
                System.out.println("Nome: " + clientes.get(retono).getNome());
                System.out.println("CPF: " + clientes.get(retono).getCpf());
                if(clientes.get(retono).getImoveisCliente().isEmpty()){
                    System.out.println("Nao possui nenhum imovel");
                }else{
                    System.out.println("Imoveis que possui: ");
                    for(int i = 0; i<clientes.get(retono).getImoveisCliente().size(); i++){
                        System.out.println("Matricula: "+ clientes.get(retono).getImoveisCliente().get(i).getMatricula());
                        System.out.println("Endereco: "+ clientes.get(retono).getImoveisCliente().get(i).getEndereco());
                        System.out.println("----------------------------------");
                    }
                }
            }else{
                System.out.println("Cliente nao encontrado");
            }

        }else{
            String matricula;
            ler.nextLine();

            System.out.println("Informe a matricula do imovel que deseja consultar: ");
            matricula = ler.nextLine();

            int retorno =  buscaImovel(matricula);
            if(retorno != -1){
                System.out.println("Matricula: " + imoveis.get(retorno).getMatricula());
                System.out.println("Endereco: " + imoveis.get(retorno).getEndereco());
            }else{
                System.out.println("Imovel nao encontrado");
            }
        }
    }

    public static void excluirClienteImovel(int gestao){
        if(gestao == 1){
            String cpf;
            ler.nextLine();

            System.out.println("Informe o cpf do cliente que deseja excluir: ");
            cpf = ler.nextLine();

            int retorno = buscaCliente(cpf);
            if(retorno != -1){
                clientes.remove(retorno);
                System.out.println("Cliente Removido com Sucesso!");
            }else{
                System.out.println("Cliente não encontrado");
            }
        }else{
            String matricula;
            ler.nextLine();

            System.out.println("Informe a matricula do imovel que deseja excluir: ");
            matricula = ler.nextLine();

            int retorno =  buscaImovel(matricula);
            if(retorno != -1){
                //Remover o imovel de clientes tbm
                for(int i = 0; i<clientes.size(); i++){
                    for(int j = 0; j<clientes.get(i).getImoveisCliente().size(); j++){
                        if(clientes.get(i).getImoveisCliente().get(j).equals(imoveis.get(retorno))){
                            clientes.get(i).getImoveisCliente().remove(j);
                        }
                    }
                }
                //removendo o imovel da lista
                imoveis.remove(retorno);
                System.out.println("Imovel Removido com Sucesso!");
            }else{
                System.out.println("Imovel não encontrado");
            }
        }
    }

    public static void alterarClienteImovel(int gestao){
        if(gestao == 1){
            String cpf, novoNome;
            ler.nextLine();

            System.out.println("Informe o cpf do cliente que deseja alterar: ");
            cpf = ler.nextLine();

            int retono = buscaCliente(cpf);
            if(retono != -1){
                int escolha;
                System.out.println("Deseja alterar o nome do cliente ? 1-SIM/2-NAO");
                escolha = ler.nextInt();
                ler.nextLine();

                if(escolha == 1){
                    System.out.println("Informe o novo nome do cliente: ");
                    novoNome = ler.nextLine();
                    clientes.get(retono).setNome(novoNome);
                    System.out.println("Dados aletrados com sucesso!");
                }
            }else{
                System.out.println("Cliente nao encontrado");
            }

        }else{
            String matricula;
            ler.nextLine();

            System.out.println("Informe a matricula do imovel que deseja alterar: ");
            matricula = ler.nextLine();

            int retorno =  buscaImovel(matricula);
            if(retorno != -1){
                int escolha;
                System.out.println("Deseja alterar o endereco do imovel? 1-SIM/2-NAO");
                escolha = ler.nextInt();
                ler.nextLine();
                if(escolha == 1){
                    String novoEndereco;
                    System.out.println("Informe o novo endereco: ");
                    novoEndereco = ler.nextLine();

                    //Alterando em todos os clientes
                    for(int i = 0; i<clientes.size(); i++){
                        for(int j = 0; j<clientes.get(i).getImoveisCliente().size(); j++){
                            if(clientes.get(i).getImoveisCliente().get(j).equals(imoveis.get(retorno))){
                                clientes.get(i).getImoveisCliente().get(j).setEndereco(novoEndereco);
                            }
                        }
                    }

                    //Alerando na lista de imoveis
                    imoveis.get(retorno).setEndereco(novoEndereco);
                    System.out.println("Dados alterados com sucesso!");
                }
            }
        }
    }

    public static int buscaImovel(String matricula){
        for(int i = 0; i<imoveis.size(); i++){
            if(imoveis.get(i).getMatricula().equals(matricula)){
                return i;
            }
        }
        return -1;
    }

    public static int buscaCliente(String cpf){
        for(int i = 0; i<clientes.size(); i++){
            if(clientes.get(i).getCpf().equals(cpf)){
                return i;
            }
        }
        return -1;
    }

}
