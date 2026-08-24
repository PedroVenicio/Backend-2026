package contas;

public class ContaEstrangeira extends Conta {

    private static final double COTACAO_DOLAR = 5.40;

    public ContaEstrangeira(String titular, String numero) {super(titular, numero);}

    @Override
    public void depositar(double valor) {
        super.depositar(valor / COTACAO_DOLAR, "Depósito");
    }

    public void getSaldoEmReais() {
        System.out.println("Saldo da conta estrangeira (em reais): " + super.getSaldo() * COTACAO_DOLAR);
    }


}
