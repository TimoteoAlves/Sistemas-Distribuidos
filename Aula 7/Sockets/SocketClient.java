import java.io.*;
import java.net.*;
import javax.swing.*;

public class SocketClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

            String xStr = JOptionPane.showInputDialog("Digite a coordenada x:");
            String yStr = JOptionPane.showInputDialog("Digite a coordenada y:");

            double x = Double.parseDouble(xStr);
            double y = Double.parseDouble(yStr);

            output.println(x);
            output.println(y);

            double r = Double.parseDouble(input.readLine());
            double theta = Double.parseDouble(input.readLine());

            JOptionPane.showMessageDialog(null, String.format("Coordenadas Polares:\nr: %.2f\nθ: %.2f radianos", r, theta));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
