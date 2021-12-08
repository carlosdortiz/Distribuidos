import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteC{
    public static void main(String [] args){

        Scanner input = new Scanner(System.in);
        System.out.println("1) Pedir Libro");
        System.out.println("2) Pedir Autor");
        System.out.println("Elija una opcion");
        int opcion = input.nextInt();

        if (opcion == 1) {

            System.out.print("libro:");
            Scanner libroIn = new Scanner(System.in);
            String libro = libroIn.nextLine();
            System.out.print("biblioteca:");
            Scanner bibIn = new Scanner(System.in);
            String biblioteca = bibIn.nextLine();

            if (biblioteca == ""){
                try{

                Registry registry = LocateRegistry.getRegistry("127.0.0.1",9100);

                Middleware libroBuscado = (Middleware) registry.lookup("l");
                

                System.out.println(libroBuscado.encontrarVol(libro));

                }catch(Exception e){
                    System.out.println("Client side error..." + e);
                }

            }

        }else if (opcion == 2){

            System.out.print("Autor:");
            Scanner autorIn = new Scanner(System.in);
            String autor = autorIn.nextLine();
            System.out.print("biblioteca:");
            Scanner bibIn = new Scanner(System.in);
            String biblioteca = bibIn.nextLine();

            if (biblioteca == ""){
                try{

                Registry registry = LocateRegistry.getRegistry("127.0.0.1",9100);

                Middleware libroBuscado = (Middleware) registry.lookup("l");
                

                System.out.println(libroBuscado.encontrarAutor(autor));

                }catch(Exception e){
                    System.out.println("Client side error..." + e);
                }

            }

        }else{
            System.out.println("opción no válida");
        }

    }
}