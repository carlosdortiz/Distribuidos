import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MiddlewareClienteA {

    public String comando;
    public String biblioteca;

    public MiddlewareClienteA(String newComando, String newbiblioteca) {
        this.comando = newComando;
        this.biblioteca = newbiblioteca;
    }

    public String traduccionLengA() throws RemoteException {
        // este metodo recibe el comando completo que desea ejecutar nuestro usuario
        // como String y lo traduce al lenguaje Z

        if (this.comando.indexOf("pedirLibro") == 1) {
            // en caso de que el comando recibido sea pedirLibro lo tracuce a
            // getTittle

            return this.comando.replaceAll("pedirLibro", "getTittle");
        } else {
            // sino eso significa que el comando es pedirAutor y lo traduce a getAuthor
            return this.comando.replaceAll("pedirAutor", "getAuthor");
        }
    }

    public void pedirLibro() throws RemoteException {

        if (this.biblioteca == "A") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorA libroBuscado = (MiddlewareServidorA) registry.lookup("l");

                System.out.println(libroBuscado.traduccionLengZ(traduccionLengA()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        } else if (this.biblioteca == "B") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorA libroBuscado = (MiddlewareServidorA) registry.lookup("l");

                System.out.println(libroBuscado.traduccionLengZ(traduccionLengA()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        } else if (this.biblioteca == "C") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorA libroBuscado = (MiddlewareServidorA) registry.lookup("l");

                System.out.println(libroBuscado.traduccionLengZ(traduccionLengA()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        }

    }

    public void pedirAutor() throws RemoteException {

        if (this.biblioteca == "A") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorA libroBuscado = (MiddlewareServidorA) registry.lookup("l");

                System.out.println(libroBuscado.traduccionLengZ(traduccionLengA()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        } else if (this.biblioteca == "B") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorA libroBuscado = (MiddlewareServidorA) registry.lookup("l");

                System.out.println(libroBuscado.traduccionLengZ(traduccionLengA()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        } else if (this.biblioteca == "C") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorA libroBuscado = (MiddlewareServidorA) registry.lookup("l");

                System.out.println(libroBuscado.traduccionLengZ(traduccionLengA()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        }

    }
}
