public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "Ana", 10);
        ContaCliente conta = new ContaCliente(7, cliente);

        System.out.println("Cliente: " + cliente);
        System.out.println("Conta inicial: " + conta);

        conta.addDeposito(100.00);
        double saldoAposSaque = conta.subSaldo(30.00);

        System.out.printf("Saldo depois do saque: R$%.2f%n", saldoAposSaque);
        System.out.println("Conta final: " + conta);
    }
}
