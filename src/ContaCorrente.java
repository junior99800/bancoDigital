public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public ContaCorrente(Cliente cliente, double saldoInicial) {
        super(cliente, saldoInicial);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }

    public void imprimirEmprestimosCorrente() {
        imprimirEmprestimos(); // Chama o método da classe pai
    }
}
