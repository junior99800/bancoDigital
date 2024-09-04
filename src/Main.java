public class Main {

    public static void main(String[] args) {
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        cc.depositar(100);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        ContaCorrente minhaConta = new ContaCorrente(venilton, 500.0);

        // Solicitar um empréstimo
        minhaConta.solicitarEmprestimo(1000.0, 0.05, 12);

        // Pagar uma parcela do empréstimo
        Emprestimo emprestimo = minhaConta.getEmprestimos().get(0);
        emprestimo.pagarParcela(100.0);

        // Verificar o saldo devedor
        System.out.println("Saldo devedor atual: " + emprestimo.getSaldoDevedor());

        // Imprimir detalhes dos empréstimos
        minhaConta.imprimirEmprestimosCorrente();
    }
}