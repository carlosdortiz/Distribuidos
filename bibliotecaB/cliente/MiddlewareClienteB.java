import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MiddlewareClienteB {

    public String comando;
    public String biblioteca;

    public MiddlewareClienteB(String newComando, String newbiblioteca) {
        this.comando = newComando;
        this.biblioteca = newbiblioteca;
    }

    public String traduccionLengB() throws RemoteException {
        // este metodo recibe el comando completo que desea ejecutar nuestro usuario
        // como String y lo traduce al lenguaje Z

        if (this.comando.indexOf("buscarTitulo") == 1) {
            // en caso de que el comando recibido sea buscarTitulo lo tracuce a
            // getTittle

            return this.comando.replaceAll("buscarTitulo", "getTittle");
        } else {
            // sino eso significa que el comando es buscarAutor y lo traduce a getAuthor
            return this.comando.replaceAll("buscarAutor", "getAuthor");
        }
    }

    public void buscarTitulo() throws RemoteException {

        if (this.biblioteca == "A") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorB tituloBuscado = (MiddlewareServidorB) registry.lookup("l");

                System.out.println(tituloBuscado.traduccionLengZ(traduccionLengB()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        } else if (this.biblioteca == "B") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorB tituloBuscado = (MiddlewareServidorB) registry.lookup("l");

                System.out.println(tituloBuscado.traduccionLengZ(traduccionLengB()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        } else if (this.biblioteca == "C") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorB tituloBuscado = (MiddlewareServidorB) registry.lookup("l");

                System.out.println(tituloBuscado.traduccionLengZ(traduccionLengB()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        }

    }

    public void buscarAutor() throws RemoteException {

        if (this.biblioteca == "A") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorB tituloBuscado = (MiddlewareServidorB) registry.lookup("l");

                System.out.println(tituloBuscado.traduccionLengZ(traduccionLengB()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        } else if (this.biblioteca == "B") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorB tituloBuscado = (MiddlewareServidorB) registry.lookup("l");

                System.out.println(tituloBuscado.traduccionLengZ(traduccionLengB()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        } else if (this.biblioteca == "C") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorB tituloBuscado = (MiddlewareServidorB) registry.lookup("l");

                System.out.println(tituloBuscado.traduccionLengZ(traduccionLengB()));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        }

    }
}
