import java.util.ArrayList;
public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Imovel> imoveisCliente = new ArrayList<Imovel>();

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Imovel> getImoveisCliente() {
        return imoveisCliente;
    }

    public void setImoveisCliente(ArrayList<Imovel> imoveisCliente) {
        this.imoveisCliente = imoveisCliente;
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

    public void adicionarImovel(Imovel imovel){
        this.imoveisCliente.add(imovel);
    }
}
