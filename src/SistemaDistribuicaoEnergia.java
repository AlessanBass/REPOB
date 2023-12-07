import java.util.ArrayList;
import java.util.List;

public class SistemaDistribuicaoEnergia {
	private List<Cliente> clientes;
	 private List<Imovel> imoveis;

    public SistemaDistribuicaoEnergia() {
        this.clientes = new ArrayList<>();
        this.imoveis = new ArrayList<>();
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

}
