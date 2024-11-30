package RMI;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

// Implementação do servidor RMI
public class RmiServer extends UnicastRemoteObject implements CoordinateConverter {

    protected RmiServer() throws RemoteException {
        super();
    }

    @Override
    public double[] toPolar(double x, double y) throws RemoteException {
        double r = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(y, x);
        return new double[]{r, theta};
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            RmiServer server = new RmiServer();
            Naming.rebind("CoordinateConverter", server);

            System.out.println("Servidor RMI iniciado na porta 1099.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
