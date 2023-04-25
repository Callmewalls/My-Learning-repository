package Java;

/**
 * Esta clase representa a una persona
 * @version 1.0
 * @author Fernando Paredes Mora
 */

public class Persona {
    // Atributos de la clase
    String nombre, dni, ciudad;
    int edad;


    /**
     * Constructor por defecto
     */
    public Persona() {
        nombre = "";
        dni = "";
        ciudad = "";
        edad = 0;
    }
    /**
     * Constructor con parámetros
     * @param nombre Nombre de la persona
     * @param dni DNI de la persona
     * @param ciudad Ciudad de residencia de la persona
     * @param edad Edad actual de la persona
     *
     */
    public Persona(String nombre, String dni, String ciudad, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.ciudad = ciudad;
        this.edad = edad;
    }

    /**
     * Es el constructor copia
     * @param p recibe un objeto Persona
     */
    public Persona(Persona p){
        nombre =p.nombre;
        dni = p.dni;
        ciudad = p.ciudad;
        edad = p.edad;
    }
    /**
     * Devuelve el nombre de la persona
     * @return  el nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre de la persona
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Devuelve el DNI de la persona
     * @return  el dni de la persona
     */
    public String getDni() {
        return dni;
    }

    /**
     * Modifica el DNI de la persona
     * @param dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    /**
     * Devuelve la ciudad de la persona
     * @return  la ciudad de la persona
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Modifica la ciudad de la persona
     * @param ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    /**
     * Devuelve la edad de la persona
     * @return  la edad de la persona
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Modifica la edad de la persona
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Metodo toString para Persona
     * @return
     */
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", edad=" + edad +
                '}';
    }
}
