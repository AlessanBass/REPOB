import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Fatura {
	
	private Date data;
    private double ultimaLeitura;
    private double penultimaLeitura;
    private double valor;
    private boolean quitado;
    private List<Pagamento> pagamentos;
    private List<Reembolso> reembolsos;
    
    

    public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getUltimaLeitura() {
		return ultimaLeitura;
	}

	public void setUltimaLeitura(double ultimaLeitura) {
		this.ultimaLeitura = ultimaLeitura;
	}

	public double getPenultimaLeitura() {
		return penultimaLeitura;
	}

	public void setPenultimaLeitura(double penultimaLeitura) {
		this.penultimaLeitura = penultimaLeitura;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isQuitado() {
		return quitado;
	}

	public void setQuitado(boolean quitado) {
		this.quitado = quitado;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public List<Reembolso> getReembolsos() {
		return reembolsos;
	}

	public void setReembolsos(List<Reembolso> reembolsos) {
		this.reembolsos = reembolsos;
	}

	public Fatura(double ultimaLeitura, double penultimaLeitura) {
        this.data = new Date();
        this.ultimaLeitura = ultimaLeitura;
        this.penultimaLeitura = penultimaLeitura;
        this.valor = calcularValor(); 
        this.quitado = false;
        this.pagamentos = new ArrayList<>();
        this.reembolsos = new ArrayList<>();
    }

    private double calcularValor() {
        return 10.0 * (ultimaLeitura - penultimaLeitura);
    }

    public void incluirPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
        verificarQuitacao();
    }

    public void incluirReembolso(Reembolso reembolso) {
        reembolsos.add(reembolso);
    }

    public double calcularSaldoDevido() {
        return valor - pagamentos.stream().mapToDouble(Pagamento::getValor).sum();
    }

    public double calcularSaldoExcedente() {
        double saldoExcedente = pagamentos.stream().mapToDouble(Pagamento::getValor).sum() - valor;
        return saldoExcedente > 0 ? saldoExcedente : 0;
    }

    private void verificarQuitacao() {
        if (calcularSaldoDevido() <= 0) {
            quitado = true;
            double valorExcedente = calcularSaldoExcedente();
            if (valorExcedente > 0) {
                Reembolso reembolso = new Reembolso(valorExcedente);
                incluirReembolso(reembolso);
            }
        }
    }

}
