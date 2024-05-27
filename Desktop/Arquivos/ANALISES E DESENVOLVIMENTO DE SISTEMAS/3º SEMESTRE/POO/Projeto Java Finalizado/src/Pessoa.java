public abstract class Pessoa {
    private String nome;
    private Endereco endereco;
    private double renda;
    private TipoSituação situacao; // true para ativa, false para inativa

    /* --------------------------- CONSTRUTORES --------------------------- */
    public Pessoa() {    }

    public Pessoa(String nome, Endereco endereco, double renda) {
        this.nome = nome;
        this.endereco = endereco;
        this.renda = renda;
        this.situacao = situacao.ATIVA;
    }

    /* --------------------------- GETTERS AND SETTERS --------------------------- */
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public Endereco getEndereco() {return endereco;}
    public void setEndereco(Endereco endereco) {this.endereco = endereco;}

    public double getRenda() {return renda;}
    public void setRenda(double renda) {this.renda = renda;}

    public TipoSituação getSituacao() {return situacao;}
    public void setSituacao(TipoSituação situacao) {this.situacao = situacao;}
}