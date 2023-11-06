package Main;
import java.util.Scanner;

import Dominio.Contacto;
import Dominio.LibretaDeContactos;

public class Main {
    public static void main(String[] args) {
        LibretaDeContactos libreta = new LibretaDeContactos();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Añadir contacto");
                System.out.println("2. Listar contactos");
                System.out.println("3. Guardar contactos en archivo");
                System.out.println("4. Cargar contactos desde archivo");
                System.out.println("5. Salir");

                int opcion = scanner.nextInt();
                scanner.nextLine();  

                if (opcion == 1) {
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Primer Apellido: ");
                    String primerApellido = scanner.nextLine();
                    System.out.print("Segundo Apellido: ");
                    String segundoApellido = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    libreta.añadirContacto(new Contacto(nombre, primerApellido, segundoApellido, telefono));
                } else if (opcion == 2) {
                    System.out.println("Contactos en la libreta:");
                    libreta.listarContactos();
                } else if (opcion == 3) {
                    libreta.guardarContactosEnArchivo("contactos.dat");
                } else if (opcion == 4) {
                    libreta.cargarContactosDesdeArchivo("contactos.dat");
                } else if (opcion == 5) {
                    break;
                } else {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        }
    }
}
