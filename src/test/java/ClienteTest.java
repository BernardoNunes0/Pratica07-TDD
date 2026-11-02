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

    @Test
    void generoInicialEhNaoDefinido() {
        Cliente cliente = new Cliente(1, "Ana", 10);
        assertEquals("nd", cliente.getGenero());
    }

    @Test
    void permiteAlterarDesconto() {
        Cliente cliente = new Cliente(1, "Ana", 10);
        cliente.setDesconto(25);
        assertEquals(25, cliente.getDesconto());
    }

    @Test
    void formataClienteComoNomeIdEDesconto() {
        Cliente cliente = new Cliente(1, "Ana", 10);
        assertEquals("Ana(1)(10%)", cliente.toString());
    }

    @Test
    void rejeitaDescontoForaDaFaixaSemAlterarOAnterior() {
        Cliente cliente = new Cliente(1, "Ana", 10);
        assertThrows(IllegalArgumentException.class, () -> cliente.setDesconto(-1));
        assertThrows(IllegalArgumentException.class, () -> cliente.setDesconto(101));
        assertEquals(10, cliente.getDesconto());
    }
}
