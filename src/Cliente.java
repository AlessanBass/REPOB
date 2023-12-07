import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private List<Imovel> imoveisCliente;
    private List<Fatura> faturas;

    public Cliente(String nome, String cpf) {
        this.cpf = cpf;
        this.nome = nome;
        this.imoveisCliente = new ArrayList<>();
        this.faturas = new ArrayList<>();
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
    
    public void registrarConsumo(double consumo) {
    	if (faturas.isEmpty() || faturas.get(faturas.size() - 1).isQuitado()) {
            Fatura novaFatura = new Fatura(consumo);
            this.faturas.add(novaFatura);
        } else {
            System.out.println("A fatura anterior ainda não foi quitada. Consumo não registrado.");
        }
    }

    public List<Fatura> getFaturas() {
        return faturas;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cliente: ").append(nome).append(" | CPF: ").append(cpf);

        if (!imoveisCliente.isEmpty()) {
            builder.append(" | Imóveis: ");
            for (Imovel imovel : imoveisCliente) {
                builder.append("Matrícula: ").append(imovel.getMatricula()).append(", Endereço: ").append(imovel.getEndereco()).append(" | ");
            }
        }

        return builder.toString();
    }
}
