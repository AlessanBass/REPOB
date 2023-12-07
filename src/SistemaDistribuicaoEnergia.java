import java.util.ArrayList;
import java.util.List;

public class SistemaDistribuicaoEnergia {
	private List<Cliente> clientes;

    public SistemaDistribuicaoEnergia() {
        this.clientes = new ArrayList<>();
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

}
