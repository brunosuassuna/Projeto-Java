public class ContaPoupanca extends Conta {
    private double rendimentoMensal;

    public ContaPoupanca(String numero, String agencia, String titular, double saldo, double rendimentoMensal) {
        super(numero, agencia, titular, saldo);
        this.rendimentoMensal = rendimentoMensal;
    }

    public double getRendimentoMensal() {
        return rendimentoMensal;
    }

    public void aplicarRendimento() {
        double rendimento = getSaldo() * rendimentoMensal;
        depositar(rendimento);
    }
}
