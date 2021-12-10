import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MiddlewareServidorB extends Remote {

    public String traduccionLengZ(String comando) throws RemoteException;

    public String buscarTitulo(String titulo) throws RemoteException;

    public String buscarAutor(String autor) throws RemoteException;

}