public class Main {
    public static void main(String[] args) {
        Endereco endereco1 = new Endereco("Francisca", "58052-492", "260", "Cidade Universitária", "João Pessoa");
        Endereco endereco2 = new Endereco("98765-432", "Rua B", "20", "Bancarios", "João Pessoa");

        PessoaFisica pessoaFisica = new PessoaFisica("Djalma",endereco1,3000,"065.470.724-36","2834153");
        PessoaJuridica pessoaJuridica = new PessoaJuridica("Empresa TI-BROTHERS", endereco2, 50000.0, "123.456.789/0001-22");

        Conta contaPF = new Conta(Long.valueOf(0001), "senhaPF", 1000.0, pessoaFisica);
        Conta contaPJ = new Conta(Long.valueOf(0002), "senhaPJ", 2000.0, pessoaJuridica);
        //contaPJ.setSituacaoConta(TipoSituação.INATIVA);

        /*Movimentações na Conta de Pessoa Física*/
        contaPF.depositar(500);
        contaPF.depositar(500);
        contaPF.sacar(200);
        contaPF.sacar(200);
        //contaPF.sacar(2000);

        /*Movimentações na Conta de Pessoa Jurídica*/
        contaPJ.depositar(1000);
        contaPJ.depositar(1000);
        contaPJ.transferir(contaPF,500);
        contaPJ.transferir(contaPF,500);

        /*Extrato das duas contas criadas*/
        contaPF.imprimir();
        contaPJ.imprimir();

    }
}
