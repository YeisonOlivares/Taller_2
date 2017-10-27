import java.util.Date;
/**
 *
 * @author Yeison Olivares, Rodrigo Dominguez
 */
public class Prestamo {
    
    private String codigo;
    private String idCliente;
    private int libroPedido;
    private Date fechaPrestamo;
    private Date fechaAproxEntrega;
    private String fechaRealEntrega;
    
    /**
     * Constructor de la clase Prestamo
     * @param codigo Asigna código único a cada prestamo
     * @param idCliente Asigna el rut a cada prestamo
     * @param libroPedido Asigna el código único del libro solicitado (ISBN) en cada prestamo
     * @param fechaPrestamo Asigna la fecha en que fue realizado el prestamo
     * @param fechaAproxEntrega Asigna la fecha estimada en que se devolverá el libro
     * @param fechaRealEntrega Asigna la fecha real en que fue devuelto el libro, si este no ha sido devuelto se coloca el número 0
     */
    public Prestamo(String codigo, String idCliente, int libroPedido, Date fechaPrestamo, Date fechaAproxEntrega, String fechaRealEntrega){
        
        this.codigo = codigo;
        this.idCliente = idCliente;
        this.libroPedido = libroPedido;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaAproxEntrega = fechaAproxEntrega;
        this.fechaRealEntrega = fechaRealEntrega;
        
    }
    
    /**
     * Obtener el código del prestamo
     * @return retorna el código del prestamo consultado
     */
    public String getCodigo(){
        return this.codigo;
    }
    /**
     *Obtener el rut del cliente
     * @return retorna el rut del cliente asociado al prestamo
     */
    public String getIdCliente(){
        return this.idCliente;
    }
    /**
     * Obtener el código ISBN
     * @return retorna el código ISBN del libro asociado al prestamo
     */
    public int getLibroPedido(){
        return this.libroPedido;
    }
    /**
     * Obtener fecha de prestamo
     * @return retorna la fecha en que fue realizado el prestamo
     */
    public Date getFechaPrestamo(){
        return this.fechaPrestamo;
    }
    /**
     * Obtener fecha estimada de devolución
     * @return retorna la decha estimada de devolución del libro asociado al prestamo
     */
    public Date getFechaAproxEntrega(){
        return this.fechaAproxEntrega;
    }
    /**
     * Obtener fecha real de entrega
     * @return retorna la fecha en que fue devuelto el libro asociado al prestamo
     */
    public String getFechaRealEntrega(){
        return this.fechaRealEntrega;
    }
    /**
     * Cambiar código único
     * @param codigo Corresponde al código único nuevo del prestamo
     */
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    /**
     * Cambiar rut del cliente
     * @param idCliente Corresponde al nuevo rut del cliente
     */
    public void setIdCliente(String idCliente){
        this.idCliente = idCliente;
    }
    /**
     * Cambiar ISBN del libro
     * @param libroPedido Corresponde al nuevo código ISBN del libro asociado
     */
    public void setLibroPedido(int libroPedido){
        this.libroPedido = libroPedido;
    }
    /**
     * Cambiar fecha de prestamo
     * @param fechaPrestamo Corresponde a la nueva fecha en que fue realizo el prestamo
     */
    public void setFechaPrestamo(Date fechaPrestamo){
        this.fechaPrestamo = fechaPrestamo;
    }
    /**
     * Cambiar fecha estimada de devolución
     * @param fechaAproxEntrega Corresponde a la nueva fecha de devolución estimada asociada al prestamo
     */
    public void setFechaAproxEntrega(Date fechaAproxEntrega){
        this.fechaAproxEntrega = fechaAproxEntrega;
    }
    /**
     * Cambiar fecha de real de devolucion del libro
     * @param fechaRealEntrega Corresponde a la nueva fecha de devolución real asociada al prestamo
     */
    public void setFechaRealEntrega(String fechaRealEntrega){
        this.fechaRealEntrega = fechaRealEntrega;
    }
    
}
