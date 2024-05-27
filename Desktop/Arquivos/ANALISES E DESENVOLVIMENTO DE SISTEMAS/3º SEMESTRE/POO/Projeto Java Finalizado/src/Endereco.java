public class Endereco {
    private String rua;
    private String cep;
    private String bairro;
    private String numero;
    private String cidade;

    /* --------------------------- CONSTRUTORES --------------------------- */
    public Endereco() {    }

    public Endereco(String rua, String cep, String numero, String bairro, String cidade) {
        this.rua = rua;
        this.cep = cep;
        this.bairro = bairro;
        this.numero = numero;
        this.cidade = cidade;
    }

    /* --------------------------- GETTERS AND SETTERS --------------------------- */

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /* --------------------------- TO STRING DE ENDEREÇO --------------------------- */

    //
    @Override
    public String toString() {
        return "Endereco{" +
                "Rua " + rua + '\'' +
                "," + numero + '\'' +
                ", " + bairro + '\'' +
                ". " + cep + '\'' +
                ". " + cidade + '\'' +
                '}';
    }
}
