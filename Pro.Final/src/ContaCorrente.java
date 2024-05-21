public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String numero, String agencia, String titular, double saldo, double limite) {
        super(numero, agencia, titular, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    @Override
    public void sacar(double valor) {
        if (valor > (super.getSaldo() + limite)) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        super.sacar(valor);
    }
}
