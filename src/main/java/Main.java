import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(new Locale("pt", "BR"));

        System.out.print("ID do cliente: ");
        int idCliente = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Nome do cliente: ");
        String nome = entrada.nextLine();

        System.out.print("Desconto do cliente (0 a 100): ");
        int desconto = entrada.nextInt();

        System.out.print("ID da conta: ");
        int idConta = entrada.nextInt();

        System.out.print("Saldo inicial: R$ ");
        double saldoInicial = entrada.nextDouble();

        Cliente cliente = new Cliente(idCliente, nome, desconto);
        ContaCliente conta = new ContaCliente(idConta, cliente, saldoInicial);

        System.out.println();
        System.out.println("Cliente: " + cliente);
        System.out.println("Conta inicial: " + conta);

        System.out.print("Valor do depósito: R$ ");
        double deposito = entrada.nextDouble();
        conta.addDeposito(deposito);

        System.out.print("Valor do saque: R$ ");
        double saque = entrada.nextDouble();
        double saldoFinal = conta.subSaldo(saque);

        System.out.printf(Locale.forLanguageTag("pt-BR"),
                "Saldo final: R$ %.2f%n", saldoFinal);
        System.out.println("Conta final: " + conta);

        entrada.close();
    }
}
