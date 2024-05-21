import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements Extrato {
    private String numero;
    private String agencia;
    private Pessoa titular;
    private double saldo;
    private Situacao situacao;
    private List<Movimento> movimentos;

    public Conta(String numero, String agencia, Pessoa titular, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = saldo;
        this.situacao = Situacao.ATIVO;
        this.movimentos = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void ativar() {
        this.situacao = Situacao.ATIVO;
    }

    public void desativar() {
        this.situacao = Situacao.INATIVO;
    }

    public boolean estaAtivo() {
        return this.situacao == Situacao.ATIVO;
    }

    private void registrarMovimento(TipoMovimento tipo, double valor) {
        Movimento movimento = new Movimento(tipo, LocalDateTime.now(), valor, this);
        movimentos.add(movimento);
    }

    public void sacar(double valor) {
        if (!estaAtivo()) {
            throw new IllegalStateException("Conta desativada.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
        registrarMovimento(TipoMovimento.SAQUE, valor);
    }

    public void depositar(double valor) {
        if (!estaAtivo()) {
            throw new IllegalStateException("Conta desativada.");
        }
        saldo += valor;
        registrarMovimento(TipoMovimento.DEPOSITO, valor);
    }

    public void transferir(Conta destino, double valor) {
        if (!estaAtivo()) {
            throw new IllegalStateException("Conta desativada.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
        destino.depositar(valor);
        registrarMovimento(TipoMovimento.TRANSFERENCIA, valor);
    }

    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public void imprimirExtratoCompleto() {
        System.out.println("Extrato Completo da Conta");
        System.out.println("Número: " + numero);
        System.out.println("Agência: " + agencia);
        System.out.println("Titular: " + titular.getNome());
        System.out.println("Saldo: " + saldo);
        System.out.println("Situação: " + situacao);
        for (Movimento movimento : movimentos) {
            System.out.println(movimento);
        }
    }

    @Override
    public void imprimirExtratoDetalhado() {
        System.out.println("Extrato Detalhado da Conta");
        System.out.println("Número: " + numero);
        System.out.println("Agência: " + agencia);
        System.out.println("Titular: " + titular.getNome());
        System.out.println("Saldo: " + saldo);
        System.out.println("Situação: " + situacao);
        for (Movimento movimento : movimentos) {
            System.out.println("Tipo: " + movimento.getTipo());
            System.out.println("Data e Hora: " + movimento.getDataHora());
            System.out.println("Valor: " + movimento.getValor());
            System.out.println("Saldo após movimento: " + saldo);
        }
    }

    @Override
    public List<Movimento> getMovimentos() {
        return movimentos;
    }
}
