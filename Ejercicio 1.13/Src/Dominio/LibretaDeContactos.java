package Dominio;
import java.io.*;
import java.util.ArrayList;

/**
 * La clase LibretaDeContactos gestiona una lista de contactos.
 */
public class LibretaDeContactos {
    private ArrayList<Contacto> contactos;  // Se inicializará en el constructor

    /**
     * Constructor de la clase LibretaDeContactos.
     */
    public LibretaDeContactos() {
        contactos = new ArrayList<>();
    }

    /**
     * Añade un nuevo contacto a la libreta.
     * @param contacto El contacto a añadir.
     */
    public void añadirContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    /**
     * Lista todos los contactos en la libreta.
     */
    public void listarContactos() {
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    /**
     * Guarda la lista de contactos en un archivo.
     * @param nombreArchivo El nombre del archivo en el que se guardarán los contactos.
     */
    public void guardarContactosEnArchivo(String nombreArchivo) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            salida.writeObject(contactos);
            System.out.println("Contactos guardados en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga la lista de contactos desde un archivo.
     * @param nombreArchivo El nombre del archivo desde el que se cargarán los contactos.
     */
    public void cargarContactosDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            Object objetoLeído = entrada.readObject();
            if (objetoLeído instanceof ArrayList<?>) {
                ArrayList<?> listaContactos = (ArrayList<?>) objetoLeído;
                ArrayList<Contacto> nuevosContactos = new ArrayList<>();

                for (Object item : listaContactos) {
                    if (item instanceof Contacto) {
                        nuevosContactos.add((Contacto) item);
                    }
                }

                if (!nuevosContactos.isEmpty()) {
                    contactos = nuevosContactos;
                    System.out.println("Contactos cargados desde " + nombreArchivo);
                } else {
                    System.out.println("El archivo no contiene una lista de contactos válida.");
                }
            } else {
                System.out.println("El archivo no contiene una lista de contactos válida.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
