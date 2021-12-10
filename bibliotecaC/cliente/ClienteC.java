import java.rmi.RemoteException;
import java.util.Scanner;

public class ClienteC {
    public static void main(String[] args) throws RemoteException {

        Scanner input = new Scanner(System.in);
        System.out.println("\nBIENVENIDO A LA BIBLIOTECA C\n");
        System.out.println("1) Encontrar Volumen");
        System.out.println("2) Encontrar Autor");
        System.out.println("Elija una opcion\n");
        int opcion = input.nextInt();

        if (opcion == 1) {

            System.out.print("Volumen: ");
            Scanner volumenIn = new Scanner(System.in);
            String volumen = volumenIn.nextLine();
            System.out.print("Biblioteca en la que desea buscar: ");
            Scanner bibIn = new Scanner(System.in);
            String biblioteca = bibIn.nextLine();

            MiddlewareClienteC middleware = new MiddlewareClienteC("encontrarVolumen(" + volumen + ")", biblioteca);

            middleware.encontrarVolumen();

            volumenIn.close();
            bibIn.close();

        } else if (opcion == 2) {

            System.out.print("Autor: ");
            Scanner autorIn = new Scanner(System.in);
            String autor = autorIn.nextLine();
            System.out.print("Biblioteca en la que desea buscar: ");
            Scanner bibIn = new Scanner(System.in);
            String biblioteca = bibIn.nextLine();

            MiddlewareClienteC middleware = new MiddlewareClienteC("encontrarAutor(" + autor + ")", biblioteca);

            middleware.encontrarAutor();

            autorIn.close();
            bibIn.close();

        } else {
            System.out.println("Opción no válida");
        }

        input.close();

    }
}