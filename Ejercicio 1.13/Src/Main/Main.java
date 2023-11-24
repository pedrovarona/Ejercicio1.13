public class Main {

    public static void main(String[] args) {
        LibretaDeContactos libreta = new LibretaDeContactos();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Añadir contacto");
                System.out.println("2. Listar contactos");
                System.out.println("3. Eliminar contacto");
                System.out.println("4. Guardar contactos en archivo");
                System.out.println("5. Cargar contactos desde archivo");
                System.out.println("6. Salir");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        agregarContacto(libreta, scanner);
                        break;
                    case 2:
                        libreta.listarContactos();
                        break;
                    case 3:
                        eliminarContacto(libreta, scanner);
                        break;
                    case 4:
                        libreta.guardarContactosEnArchivo("contactos.dat");
                        break;
                    case 5:
                        libreta.cargarContactosDesdeArchivo("contactos.dat");
                        break;
                    case 6:
                        System.out.println("Saliendo del programa...");
                        return;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        }
    }

    private static void agregarContacto(LibretaDeContactos libreta, Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Primer Apellido: ");
        String primerApellido = scanner.nextLine();
        System.out.print("Segundo Apellido: ");
        String segundoApellido = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        libreta.añadirContacto(new Contacto(nombre, primerApellido, segundoApellido, telefono));
        System.out.println("Contacto añadido correctamente.");
    }

    private static void eliminarContacto(LibretaDeContactos libreta, Scanner scanner) {
        System.out.print("Ingrese el nombre del contacto que desea eliminar: ");
        String nombreContacto = scanner.nextLine();
        if (libreta.eliminarContacto(nombreContacto)) {
            System.out.println("Contacto eliminado correctamente.");
        } else {
            System.out.println("No se encontró el contacto con el nombre especificado.");
        }
    }
}

