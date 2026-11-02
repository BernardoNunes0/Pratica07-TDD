import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FaturaClienteTest {
    @Test
    void criaFaturaComTodosOsDados() {
        Cliente cliente = new Cliente(1, "Ana", 10);
        FaturaCliente fatura = new FaturaCliente(7, cliente, 250.0);
        assertEquals(7, fatura.getId());
        assertSame(cliente, fatura.getCliente());
        assertEquals(250.0, fatura.getValor(), 0.0001);
    }

    @Test
    void criaFaturaSomenteComId() {
        FaturaCliente fatura = new FaturaCliente(8);
        assertEquals(8, fatura.getId());
        assertNull(fatura.getCliente());
        assertEquals(0.0, fatura.getValor(), 0.0001);
    }

    @Test
    void permiteDefinirETrocarCliente() {
        FaturaCliente fatura = new FaturaCliente(7);
        Cliente ana = new Cliente(1, "Ana", 10);
        Cliente bruno = new Cliente(2, "Bruno", 20);
        fatura.setCliente(ana);
        assertSame(ana, fatura.getCliente());
        fatura.setCliente(bruno);
        assertSame(bruno, fatura.getCliente());
    }

    @Test
    void permiteAlterarValorEUsarZero() {
        FaturaCliente fatura = new FaturaCliente(7);
        fatura.setValor(135.50);
        assertEquals(135.50, fatura.getValor(), 0.0001);
        fatura.setValor(0.0);
        assertEquals(0.0, fatura.getValor(), 0.0001);
    }

    @Test
    void aplicaDescontoPercentualSemAlterarValorOriginal() {
        FaturaCliente fatura = new FaturaCliente(7,
                new Cliente(1, "Ana", 15), 199.90);
        assertEquals(169.915, fatura.getValorComDesconto(), 0.000001);
        assertEquals(199.90, fatura.getValor(), 0.0001);
    }
}
