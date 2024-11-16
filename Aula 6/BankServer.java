import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class BankServer {
    private static final String FILE_PATH = "C:\\If Goiano\\6º Período\\DSD\\Aula 6\\accounts.txt";

    private static Map<String, Double> accounts = new HashMap<>();

    public static void main(String[] args) {
        loadAccounts();

        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor bancário iniciado...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    // Recebendo a solicitação do cliente
                    String request = in.readLine();
                    String[] parts = request.split(",");
                    String accountNumber = parts[0];
                    String operation = parts[1];
                    double amount = Double.parseDouble(parts[2]);

                    // Processando a operação
                    String response = processTransaction(accountNumber, operation, amount);
                    out.println(response);
                    
                    // Atualizando o arquivo após a operação
                    saveAccounts();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadAccounts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                accounts.put(parts[0], Double.parseDouble(parts[1]));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar contas: " + e.getMessage());
        }
    }

    private static void saveAccounts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<String, Double> entry : accounts.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar contas: " + e.getMessage());
        }
    }

    private static String processTransaction(String accountNumber, String operation, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            return "Erro: Conta não encontrada.";
        }
        
        double balance = accounts.get(accountNumber);
        if (operation.equalsIgnoreCase("deposito")) {
            balance += amount;
            accounts.put(accountNumber, balance);
            return "Depósito realizado. Novo saldo: " + balance;
        } else if (operation.equalsIgnoreCase("saque")) {
            if (balance < amount) {
                return "Erro: Saldo insuficiente.";
            }
            balance -= amount;
            accounts.put(accountNumber, balance);
            return "Saque realizado. Novo saldo: " + balance;
        } else {
            return "Erro: Operação desconhecida.";
        }
    }
}
