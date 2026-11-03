import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContaClienteTest {

    @Test
    void deveGuardarIdDaConta() {
        ContaCliente conta = new ContaCliente(1);

        assertEquals(1, conta.getId());
    }
    
    @Test
void deveIniciarComSaldoZero() {
    ContaCliente conta = new ContaCliente(1);

    assertEquals(0.0, conta.getSaldo(), 0.0001);
}
}