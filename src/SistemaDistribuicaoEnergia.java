import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SistemaDistribuicaoEnergia {
	private List<Cliente> clientes;
	private List<Imovel> imoveis;
	private List<Fatura> faturas;

	public SistemaDistribuicaoEnergia() {
		this.clientes = new ArrayList<>();
		this.imoveis = new ArrayList<>();
		this.faturas = new ArrayList<>();
	}

	public void incluirCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public Cliente consultarCliente(String cpf) {
		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		return null;
	}

	public List<Cliente> listarClientes() {
		return clientes;
	}

	public void excluirCliente(String cpf) {
		Cliente clienteParaRemover = null;
		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpf)) {
				clienteParaRemover = cliente;
				break;
			}
		}
		if (clienteParaRemover != null) {
			clientes.remove(clienteParaRemover);
			System.out.println("Cliente excluído com sucesso.");
		} else {
			System.out.println("Cliente não encontrado. Exclusão não realizada.");
		}
	}

	public void alterarCliente(String cpf, Cliente novoCliente) {
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente = clientes.get(i);
			if (cliente.getCpf().equals(cpf)) {
				clientes.set(i, novoCliente);
				break;
			}
		}
	}

	public void incluirImovel(Imovel imovel) {
		if (consultarImovel(imovel.getMatricula()) == null) {
			imoveis.add(imovel);
			System.out.println("Imóvel incluído com sucesso!");
		} else {
			System.out.println("Matrícula do imóvel já existe. Inclusão não realizada.");
		}
	}

	public Imovel consultarImovel(String matricula) {
		for (Imovel imovel : imoveis) {
			if (imovel.getMatricula().equals(matricula)) {
				return imovel;
			}
		}
		return null;
	}

	public List<Imovel> listarImoveis() {
		return imoveis;
	}

	public void listarFaturasAbertas() {
		if (!faturas.isEmpty()) {
			System.out.println("Faturas Abertas:");
			for (Fatura fatura : faturas) {
				if (!fatura.isQuitado()) {
					System.out.println("Data: " + fatura.getData());
					System.out.println("Valor: " + fatura.getValor());
					System.out.println("Status: Aberta");
					System.out.println("-----");
				}
			}
		} else {
			System.out.println("Não há faturas abertas.");
		}
	}

	public void listarTodasFaturas() {
		if (faturas.isEmpty()) {
			System.out.println("Não há faturas cadastradas.");
		} else {
			System.out.println("Lista de todas as Faturas:");
			for (Fatura fatura : faturas) {
				System.out.println("Data: " + fatura.getData());
				System.out.println("Ultima Leitura: " + fatura.getUltimaLeitura());
				System.out.println("Penultima Leitura: " + fatura.getPenultimaLeitura());
				System.out.println("Valor: " + fatura.getValor());
				String statusQuitado = fatura.isQuitado() ? "Quitado" : "Não quitado";
				System.out.println("Status: " + statusQuitado);
				System.out.println("----------------------------");
			}
		}
	}

	public Fatura consultarFatura(Date dataFatura) {
		for (Fatura fatura : faturas) {
			if (truncateTime(fatura.getData()).equals(truncateTime(dataFatura))) {
				return fatura;
			}
		}
		return null;
	}

	public void incluirPagamento(Date dataFatura, double valor) {
		Fatura fatura = consultarFatura(dataFatura);

		if (fatura != null && !fatura.isQuitado()) {
			Pagamento pagamento = new Pagamento(dataFatura, valor);
			fatura.incluirPagamento(pagamento);

			
			if (fatura.isQuitado()) {
				System.out.println("Fatura quitada!");
				
				double valorExcedente = fatura.calcularSaldoExcedente();
				if (valorExcedente > 0) {
					Reembolso reembolso = new Reembolso(dataFatura, valorExcedente);
					fatura.incluirReembolso(reembolso);
					System.out.println("Reembolso gerado: " + reembolso);
				}
			}

			System.out.println("Pagamento registrado com sucesso!");
		} else {
			System.out.println("Fatura não encontrada ou já quitada.");
		}
	}

	private Date truncateTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public void alterarImovel(String matricula, Imovel novoImovel) {
		Imovel imovelExistente = consultarImovel(matricula);

		if (imovelExistente != null) {
			imoveis.remove(imovelExistente);
			imoveis.add(novoImovel);
			System.out.println("Imóvel alterado com sucesso!");
		} else {
			System.out.println("Imóvel não encontrado. Alteração não realizada.");
		}
	}

	public void excluirImovel(String matricula) {
		Imovel imovel = consultarImovel(matricula);
		if (imovel != null) {
			imoveis.remove(imovel);
			System.out.println("Imóvel excluído com sucesso!");
		} else {
			System.out.println("Imóvel não encontrado. Exclusão não realizada.");
		}
	}

    public Imovel encontrarImovelPorMatricula(String matricula) {
        for (Imovel imovel : imoveis) {
            if (imovel.getMatricula().equals(matricula)) {
                return imovel;
            }
        }
        return null;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Imovel> getImoveis() {
        return imoveis;
    }

    public void setImoveis(List<Imovel> imoveis) {
        this.imoveis = imoveis;
    }
    
    public List<Fatura> getFaturas() {
        return faturas;
    }
}
