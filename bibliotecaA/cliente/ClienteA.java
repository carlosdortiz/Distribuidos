import java.rmi.RemoteException;
import java.util.Scanner;

public class ClienteA {
    public static void main(String[] args) throws RemoteException {

        Scanner input = new Scanner(System.in);
        System.out.println("\nBIENVENIDO A LA BIBLIOTECA A\n");
        System.out.println("1) Pedir Libro");
        System.out.println("2) Pedir Autor");
        System.out.println("Elija una opcion\n");
        int opcion = input.nextInt();

        if (opcion == 1) {

            System.out.print("Libro: ");
            Scanner libroIn = new Scanner(System.in);
            String libro = libroIn.nextLine();
            System.out.print("Biblioteca en la que desea buscar: ");
            Scanner bibIn = new Scanner(System.in);
            String biblioteca = bibIn.nextLine();

            MiddlewareClienteA middleware = new MiddlewareClienteA("pedirLibro(" + libro + ")", biblioteca);

            middleware.pedirLibro();

            libroIn.close();
            bibIn.close();

        } else if (opcion == 2) {

            System.out.print("Autor: ");
            Scanner autorIn = new Scanner(System.in);
            String autor = autorIn.nextLine();
            System.out.print("Biblioteca en la que desea buscar: ");
            Scanner bibIn = new Scanner(System.in);
            String biblioteca = bibIn.nextLine();

            MiddlewareClienteA middleware = new MiddlewareClienteA("pedirAutor(" + autor + ")", biblioteca);

            middleware.pedirAutor();

            autorIn.close();
            bibIn.close();

        } else {
            System.out.println("Opción no válida");
        }

        input.close();

    }
}