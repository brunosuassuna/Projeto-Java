public class ContaPoupanca extends Conta {
    private double rendimentoMensal;

    public ContaPoupanca(String numero, String agencia, Pessoa titular, double saldo, double rendimentoMensal) {
        super(numero, agencia, titular, saldo);
        this.rendimentoMensal = rendimentoMensal;
    }

    public void aplicarRendimento() {
        double rendimento = getSaldo() * rendimentoMensal / 100;
        depositar(rendimento);
    }
}
