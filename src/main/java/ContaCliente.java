public class ContaCliente {
    private final int id;
    private double saldo = 0.0;

    public ContaCliente(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
    return saldo;
}
}