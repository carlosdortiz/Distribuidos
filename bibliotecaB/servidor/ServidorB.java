import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorB {
    public static void main(String[] args) {

        try {

            System.setProperty("java.rmi.server.hostname", "127.0.0.1");

            MiddlewareServidorBImp p1 = new MiddlewareServidorBImp();

            MiddlewareServidorB stub1 = (MiddlewareServidorB) UnicastRemoteObject.exportObject(p1, 0);

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            registry.bind("l", stub1);

        } catch (Exception e) {
            System.out.println("Error del lado Servidor..." + e);
        }

    }
}