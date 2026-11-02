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
}
