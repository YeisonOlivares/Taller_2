/**
 * Clase Cliente
 * @author Yeison Olivares, Rodrigo Dominguez
 * 
 */
public class Cliente {
    
    private String rut;
    private String nombre;
    private String apellido;
    private int celular;
    private String email;
    private ListaPrestamo listaPrestamo;
    
    /**
     * Constructor de la clase Cliente
     * @param rut Asigna un rut a cada cliente
     * @param nombre Asigna un nombre a cada cliente
     * @param apellido Asigna un apellido a cada cliente
     * @param celular Asigna un numero de celular a cada cliente
     * @param email Asigna un correo electronico a cada cliente
     * @param listaPrestamo El cliente esta asociado a una lista de prestamos
     */
    public Cliente(String rut, String nombre, String apellido, int celular, String email, ListaPrestamo listaPrestamo){
    this.rut = rut;
    this.nombre = nombre;
    this.apellido = apellido;
    this.celular = celular;
    this.email = email;
    this.listaPrestamo = null;
    
    }
    /**
     * Obtener el rut
     * @return retorna el rut cosultado
     */
    public String getRut(){
        return this.rut;
    }
    /**
     * Obtener el nombre
     * @return retorna el nombre consultado
     */
    public String getNombre(){
        return this.nombre;
    }
    /**
     * Obtener el apellido
     * @return retorna el apellido consultado
     */
    public String getApellido(){
        return this.apellido;
    }
    /**
     * Obtener el numero de celular
     * @return retorna el numero de celular consultado
     */
    public int getCelular(){
        return this.celular;
    }
    /**
     * Obtener el email
     * @return retorna el correo consultado
     */
    public String getEmail(){
        return this.email;
    }
    /**
     * Obtener lista de prestamo
     * @return retorna la lista de prestamo consultada asociada a un cliente
     */
    public ListaPrestamo getlistaPrestamo(){
        return this.listaPrestamo;
    }
    /**
     * Cambiar el nombre del cliente
     * @param nombre Corresponde al nuevo nombre que reemplazará al antiguo
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    
}
