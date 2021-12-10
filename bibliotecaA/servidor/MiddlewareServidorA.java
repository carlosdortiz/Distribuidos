import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MiddlewareServidorA extends Remote {

    public String traduccionLengZ(String comando) throws RemoteException;

    public String pedirLibro(String libro) throws RemoteException;

    public String pedirAutor(String autor) throws RemoteException;

}