import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Middleware extends Remote { 

    public String pedirLibro(String titulo) throws RemoteException;
    public String pedirAutor(String autor) throws RemoteException;
    
}