public abstract class Pessoa {
    private String nome;
    private String cpfCnpj;
    private Endereco endereco;
    private double renda;
    private boolean ativa; // true para ativa, false para inativa

    public Pessoa(String nome, String cpfCnpj, Endereco endereco, double renda) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
        this.renda = renda;
        this.ativa = true;
    }

    public String getNome() { return nome; }
    public String getCpfCnpj() { return cpfCnpj; }
    public Endereco getEndereco() { return endereco; }
    public double getRenda() { return renda; }
    public boolean isAtiva() { return ativa; }
    public void setAtiva(boolean ativa) { this.ativa = ativa; }

    public abstract void imprimirDados();
}
