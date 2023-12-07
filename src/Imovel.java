public class Imovel {
    private String matricula;
    private String endereco;
    private double ultimaLeitura;
    private double penultimaLeitura;

    public Imovel(String matricula, String endereco, double ultimaLeitura, double penultimaLeitura) {
        this.matricula = matricula;
        this.endereco = endereco;
        this.ultimaLeitura = ultimaLeitura;
        this.penultimaLeitura = penultimaLeitura;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
    
    @Override
    public String toString() {
        return "Matrícula: " + matricula +
                "\nEndereço: " + endereco +
                "\nPrimeira Leitura: " + penultimaLeitura +
                "\nÚltima Leitura: " + ultimaLeitura;
    }
}
