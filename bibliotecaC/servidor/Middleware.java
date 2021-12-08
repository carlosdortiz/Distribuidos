import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Middleware extends Remote { 

    public String encontrarVol(String titulo) throws RemoteException;
    public String encontrarAutor(String autor) throws RemoteException;

}