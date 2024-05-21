public class PessoaFisica extends Pessoa {
    public PessoaFisica(String nome, String cpf, Endereco endereco, double renda) {
        super(nome, cpf, endereco, renda);
    }

    @Override
    public void imprimirDados() {
        System.out.println("Pessoa Física:");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpfCnpj());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Renda: " + getRenda());
        System.out.println("Situação: " + getSituacao());
    }
}
