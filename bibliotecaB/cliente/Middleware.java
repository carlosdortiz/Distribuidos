import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Middleware extends Remote { 

    public String buscarTitulo(String titulo) throws RemoteException;
    public String buscarAutor(String autor) throws RemoteException;
    
}