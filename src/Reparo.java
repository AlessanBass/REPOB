import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Reparo {
   private String descricao;
    private Date previsao;
    private Date datainicio;
    private Date datafim;
    private boolean resolvido;
    Reparo reparo;

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getDataFim() {
        return datafim;
    }
    public void setDataFim(Date datafim) {
        this.datafim = datafim;
    }
    public Date getDataInicio() {
        return datainicio;
    }
    public void setDataInicio(Date datainicio) {
        this.datainicio = datainicio;
    }
    public Date getPrevisao() {
        return previsao;
    }
    public void setPrevisao(Date previsao) {
        this.previsao = previsao;
    }
    public boolean getResolvido(){
        return this.resolvido;
    }
    public void setResolvido(boolean resolvido){
        this.resolvido = resolvido;
    }
    public Reparo(String descricao, Date previsao){
        this.descricao = descricao;
        this.previsao = previsao;
        this.datainicio = new Date();
        this.resolvido = false;
        this.reparo = null;
    }

    public void novoReparo(ArrayList<Reparo> reparos) throws ParseException{
        String descricao;
        Date previsao;
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Insira a descrição do novo reparo:");
            descricao = sc.nextLine();
            System.out.println("Qual a previsão para a conclusão do reparo?");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            previsao = formato.parse(sc.nextLine());
            this.reparo = new Reparo(descricao, previsao);
            reparos.add(this.reparo);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
