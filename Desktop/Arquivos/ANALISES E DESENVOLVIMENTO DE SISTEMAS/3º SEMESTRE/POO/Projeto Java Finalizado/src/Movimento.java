import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimento {
    private TipoMovimento tipoMovimento;
    private LocalDateTime dataHora;
    private double valor;
    private Conta contaEnvolvida;
    private double saldoMovimento;

     /*Construtor utilizado para registrar Transferências, Saques e Depositos*/
    public Movimento(TipoMovimento tipoMovimento, LocalDateTime dataHora, double valor, Conta contaEnvolvida, double saldo) {
        this.tipoMovimento = tipoMovimento;
        this.dataHora = dataHora;
        this.valor = valor;
        this.contaEnvolvida = contaEnvolvida;
        this.saldoMovimento = saldo;
    }


    public TipoMovimento getTipoMovimento() {
        return tipoMovimento;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double getValor() {
        return valor;
    }

    public Conta getContaEnvolvida() {
        return contaEnvolvida;
    }

    @Override
    public String toString() {
        return  "\n   Movimento:" + tipoMovimento +
                "\n   Conta: 000" + contaEnvolvida.getNumero() +
                " | Data e Hora: " + dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +
                "\n   Valor = R$" + valor +
                " | Saldo = R$" + saldoMovimento;
    }
}
