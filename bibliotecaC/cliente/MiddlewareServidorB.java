import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MiddlewareServidorB extends Remote {

    public String traduccionLengZ(String comando) throws RemoteException;

    public String encontrarVolumen(String volumen) throws RemoteException;

    public String encontrarAutor(String autor) throws RemoteException;

}