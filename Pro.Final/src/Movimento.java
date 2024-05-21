import java.time.LocalDateTime;

public class Movimento {
    private String tipoMovimento;
    private LocalDateTime dataHora;
    private double valor;
    private Conta contaEnvolvida;

    public Movimento(String tipoMovimento, LocalDateTime dataHora, double valor, Conta contaEnvolvida) {
        this.tipoMovimento = tipoMovimento;
        this.dataHora = dataHora;
        this.valor = valor;
        this.contaEnvolvida = contaEnvolvida;
    }

    @Override
    public String toString() {
        return "Movimento{" +
                "tipo='" + tipoMovimento + '\'' +
                ", dataHora=" + dataHora +
                ", valor=" + valor +
                ", conta=" + contaEnvolvida.getNumero() +
                '}';
    }
}
