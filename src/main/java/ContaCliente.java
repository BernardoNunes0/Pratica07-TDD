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
    if (saldo < 0) {
        throw new IllegalArgumentException(
                "O saldo nao pode ser negativo.");
    }

    this.saldo = saldo;
}

    public ContaCliente(int id, Cliente cliente, double saldo) {
    this(id);
    this.cliente = cliente;
    this.saldo = saldo;
    }
}