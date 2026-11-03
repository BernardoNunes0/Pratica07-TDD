import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


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

    @Test
    void deveCriarContaComClienteESaldoZero() {
    Cliente cliente = new Cliente(1, "Ana", 10);

    ContaCliente conta = new ContaCliente(7, cliente);

    assertEquals(7, conta.getId());
    assertEquals(cliente, conta.getCliente());
    assertEquals(0.0, conta.getSaldo(), 0.0001);
}

    @Test
    void devePermitirDefinirETrocarCliente() {
    ContaCliente conta = new ContaCliente(7);
    Cliente ana = new Cliente(1, "Ana", 10);
    Cliente bruno = new Cliente(2, "Bruno", 20);

    conta.setCliente(ana);
    assertEquals(ana, conta.getCliente());

    conta.setCliente(bruno);
    assertEquals(bruno, conta.getCliente());
}   

    @Test
    void devePermitirAlterarSaldoInclusiveParaZero() {
    ContaCliente conta = new ContaCliente(7);

    conta.setSaldo(250.50);
    assertEquals(250.50, conta.getSaldo(), 0.0001);

    conta.setSaldo(0.0);
    assertEquals(0.0, conta.getSaldo(), 0.0001);
}   

    @Test
    void deveRejeitarSaldoNegativoSemAlterarSaldoAnterior() {
    ContaCliente conta =
            new ContaCliente(7, new Cliente(1, "Ana", 10), 100.0);

    assertThrows(IllegalArgumentException.class,
            () -> conta.setSaldo(-1.0));

    assertEquals(100.0, conta.getSaldo(), 0.0001);
}

    @ParameterizedTest
    @ValueSource(doubles = {
    Double.NaN,
    Double.POSITIVE_INFINITY,
    Double.NEGATIVE_INFINITY
    })
    void deveRejeitarSaldoNaoFinitoSemAlterarSaldoAnterior(double valor) {
    ContaCliente conta =
            new ContaCliente(7, new Cliente(1, "Ana", 10), 100.0);

    assertThrows(IllegalArgumentException.class,
            () -> conta.setSaldo(valor));

    assertEquals(100.0, conta.getSaldo(), 0.0001);
}

    @ParameterizedTest
    @ValueSource(doubles = {
    -1.0,
    Double.NaN,
    Double.POSITIVE_INFINITY,
    Double.NEGATIVE_INFINITY
    })
    void deveRejeitarSaldoInvalidoNoConstrutor(double saldo) {
    Cliente cliente = new Cliente(1, "Ana", 10);

    assertThrows(IllegalArgumentException.class,
            () -> new ContaCliente(7, cliente, saldo));
}
    @Test
    void deveSomarDepositoAoSaldoERetornarNovoSaldo() {
    Cliente cliente = new Cliente(1, "Ana", 10);
    ContaCliente conta = new ContaCliente(7, cliente, 100.0);

    double novoSaldo = conta.addDeposito(50.0);

    assertEquals(150.0, novoSaldo, 0.0001);
    assertEquals(150.0, conta.getSaldo(), 0.0001);
}
    @Test
    void deveMostrarNovoSaldoAposDeposito() {
    ContaCliente conta =
            new ContaCliente(7, new Cliente(1, "Ana", 10), 100.0);

    ByteArrayOutputStream saida = new ByteArrayOutputStream();
    PrintStream saidaOriginal = System.out;
    PrintStream captura = new PrintStream(saida);

    try {
        System.setOut(captura);

        conta.addDeposito(50.0);

        captura.flush();
        assertEquals("Novo saldo: R$150.00",
                saida.toString().trim());
    } finally {
        System.setOut(saidaOriginal);
        captura.close();
    }
}
    @Test
    void deveRejeitarDepositoNegativoSemAlterarSaldo() {
    ContaCliente conta =
            new ContaCliente(7, new Cliente(1, "Ana", 10), 100.0);

    assertThrows(IllegalArgumentException.class,
            () -> conta.addDeposito(-50.0));

    assertEquals(100.0, conta.getSaldo(), 0.0001);
}
    @Test
    void deveManterSaldoAoDepositarZero() {
    Cliente cliente = new Cliente(1, "Ana", 10);
    ContaCliente conta = new ContaCliente(7, cliente, 100.0);

    double novoSaldo = conta.addDeposito(0.0);

    assertEquals(100.0, novoSaldo, 0.0001);
    assertEquals(100.0, conta.getSaldo(), 0.0001);
}
    @ParameterizedTest
