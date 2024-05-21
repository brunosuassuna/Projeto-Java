public class ContaCorrente extends Conta {
    private double limiteSaque;

    public ContaCorrente(String numero, String agencia, Pessoa titular, double saldo, double limiteSaque) {
        super(numero, agencia, titular, saldo);
        this.limiteSaque = limiteSaque;
    }

    @Override
    public void sacar(double valor) {
        if (valor > limiteSaque) {
            throw new IllegalArgumentException("Valor acima do limite de saque.");
        }
        super.sacar(valor);
    }
}
