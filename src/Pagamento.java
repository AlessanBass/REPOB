import java.text.SimpleDateFormat;
import java.util.Date;

public class Pagamento {
	
	private Date dataPagamento;
    private double valor;
    
    public Pagamento(Date dataPagamento, double valor) {
        this.dataPagamento = dataPagamento;
        this.valor = valor;
    }
    
    public Date getData() {
		return dataPagamento;
	}

	public void setData(Date data) {
		this.dataPagamento = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Pagamento(double valor) {
        this.dataPagamento = new Date();
        this.valor = valor;
    }
	
	@Override
	public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Data do Pagamento: " + dateFormat.format(dataPagamento) +
                " | Valor: " + valor;
    }
    
    public static void incluirPagamento(Fatura fatura, double valor) {
        if (!fatura.isQuitado()) {
            Pagamento pagamento = new Pagamento(valor);
            fatura.incluirPagamento(pagamento);
            
            if (fatura.calcularSaldoDevido() <= 0) {
                fatura.setQuitado(true);
                double valorExcedente = fatura.calcularSaldoExcedente();
                if (valorExcedente > 0) {
                	Date dataReembolso = new Date();
                    Reembolso reembolso = new Reembolso(dataReembolso, valorExcedente);
                    fatura.incluirReembolso(reembolso);
                }
            }
        } else {
            System.out.println("Fatura já quitada. Não é possível adicionar pagamento.");
        }
    }
}
