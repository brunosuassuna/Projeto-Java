public class PessoaFisica extends Pessoa {
    private String cpf;
    private String rg;

    /* --------------------------- CONSTRUTORES --------------------------- */
    public PessoaFisica() {     }

    public PessoaFisica(String nome, Endereco endereco, double renda, String cpf, String rg) {
        super(nome, endereco, renda);
        this.cpf = cpf;
        this.rg = rg;
    }


    /* --------------------------- GETTERS AND SETTERS --------------------------- */
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }

    /* --------------------------- TO STRING PESSOA FÍSICA --------------------------- */
    @Override
    public String toString() {
        return "PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                '}';
    }
}

