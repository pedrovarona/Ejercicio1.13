import java.io.Serializable;
import java.util.Objects;

/**
 * La clase Contacto representa un contacto con nombre, primer apellido, segundo apellido y número de teléfono.
 */
public class Contacto implements Serializable {

    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String numeroDeTelefono;

    /**
     * Crea un nuevo objeto Contacto con la información proporcionada.
     * @param nombre El nombre del contacto.
     * @param primerApellido El primer apellido del contacto.
     * @param segundoApellido El segundo apellido del contacto.
     * @param numeroDeTelefono El número de teléfono del contacto.
     */
    public Contacto(String nombre, String primerApellido, String segundoApellido, String numeroDeTelefono) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.numeroDeTelefono = numeroDeTelefono;
    }

    /**
     * Obtiene el nombre del contacto.
     * @return El nombre del contacto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre del contacto.
     * @param nombre El nuevo nombre del contacto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el primer apellido del contacto.
     * @return El primer apellido del contacto.
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * Actualiza el primer apellido del contacto.
     * @param primerApellido El nuevo primer apellido del contacto.
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * Obtiene el segundo apellido del contacto.
     * @return El segundo apellido del contacto.
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * Actualiza el segundo apellido del contacto.
     * @param segundoApellido El nuevo segundo apellido del contacto.
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**
     * Obtiene el número de teléfono del contacto.
     * @return El número de teléfono del contacto.
     */
    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    /**
     * Actualiza el número de teléfono del contacto.
     * @param numeroDeTelefono El nuevo número de teléfono del contacto.
     */
    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contacto contacto = (Contacto) obj;
        return Objects.equals(nombre, contacto.nombre) &&
                Objects.equals(primerApellido, contacto.primerApellido) &&
                Objects.equals(segundoApellido, contacto.segundoApellido) &&
                Objects.equals(numeroDeTelefono, contacto.numeroDeTelefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, primerApellido, segundoApellido, numeroDeTelefono);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Primer Apellido: " + primerApellido +
                ", Segundo Apellido: " + segundoApellido + ", Teléfono: " + numeroDeTelefono;
    }
}
