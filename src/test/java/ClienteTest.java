import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test
    void criaClienteComDadosEPermiteConsultaLos() {
        Cliente cliente = new Cliente(1, "Ana", 10);

        assertEquals(1, cliente.getId());
        assertEquals("Ana", cliente.getNome());
        assertEquals(10, cliente.getDesconto());
    }
}
