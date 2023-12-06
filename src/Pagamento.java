import java.util.Date;

public class Pagamento {
	
	private Date data;
    private double valor;
    
    public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Pagamento(double valor) {
        this.data = new Date();
        this.valor = valor;
    }
    
    public static void incluirPagamento(Fatura fatura, double valor) {
        // Verifica se a fatura já foi quitada
        if (!fatura.isQuitado()) {
            Pagamento pagamento = new Pagamento(valor);
            fatura.incluirPagamento(pagamento);

            // Verifica se a fatura foi quitada após o pagamento
            if (fatura.calcularSaldoDevido() <= 0) {
                fatura.setQuitado(true);
                double valorExcedente = fatura.calcularSaldoExcedente();
                if (valorExcedente > 0) {
                    Reembolso reembolso = new Reembolso(valorExcedente);
                    fatura.incluirReembolso(reembolso);
                }
            }
        } else {
            System.out.println("Fatura já quitada. Não é possível adicionar pagamento.");
        }
    }
}
