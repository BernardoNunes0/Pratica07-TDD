public class ContaCliente {
    private final int id;
    private double saldo = 0.0;
    private Cliente cliente;

    public ContaCliente(int id) {
        this.id = id;
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

    public ContaCliente(int id, Cliente cliente, double saldo) {
    this.id = id;
    this.cliente = cliente;
    this.saldo = saldo;
    }
}