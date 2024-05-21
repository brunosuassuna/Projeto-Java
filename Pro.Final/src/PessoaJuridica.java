public class PessoaJuridica extends Pessoa {
    public PessoaJuridica(String nome, String cnpj, Endereco endereco, double renda) {
        super(nome, cnpj, endereco, renda);
    }

    @Override
    public void imprimirDados() {
        System.out.println("Pessoa Jurídica:");
        System.out.println("Nome: " + getNome());
        System.out.println("CNPJ: " + getCpfCnpj());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Renda: " + getRenda());
    }
}
