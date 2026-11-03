
public class ContaCliente {
    private final int id;
    private double saldo = 0.0;
    private Cliente cliente;

    public ContaCliente(int id) {
        this.id = id;
}

    public ContaCliente(int id, Cliente cliente) {
    this(id, cliente, 0.0);
}

    public int getId() {
        return id;
}

    public double getSaldo() {
    return saldo;
}

    public Cliente getCliente() {
    return cliente;
}

    public void setCliente(Cliente cliente) {
    this.cliente = cliente;
}

    public void setSaldo(double saldo) {
    if (saldo < 0 || Double.isNaN(saldo) || Double.isInfinite(saldo)) {
        throw new IllegalArgumentException(
                "O saldo deve ser finito e nao negativo.");
    }

    this.saldo = saldo;
}

    public ContaCliente(int id, Cliente cliente, double saldo) {
    this(id);
    this.cliente = cliente;
    setSaldo(saldo);
}
   
public double addDeposito(double valor) {
    if (valor < 0) {
        throw new IllegalArgumentException(
                "O deposito nao pode ser negativo.");
    }

    setSaldo(getSaldo() + valor);

    System.out.println("Novo saldo: " + formatarSaldo());

    return getSaldo();
}

   
    public double subSaldo(double valor) {
    if (valor < 0 || Double.isNaN(valor)
            || Double.isInfinite(valor)) {
        throw new IllegalArgumentException(
                "O saque deve ser finito e nao negativo.");
    }

    if (valor > getSaldo()) {
        System.out.println("Saldo insuficiente!");
        return getSaldo();
    }

    setSaldo(getSaldo() - valor);
    return getSaldo();
}

   
@Override
public String toString() {
    return cliente.getNome() + "(" + id + ") saldo=" + formatarSaldo();
}

    
private String formatarSaldo() {
    return String.format(
            java.util.Locale.US,
            "R$%.2f",
            getSaldo());
}


}
    
