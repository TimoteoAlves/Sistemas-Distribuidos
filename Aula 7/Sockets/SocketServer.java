import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Servidor iniciado. Aguardando conexões...");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado.");

                try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

                    double x = Double.parseDouble(input.readLine());
                    double y = Double.parseDouble(input.readLine());

                    double r = Math.sqrt(x * x + y * y);
                    double theta = Math.atan2(y, x);
                    output.println(r);
                    output.println(theta);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
