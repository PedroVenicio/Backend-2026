package contas;

public class ContaEstrangeira extends Conta {

    private static final double COTACAO_DOLAR = 5.40;

    @Override
    public String tipoDeConta() {
        return ("Conta em Dólar");
    };

    @Override
    public String moeda() {
        return ("$");
    };

    public ContaEstrangeira(String titular, String numero) {super(titular, numero);}

    @Override
    public void depositar(double valor) {
        super.depositar(valor / COTACAO_DOLAR, "Depósito");
    }

    @Override
    public boolean sacar(double valor){
        //saque divide pela cotação também pois todo valor informado é em reais, tem que converter
        return super.sacar(valor / COTACAO_DOLAR, "Saque");
    }

    public double getSaldoEmReais() {
        return super.getSaldo() * COTACAO_DOLAR;
    }
}
