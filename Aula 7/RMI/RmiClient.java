package RMI;
import java.rmi.Naming;
import javax.swing.*;

public class RmiClient {
    public static void main(String[] args) {
        try {
            CoordinateConverter converter = (CoordinateConverter) Naming.lookup("//localhost/CoordinateConverter");

            String xStr = JOptionPane.showInputDialog("Digite a coordenada x:");
            String yStr = JOptionPane.showInputDialog("Digite a coordenada y:");

            double x = Double.parseDouble(xStr);
            double y = Double.parseDouble(yStr);

            double[] polar = converter.toPolar(x, y);

            JOptionPane.showMessageDialog(null, String.format("Coordenadas Polares:\nr: %.2f\nθ: %.2f radianos", polar[0], polar[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
