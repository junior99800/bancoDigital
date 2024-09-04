import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    private List<Emprestimo> emprestimos;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.emprestimos = new ArrayList<>();
    }

    public Conta(Cliente cliente, double saldoInicial) {
        this(cliente);
        this.saldo = saldoInicial;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    // Método para solicitar empréstimo
    public void solicitarEmprestimo(double valor, double taxaJuros, int prazoMeses) {
        Emprestimo novoEmprestimo = new Emprestimo(valor, taxaJuros, prazoMeses);
        this.saldo += valor; // Deposita o valor do empréstimo na conta
        emprestimos.add(novoEmprestimo);
        System.out.println("Empréstimo concedido. Saldo atual: " + this.saldo);
    }

    // Método para pagar contas
    public void pagarConta(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Pagamento de conta no valor de " + valor + " realizado. Saldo atual: " + saldo);
        } else {
            System.out.println("Saldo insuficiente para o pagamento da conta.");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void imprimirEmprestimos() {
        System.out.println("=== Detalhes dos Empréstimos ===");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}