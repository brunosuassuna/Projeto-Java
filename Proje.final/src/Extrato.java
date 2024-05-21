import java.util.List;

public interface Extrato {
    void imprimirExtratoCompleto();
    void imprimirExtratoDetalhado();
    List<Movimento> getMovimentos();
}
