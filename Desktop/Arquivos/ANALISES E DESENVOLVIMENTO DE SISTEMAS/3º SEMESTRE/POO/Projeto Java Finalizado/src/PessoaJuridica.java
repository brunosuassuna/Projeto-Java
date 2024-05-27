public class PessoaJuridica extends Pessoa {
    private String cnpj;

    /* --------------------------- CONSTRUTORES --------------------------- */
    public PessoaJuridica() {    }
    public PessoaJuridica(String nome, Endereco endereco, double renda, String cnpj) {
        super(nome, endereco, renda);
        this.cnpj = cnpj;
    }

    /* --------------------------- GETTERS AND SETTERS --------------------------- */
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /* --------------------------- TO STRING DE PESSOA JURÍDICA --------------------------- */

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj='" + cnpj + '\'' +
                '}';
    }
}
