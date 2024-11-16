import java.io.*;
import java.net.*;
import java.util.Scanner;

public class BankClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in)) {

            // Solicitando dados do usuário
            System.out.print("Número da Conta: ");
            String accountNumber = scanner.nextLine();

            System.out.print("Tipo de Operação (deposito/saque): ");
            String operation = scanner.nextLine();

            System.out.print("Valor: ");
            double amount = scanner.nextDouble();

            // Enviando a solicitação ao servidor
            String request = accountNumber + "," + operation + "," + amount;
            out.println(request);

            // Recebendo a resposta do servidor
            String response = in.readLine();
            System.out.println("Resposta do Servidor: " + response);

        } catch (IOException e) {
            System.out.println("Erro na comunicação com o servidor: " + e.getMessage());
        }
    }
}
