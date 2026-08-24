package contas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class ContaEstrangeiraTest {
    private static final double DELTA = 0.001;

    @Test
    @DisplayName("Conversão do depósito, R$540,00 viram US100,00")
    void conversaoDoDeposito() {
        ContaEstrangeira conta = new ContaEstrangeira("Angus Young", "2345-6");
        conta.depositar(540);

        assertEquals(100, conta.getSaldo(), DELTA);
    }

    @Test
    @DisplayName("Transferência entre contas, conferindo os dois saldos")
    void transferenciaEntreContas(){
        ContaEstrangeira contaE = new ContaEstrangeira("Tony Iommi", "6661-3");
        ContaCorrente contaC = new ContaCorrente("Branco Mello", "1986-1");

        contaE.depositar(540);
        contaE.transferir(contaC, 40);

        assertEquals(500, contaE.getSaldoEmReais(), DELTA);
        assertEquals(92.59259259259259, contaE.getSaldo(), DELTA);
        assertEquals(40, contaC.getSaldo(), DELTA);
    }

    @Test
    @DisplayName("Transferência recusada por falta de saldo")
    void transferenciaRecusada(){
        ContaEstrangeira contaE = new ContaEstrangeira("Robert Plant", "4323-3");
        ContaCorrente contaC = new ContaCorrente("Tim Maia", "9999-1");

        contaE.transferir(contaC, 50);

        assertEquals(0, contaE.getSaldoEmReais(), DELTA);
        assertEquals(0, contaC.getSaldo(), DELTA);
    }
}
