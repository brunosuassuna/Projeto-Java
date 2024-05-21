public class Main {
    public static void main(String[] args) {
        Endereco endereco1 = new Endereco("12345-678", "Rua A", "10", "Castelo Branco", "João Pessoa", "Estado PB");
        Endereco endereco2 = new Endereco("98765-432", "Rua B", "20", "Bancarios", "João Pessoa", "Estado PB");

        PessoaFisica pessoaFisica = new PessoaFisica("Bruno Suassuna", "123.456.789-00", endereco1, 3000.0);
        PessoaJuridica pessoaJuridica = new PessoaJuridica("Empresa TI-BROTHERS", "12.345.678/0001-00", endereco2, 50000.0);

        ContaCorrente contaPF = new ContaCorrente("0001", "001", "Bruno Suassuna", 1000.0, 500.0);
        ContaPoupanca contaPJ = new ContaPoupanca("0002", "002", "Empresa TI-BROTHERS", 2000.0, 0.05);

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

        // Imprimir extrato
        contaPF.imprimirExtrato();
        contaPJ.imprimirExtrato();

        // Cenário de exceção de saldo insuficiente
        try {
            contaPF.sacar(1000.0); // Deve lançar exceção
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Cenário de pessoa desativada
        pessoaFisica.setAtiva(false);
        try {
            contaPF.depositar(100.0); // Deve lançar exceção
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        // Exibindo informações adicionais
        System.out.println("Saldo atual da conta PF: " + contaPF.consultarSaldo());
        System.out.println("Titular da conta PF: " + contaPF.getTitular());
        System.out.println("Movimentos da conta PF: ");
        for (Movimento mov : contaPF.getMovimentos()) {
            System.out.println(mov);
        }
    }
}