@ValueSource(doubles = {
        Double.NaN,
        Double.POSITIVE_INFINITY,
        Double.NEGATIVE_INFINITY
})
    void deveRejeitarDepositoNaoFinitoSemAlterarSaldo(double valor) {
    Cliente cliente = new Cliente(1, "Ana", 10);
    ContaCliente conta = new ContaCliente(7, cliente, 100.0);

    assertThrows(IllegalArgumentException.class,
            () -> conta.addDeposito(valor));

    assertEquals(100.0, conta.getSaldo(), 0.0001);
}
    @Test
    void deveSubtrairSaqueDoSaldoERetornarNovoSaldo() {
    Cliente cliente = new Cliente(1, "Ana", 10);
    ContaCliente conta = new ContaCliente(7, cliente, 100.0);

    double novoSaldo = conta.subSaldo(40.0);

    assertEquals(60.0, novoSaldo, 0.0001);
    assertEquals(60.0, conta.getSaldo(), 0.0001);
}
    @Test
void deveManterSaldoQuandoSaqueForMaiorQueSaldoDisponivel() {
    Cliente cliente = new Cliente(1, "Ana", 10);
    ContaCliente conta = new ContaCliente(7, cliente, 100.0);

    double saldoAposSaque = conta.subSaldo(150.0);

    assertEquals(100.0, saldoAposSaque, 0.0001);
    assertEquals(100.0, conta.getSaldo(), 0.0001);
}
    @Test
    void deveAvisarQuandoSaldoForInsuficiente() {
    Cliente cliente = new Cliente(1, "Ana", 10);
    ContaCliente conta = new ContaCliente(7, cliente, 100.0);

    ByteArrayOutputStream saida = new ByteArrayOutputStream();
    PrintStream saidaOriginal = System.out;
    PrintStream captura = new PrintStream(saida);

    try {
        System.setOut(captura);

        conta.subSaldo(150.0);

        captura.flush();
        assertEquals("Saldo insuficiente!",
                saida.toString().trim());
    } finally {
        System.setOut(saidaOriginal);
        captura.close();
    }
}
    @Test
void deveRejeitarSaqueNegativoSemAlterarSaldo() {
    Cliente cliente = new Cliente(1, "Ana", 10);
    ContaCliente conta = new ContaCliente(7, cliente, 100.0);

    assertThrows(IllegalArgumentException.class,
            () -> conta.subSaldo(-50.0));

    assertEquals(100.0, conta.getSaldo(), 0.0001);
}
    
@Test
void devePermitirSacarTodoSaldoDisponivel() {
    Cliente cliente = new Cliente(1, "Ana", 10);
    ContaCliente conta = new ContaCliente(7, cliente, 100.0);

    double saldoAposSaque = conta.subSaldo(100.0);

    assertEquals(0.0, saldoAposSaque, 0.0001);
    assertEquals(0.0, conta.getSaldo(), 0.0001);
}
    
@Test
void deveManterSaldoAoSacarZero() {
    Cliente cliente = new Cliente(1, "Ana", 10);
    ContaCliente conta = new ContaCliente(7, cliente, 100.0);

    double saldoAposSaque = conta.subSaldo(0.0);

    assertEquals(100.0, saldoAposSaque, 0.0001);
    assertEquals(100.0, conta.getSaldo(), 0.0001);
}
    
@ParameterizedTest
@ValueSource(doubles = {
        Double.NaN,
        Double.POSITIVE_INFINITY,
        Double.NEGATIVE_INFINITY
})
void deveRejeitarSaqueNaoFinitoSemAlterarSaldo(double valor) {
    Cliente cliente = new Cliente(1, "Ana", 10);
    ContaCliente conta = new ContaCliente(7, cliente, 100.0);

    assertThrows(IllegalArgumentException.class,
            () -> conta.subSaldo(valor));

    assertEquals(100.0, conta.getSaldo(), 0.0001);
}
    
@Test
void deveExibirDadosDaContaNoToString() {
    Cliente cliente = new Cliente(1, "Ana", 10);
    ContaCliente conta = new ContaCliente(7, cliente, 100.0);

    String resultado = conta.toString();

    assertEquals("Ana(7) saldo=R$100.00", resultado);
}
    
@Test
void deveExibirSaldoAtualizadoNoToString() {
    Cliente cliente = new Cliente(1, "Ana", 10);
    ContaCliente conta = new ContaCliente(7, cliente, 100.0);

    conta.addDeposito(50.0);

    assertEquals("Ana(7) saldo=R$150.00", conta.toString());

    conta.subSaldo(30.0);

    assertEquals("Ana(7) saldo=R$120.00", conta.toString());
}


}