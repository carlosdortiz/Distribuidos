import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MiddlewareClienteC {

    public String comando;
    public String biblioteca;

    public MiddlewareClienteC(String newComando, String newbiblioteca) {
        this.comando = newComando;
        this.biblioteca = newbiblioteca;
    }

    public String traduccionLengC() throws RemoteException {
        // este metodo recibe el comando completo que desea ejecutar nuestro usuario
        // como String y lo traduce al lenguaje Z

        if (this.comando.indexOf("encontrarVolumen") == 1) {
            // en caso de que el comando recibido sea encontrarVolumen lo tracuce a
            // getTittle

            return this.comando.replaceAll("encontrarVolumen", "getTittle");
        } else {
            // sino eso significa que el comando es encontarAutor y lo traduce a getAuthor
            return this.comando.replaceAll("encontarAutor", "getAuthor");
        }
    }

    public void encontrarVolumen() throws RemoteException {

        if (this.biblioteca == "A") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorC volumenBuscado = (MiddlewareServidorC) registry.lookup("l");

                System.out.println(volumenBuscado.traduccionLengZ(traduccionLengC()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        } else if (this.biblioteca == "B") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorC volumenBuscado = (MiddlewareServidorC) registry.lookup("l");

                System.out.println(volumenBuscado.traduccionLengZ(traduccionLengC()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        } else if (this.biblioteca == "C") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorC volumenBuscado = (MiddlewareServidorC) registry.lookup("l");

                System.out.println(volumenBuscado.traduccionLengZ(traduccionLengC()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        }

    }

    public void encontarAutor() throws RemoteException {

        if (this.biblioteca == "A") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorC volumenBuscado = (MiddlewareServidorC) registry.lookup("l");

                System.out.println(volumenBuscado.traduccionLengZ(traduccionLengC()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        } else if (this.biblioteca == "B") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorC volumenBuscado = (MiddlewareServidorC) registry.lookup("l");

                System.out.println(volumenBuscado.traduccionLengZ(traduccionLengC()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        } else if (this.biblioteca == "C") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorC volumenBuscado = (MiddlewareServidorC) registry.lookup("l");

                System.out.println(volumenBuscado.traduccionLengZ(traduccionLengC()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        }

    }
}
