import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Criando endereços
        Endereco endereco1 = new Endereco("12345-678", "Rua A", 123, "Bairro A", "João Pessoa", "Estado PB");
        Endereco endereco2 = new Endereco("87654-321", "Rua B", 456, "Bairro B", "João Pessoa", "Estado PB");

        // Criando pessoas
        PessoaFisica pessoaFisica = new PessoaFisica("Bruno Suassuna", "123.456.789-00", endereco1, 5000.0);
        PessoaJuridica pessoaJuridica = new PessoaJuridica("Empresa TI-BROTHERS", "12.345.678/0001-00", endereco2, 100000.0);

        // Criando contas
        ContaCorrente contaPF = new ContaCorrente("0001", "1234", pessoaFisica, 1000.0, 500.0);
        ContaPoupanca contaPJ = new ContaPoupanca("0002", "1234", pessoaJuridica, 2000.0, 1.5);

        // Associações
        pessoaFisica.imprimirDados();
        pessoaJuridica.imprimirDados();

        // Operações na conta da pessoa física
        contaPF.depositar(500.0);
        contaPF.depositar(500.0);
        contaPF.sacar(200.0);
        contaPF.sacar(200.0);

        // Operações na conta da pessoa jurídica
        contaPJ.depositar(1000.0);
        contaPJ.depositar(1000.0);
        contaPJ.transferir(contaPF, 500.0);
        contaPJ.transferir(contaPF, 500.0);

        // Imprimindo extratos
        contaPF.imprimirExtratoCompleto();
        contaPJ.imprimirExtratoCompleto();

        // Cenário de exceção de saldo insuficiente
        try {
            contaPF.sacar(1000.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Cenário de pessoa desativada
        pessoaFisica.desativar();
        try {
            contaPF.depositar(100.0);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        // Exibindo informações adicionais
        System.out.println("Saldo atual da conta PF: " + contaPF.consultarSaldo());
        System.out.println("Titular da conta PF: " + contaPF.getTitular().getNome());
        System.out.println("Movimentos da conta PF: ");
        for (Movimento mov : contaPF.getMovimentos()) {
            System.out.println(mov);
        }
    }
}
