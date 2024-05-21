import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private String numero;
    private String agencia;
    private String titular;
    private double saldo;
    private boolean situacao; // true para ativa, false para inativa
    private List<Movimento> movimentos;

    public Conta(String numero, String agencia, String titular, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = saldo;
        this.situacao = true;
        this.movimentos = new ArrayList<>();
    }

    public String getNumero() { return numero; }
    public String getAgencia() { return agencia; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
    public boolean isSituacao() { return situacao; }
    public void setSituacao(boolean situacao) { this.situacao = situacao; }

    protected void registrarMovimento(String tipo, double valor) {
        Movimento movimento = new Movimento(tipo, LocalDateTime.now(), valor, this);
        movimentos.add(movimento);
    }

    public void sacar(double valor) {
        if (!situacao) {
            throw new IllegalStateException("Conta desativada.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
        registrarMovimento("SAQUE", valor);
    }

    public void depositar(double valor) {
        if (!situacao) {
            throw new IllegalStateException("Conta desativada.");
        }
        saldo += valor;
        registrarMovimento("DEPÓSITO", valor);
    }

    public void transferir(Conta destino, double valor) {
        if (!situacao) {
            throw new IllegalStateException("Conta desativada.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
        destino.depositar(valor);
        registrarMovimento("TRANSFERÊNCIA", valor);
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void imprimirExtrato() {
        System.out.println("Extrato da Conta");
        System.out.println("Número: " + numero);
        System.out.println("Agência: " + agencia);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
        for (Movimento movimento : movimentos) {
            System.out.println(movimento);
        }
    }

    public List<Movimento> getMovimentos() {
        return movimentos;
    }
}
