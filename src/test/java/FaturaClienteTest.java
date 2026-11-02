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

    @ParameterizedTest
    @ValueSource(ints = {0, 100})
    void aceitaOsLimitesDeDesconto(int desconto) {
        FaturaCliente fatura = new FaturaCliente(7,
                new Cliente(1, "Ana", desconto), 200.0);
        assertEquals(desconto == 0 ? 200.0 : 0.0,
                fatura.getValorComDesconto(), 0.0001);
    }

    @Test
    void usaDescontoAtualDoCliente() {
        Cliente cliente = new Cliente(1, "Ana", 10);
        FaturaCliente fatura = new FaturaCliente(7, cliente, 200.0);
        cliente.setDesconto(25);
        assertEquals(150.0, fatura.getValorComDesconto(), 0.0001);
    }

    @Test
    void atualizaCalculoAoTrocarClienteOuValor() {
        FaturaCliente fatura = new FaturaCliente(7,
                new Cliente(1, "Ana", 10), 200.0);
        fatura.setCliente(new Cliente(2, "Bruno", 50));
        fatura.setValor(300.0);
        assertEquals(150.0, fatura.getValorComDesconto(), 0.0001);
    }

    @Test
    void valorZeroContinuaZeroComDesconto() {
        FaturaCliente fatura = new FaturaCliente(7,
                new Cliente(1, "Ana", 10), 0.0);
        assertEquals(0.0, fatura.getValorComDesconto(), 0.0001);
    }

    @Test
    void formataFaturaComoNoDiagrama() {
        FaturaCliente fatura = new FaturaCliente(7,
                new Cliente(1, "Ana", 10), 250.0);
        assertEquals("Fatura [id=7, cliente=Ana(1)(10%), valor=250.0 ]",
                fatura.toString());
    }

    @Test
    void permiteExibirFaturaAindaSemCliente() {
        assertEquals("Fatura [id=7, cliente=null, valor=0.0 ]",
                new FaturaCliente(7).toString());
    }

    @Test
    void naoCalculaDescontoSemCliente() {
        assertThrows(IllegalStateException.class,
                () -> new FaturaCliente(7).getValorComDesconto());
    }

    @Test
    void rejeitaClienteNuloNoConstrutorCompleto() {
        assertThrows(IllegalArgumentException.class,
                () -> new FaturaCliente(7, null, 200.0));
    }
}
