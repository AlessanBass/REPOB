import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private List<Imovel> imoveisCliente;

    public Cliente(String nome, String cpf) {
        this.cpf = cpf;
        this.nome = nome;
        this.imoveisCliente = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Imovel> getImoveisCliente() {
        return imoveisCliente;
    }

    public void setImoveisCliente(ArrayList<Imovel> imoveisCliente) {
        this.imoveisCliente = imoveisCliente;
    }


    public void adicionarImovel(Imovel imovel) {
    	imoveisCliente.add(imovel);
    }

    public void removerImovel(Imovel imovel) {
    	imoveisCliente.remove(imovel);
    }

    public void listarImoveis() {
        System.out.println("Imóveis do Cliente " + nome + ":");
        for (Imovel imovel : imoveisCliente) {
            System.out.println("- Matrícula: " + imovel.getMatricula() + ", Endereço: " + imovel.getEndereco());
        }
    }
}
