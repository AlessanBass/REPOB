import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FalhaDistribuicao extends Falha {
  private ArrayList<Reparo> reparos;

    public FalhaDistribuicao(String descricao, Date previsao) {
        super(descricao, previsao);
        reparos = new ArrayList<>();
    }

    public void adicionarReparo() throws ParseException{
        String descricao;
        Date previsao;
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Descreva a ação para corrigir o problema:");
            descricao = sc.nextLine();
            System.out.println("Informe a previsão de conclusão do reparo no formato: dd/mm/aaaa");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            previsao = formato.parse(sc.nextLine());
            Reparo reparo = new Reparo(descricao, previsao);
            this.reparos.add(reparo);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void listarReparo(){
        for(Reparo reparo : this.reparos){
            if(!reparo.getResolvido()){
                System.out.println("Descrição: " + reparo.getDescricao());
                System.out.println("Início: " + reparo.getDataInicio());
                System.out.println("Previsão: " + reparo.getPrevisao());
            }
        }
    }
  
    public void encerrarReparo(){
          Scanner sc = new Scanner(System.in);
          int op, indice, i;
          try{
              i = 0;
              for(Reparo reparo : this.reparos){
                  if(!reparo.getResolvido()){
                      i++;
                      System.out.println("Reparo: " + i);
                      System.out.println("Descrição: " + reparo.getDescricao());
                      System.out.println("Início: " + reparo.getDataInicio());
                      System.out.println("Previsão: " + reparo.getPrevisao());
                  }
              }
              System.out.println("Digite o reparo que deseja terminar:");
              indice = sc.nextInt();
              if(indice < 0 || indice > i){
                  throw new Exception("Não há correspondências.");
              }
              else{
                  i = 0;
                  for(Reparo reparo : this.reparos){
                      if(!reparo.getResolvido()){
                          i++;
                          if(i == indice){
                              reparo.setDataFim(new Date());
                              System.out.println("O reparo foi finalizado? 1-Sim 2-Não");
                              op = sc.nextInt();
                              sc.nextLine();
                              if(op == 1)
                                  reparo.setResolvido(true);
                              if(op == 2){
                                  System.out.println("Gostaria de iniciar um novo reparo? 1-Sim 2-Não");
                                  op = sc.nextInt();
                                  sc.nextLine();
                                  if(op == 1)
                                      reparo.newReparo(this.reparos);
                              }
                          }
                      }
                  }
              }
          }
          catch(Exception ex){
              System.out.println(ex.getMessage());
          }
      }
}
