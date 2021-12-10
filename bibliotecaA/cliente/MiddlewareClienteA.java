import java.io.File;
import java.io.FileWriter;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.format.DateTimeFormatter;

public class MiddlewareClienteA {

    public String comando;
    public String biblioteca = "";

    public MiddlewareClienteA(String newComando, String newbiblioteca) {
        this.comando = newComando;
        this.biblioteca = newbiblioteca;
    }

    public String traduccionLengA() throws RemoteException {
        // este metodo recibe el comando completo que desea ejecutar nuestro usuario
        // como String y lo traduce al lenguaje Z
        System.out.println("Comando antes de la traduccion: " + comando);
        if (this.comando.indexOf("pedirLibro") == 1) {
            // en caso de que el comando recibido sea pedirLibro lo tracuce a
            // getTittle
            this.comando = this.comando.replaceAll("pedirLibro", "getTittle");
            System.out.println("Comando despues de la traduccion: " + comando);
            return comando;
        } else {
            // sino eso significa que el comando es pedirAutor y lo traduce a getAuthor
            this.comando = this.comando.replaceAll("pedirAutor", "getAuthor");
            System.out.println("Comando despues de la traduccion: " + comando);
            return comando;
        }
    }

    public void pedirLibro() throws RemoteException {

        // registropeticiones();
        System.out.println("Entro en pedirLibro");
        if (this.biblioteca == "A" || this.biblioteca == "") {
            System.out.println("Entro en el if de la biblioteca A");
            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorA libroBuscado = (MiddlewareServidorA) registry.lookup("l");

                System.out.println(libroBuscado.traduccionLengZ(traduccionLengA(), this.biblioteca));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        } else if (this.biblioteca == "B") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorA libroBuscado = (MiddlewareServidorA) registry.lookup("l");

                System.out.println(libroBuscado.traduccionLengZ(traduccionLengA(), this.biblioteca));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        } else if (this.biblioteca == "C") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorA libroBuscado = (MiddlewareServidorA) registry.lookup("l");

                System.out.println(libroBuscado.traduccionLengZ(traduccionLengA(), this.biblioteca));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        }

    }

    public void pedirAutor() throws RemoteException {

        // registropeticiones();

        if (this.biblioteca == "A") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorA libroBuscado = (MiddlewareServidorA) registry.lookup("l");

                System.out.println(libroBuscado.traduccionLengZ(traduccionLengA(), this.biblioteca));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        } else if (this.biblioteca == "B") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorA libroBuscado = (MiddlewareServidorA) registry.lookup("l");

                System.out.println(libroBuscado.traduccionLengZ(traduccionLengA(), this.biblioteca));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        } else if (this.biblioteca == "C") {

            try {

                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

                MiddlewareServidorA libroBuscado = (MiddlewareServidorA) registry.lookup("l");

                System.out.println(libroBuscado.traduccionLengZ(traduccionLengA(), this.biblioteca));

            } catch (Exception e) {
                System.out.println("Client side error..." + e);
            }

        }

    }

    public void registropeticiones() {
        // hay que cambiar la ruta
        File rpeticiones = new File("C:/Users/RP - ClienteA.txt");

        FileWriter fw = new FileWriter(rpeticiones, true);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        fw.write(this.comando + " " + dtf.format(LocalDateTime.now()) + "\r\n");
        fw.close();
    }
}
