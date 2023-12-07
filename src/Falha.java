import java.util.Date;

public class Falha {
   private String descricao;
    private Date previsao;
    private Date datainicio;
    private Date datafim;

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
    public Falha(String descricao, Date previsao){
        this.descricao = descricao;
        this.previsao = previsao;
        this.datainicio = new Date();
    }
}
