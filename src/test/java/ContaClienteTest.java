import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContaClienteTest {

    @Test
    void deveGuardarIdDaConta() {
        ContaCliente conta = new ContaCliente(1);

        assertEquals(1, conta.getId());
    }
}