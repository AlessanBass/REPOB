
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reembolso {

	private Date dataReembolso;
	private double valor;

	public Reembolso(Date dataReembolso, double valor) {
		this.dataReembolso = dataReembolso;
		this.valor = valor;
	}

	public Date getDataReembolso() {
		return dataReembolso;
	}

	public void setDataReembolso(Date dataReembolso) {
		this.dataReembolso = dataReembolso;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return "Data do Reembolso: " + dateFormat.format(dataReembolso) + "\nValor Reembolsado: " + valor;
	}
}
