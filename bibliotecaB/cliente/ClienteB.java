import java.rmi.RemoteException;
import java.util.Scanner;

public class ClienteB {
    public static void main(String[] args) throws RemoteException {

        Scanner input = new Scanner(System.in);
        System.out.println("\nBIENVENIDO A LA BIBLIOTECA B\n");
        System.out.println("1) Buscar Titulo");
        System.out.println("2) Buscar Autor");
        System.out.println("Elija una opcion\n");
        int opcion = input.nextInt();

        if (opcion == 1) {

            System.out.print("Titulo: ");
            Scanner tituloIn = new Scanner(System.in);
            String titulo = tituloIn.nextLine();
            System.out.print("Biblioteca en la que desea buscar: ");
            Scanner bibIn = new Scanner(System.in);
            String biblioteca = bibIn.nextLine();

            MiddlewareClienteB middleware = new MiddlewareClienteB("buscarTitulo(" + titulo + ")", biblioteca);

            middleware.buscarTitulo();

            tituloIn.close();
            bibIn.close();

        } else if (opcion == 2) {

            System.out.print("Autor: ");
            Scanner autorIn = new Scanner(System.in);
            String autor = autorIn.nextLine();
            System.out.print("Biblioteca en la que desea buscar: ");
            Scanner bibIn = new Scanner(System.in);
            String biblioteca = bibIn.nextLine();

            MiddlewareClienteB middleware = new MiddlewareClienteB("buscarAutor(" + autor + ")", biblioteca);

            middleware.buscarAutor();

            autorIn.close();
            bibIn.close();

        } else {
            System.out.println("Opción no válida");
        }

        input.close();

    }
}