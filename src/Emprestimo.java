import java.time.LocalDate;

public class Emprestimo {
    private double valor;
    private double taxaJuros;
    private int prazoMeses;
    private LocalDate dataInicio;
    private double saldoDevedor;

    public Emprestimo(double valor, double taxaJuros, int prazoMeses) {
        this.valor = valor;
        this.taxaJuros = taxaJuros;
        this.prazoMeses = prazoMeses;
        this.dataInicio = LocalDate.now();
        this.saldoDevedor = calcularSaldoDevedor();
    }

    private double calcularSaldoDevedor() {
        return valor + (valor * taxaJuros * prazoMeses / 12);
    }

    public void pagarParcela(double valorParcela) {
        if (valorParcela <= saldoDevedor) {
            saldoDevedor -= valorParcela;
            System.out.println("Parcela paga. Saldo devedor atual: " + saldoDevedor);
        } else {
            System.out.println("Valor da parcela excede o saldo devedor.");
        }
    }

    public double getSaldoDevedor() {
        return saldoDevedor;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public double getValor() {
        return valor;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public int getPrazoMeses() {
        return prazoMeses;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "valor=" + valor +
                ", taxaJuros=" + taxaJuros +
                ", prazoMeses=" + prazoMeses +
                ", dataInicio=" + dataInicio +
                ", saldoDevedor=" + saldoDevedor +
                '}';
    }

}
