public abstract class Pessoa {
    private String nome;
    private String cpfCnpj;
    private Endereco endereco;
    private double renda;
    private Situacao situacao;

    public Pessoa(String nome, String cpfCnpj, Endereco endereco, double renda) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
        this.renda = renda;
        this.situacao = Situacao.ATIVO;
    }

    public String getNome() {
        return nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public double getRenda() {
        return renda;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void ativar() {
        this.situacao = Situacao.ATIVO;
    }

    public void desativar() {
        this.situacao = Situacao.INATIVO;
    }

    public boolean estaAtivo() {
        return this.situacao == Situacao.ATIVO;
    }

    public abstract void imprimirDados();
}
