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

    @Test
    void deveCriarContaComClienteESaldoInformado() {
    Cliente cliente = new Cliente(1, "Ana", 10);

    ContaCliente conta = new ContaCliente(7, cliente, 150.0);

    assertEquals(7, conta.getId());
    assertEquals(cliente, conta.getCliente());
    assertEquals(150.0, conta.getSaldo(), 0.0001);
}

}