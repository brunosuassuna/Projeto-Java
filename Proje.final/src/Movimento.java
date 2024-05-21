import java.time.LocalDateTime;

public class Movimento {
    private TipoMovimento tipo;
    private LocalDateTime dataHora;
    private double valor;
    private Conta conta;

    public Movimento(TipoMovimento tipo, LocalDateTime dataHora, double valor, Conta conta) {
        this.tipo = tipo;
        this.dataHora = dataHora;
        this.valor = valor;
        this.conta = conta;
    }

    public TipoMovimento getTipo() {
        return tipo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Data e Hora: " + dataHora + ", Valor: " + valor + ", Conta: " + conta.getNumero();
    }
}
