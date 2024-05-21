public class Endereco {
    private String cep;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(String cep, String logradouro, int numero, String bairro, String cidade, String estado) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return logradouro + ", " + numero + " - " + bairro + ", " + cidade + " - " + estado + " CEP: " + cep;
    }
}
