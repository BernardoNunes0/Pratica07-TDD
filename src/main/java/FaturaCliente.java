public class FaturaCliente {
    private final int id;
    private Cliente cliente;
    private double valor;

    public FaturaCliente(int id, Cliente cliente, double valor) {
        this.id = id;
        if (cliente == null) {
            throw new IllegalArgumentException("O cliente não pode ser nulo.");
        }
        if (valor < 0 || Double.isNaN(valor) || Double.isInfinite(valor)) {
            throw new IllegalArgumentException("O valor deve ser finito e não negativo.");
        }
        this.cliente = cliente;
        this.valor = valor;
    }

    public FaturaCliente(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("O cliente não pode ser nulo.");
        }
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0 || Double.isNaN(valor) || Double.isInfinite(valor)) {
            throw new IllegalArgumentException("O valor deve ser finito e não negativo.");
        }
        this.valor = valor;
    }

    public double getValorComDesconto() {
        if (cliente == null) {
            throw new IllegalStateException("Defina o cliente antes de calcular o desconto.");
        }
        return valor * (1 - cliente.getDesconto() / 100.0);
    }

    @Override
    public String toString() {
        return "Fatura [id=" + id + ", cliente=" + cliente + ", valor=" + valor + " ]";
    }
}
