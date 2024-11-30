package RMI;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CoordinateConverter extends Remote {
    double[] toPolar(double x, double y) throws RemoteException;
}
