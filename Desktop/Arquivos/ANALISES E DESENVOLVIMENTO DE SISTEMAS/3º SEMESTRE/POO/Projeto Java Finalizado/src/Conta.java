import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Conta implements InterfaceExtrato{
    private Long numero;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataEncerramento;
    private TipoSituação situacaoConta;
    private String senha;
    private double saldo;
    private ArrayList<Movimento> movimentos;
    private Pessoa pessoa;

    /* --------------------------- CONSTRUTORES --------------------------- */
    public Conta(Long numero, String senha, double saldo, Pessoa pessoa) {
        this.numero = numero;
        this.dataAbertura = LocalDateTime.now();
        this.situacaoConta = situacaoConta.ATIVA;
        this.senha = senha;
        this.saldo = saldo;
        this.pessoa = pessoa;
        this.movimentos = new ArrayList<>();
    }

    /* --------------------------- GETTERS AND SETTERS --------------------------- */
    public Long getNumero() {
        return numero;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public LocalDateTime getDataEncerramento() {
        return dataEncerramento;}
    public void setDataEncerramento(LocalDateTime dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public TipoSituação getSituacaoConta() {
        return situacaoConta;
    }
    public void setSituacaoConta(TipoSituação situacaoConta) {
        this.situacaoConta = situacaoConta;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /* --------------------------- MÉTODOS --------------------------- */
      public void sacar(double valor){
        // Exceção criada para verificar se a conta está ativa
        if(this.situacaoConta==TipoSituação.INATIVA){
            throw new ContaInativaException("A conta encontra-se inativa, entre em contato com o suporte para ativa-la.");
        } else if (valor > saldo){
            //Exceção que verifica o saldo na conta
            throw new SaldoInsuficienteException("Saldo insuficiente, tente outro valor.");
        }else{
            saldo -= valor;
            Movimento movimento = new Movimento(TipoMovimento.SAQUE, LocalDateTime.now(), -valor, this, saldo);
            // Adiciona ao registro dos movimentos para inserir no extrato
            movimentos.add(movimento);

            // Mostra na tela o saque feito
            System.out.println("Conta: " + numero + " | Titular: " + pessoa.getNome());
            System.out.println("Saque realizado: R$-" + valor + "\nSaldo: " + saldo + "\n");
        }
    }

    /*Método Depositar*/
    public void depositar(double valor){
        if(situacaoConta==TipoSituação.INATIVA){
            // Exceção criada para verificar se a conta está ativa
            throw new ContaInativaException("A conta encontra-se inativa, entre em contato com o suporte para ativa-la.");
        }else{
            saldo += valor;
            Movimento movimento = new Movimento(TipoMovimento.DEPOSITO, LocalDateTime.now(), valor, this, saldo);
            // Adiciona ao registro dos movimentos para inserir no extrato
            movimentos.add(movimento);

            // Mostra na tela o deposito feito
            System.out.println("Conta: " + numero + " | Titular: " + pessoa.getNome());
            System.out.println("Depósito realizado: R$" + valor + "\nSaldo: " + saldo + "\n");
        }
    }

    public void transferir(Conta contaDestino, double valor){
        if(this.situacaoConta==TipoSituação.INATIVA){
            // Exceção que verifica se a conta está ativa
            throw new ContaInativaException("A conta encontra-se inativa, entre em contato com o suporte para ativa-la.");
        } else if (valor > saldo){
            //Exceção que verifica o saldo na conta
            throw new SaldoInsuficienteException("Saldo insuficiente, tente outro valor.");
        }else{
            saldo -= valor;
            contaDestino.saldo +=valor;
            /*contaDestino.depositar(valor);*/
            Movimento regMovimentoContaOrigem = new Movimento(TipoMovimento.TRANSFERENCIA, LocalDateTime.now(), -valor, contaDestino, saldo);

            // Adiciona ao registro dos movimentos para inserir no extrato
            this.movimentos.add(regMovimentoContaOrigem);
            Movimento regMovimentoContaDestino = new Movimento(TipoMovimento.TRANSFERENCIA, LocalDateTime.now(), valor, this, contaDestino.saldo);

            //Registro da Transferência na conta Destino
            contaDestino.movimentos.add(regMovimentoContaDestino); 

            // Mostra na tela a transferência feito
            System.out.println("Conta: " + numero + " | Titular: " + pessoa.getNome());
            System.out.println("Transferência realizada para a conta 000" + contaDestino.numero + " - " + contaDestino.pessoa.getNome() +
                    ". \nValor: " + valor + " | Saldo: " + saldo + "\n");
        }
    }

    @Override
    public void imprimir() {
        System.out.println("----------------------------------\nEXTRATO");
        System.out.println(
                "CONTA : 000" + numero + "  |  " + "TITULAR: " + pessoa.getNome() +
                "\nData de Abertura:" + dataAbertura.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +
                " / Data de Encerramento: " + (dataEncerramento != null ? dataEncerramento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) : "___") +
                "\nSituação da Conta:" + situacaoConta +
                "\nSaldo: R$" + saldo);

        for(Movimento movimento : movimentos){
            System.out.println(movimento);
        }
        System.out.println("----------------------------------\n");
    }
}