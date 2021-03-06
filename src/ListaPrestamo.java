
/**
 * Lista para almacenar los prestamos registrados
 * @author Yeison Olivares, Rodrigo Dominguez
 */
public class ListaPrestamo {
    
    private Prestamo[] listaPrestamo;
    private int maxPrestamo;
    private int cantElementos;
    /**
     * Constructor de la lista prestamos
     * @param maxPrestamo asigna el valor máximo que puede contener la lista
     */
    public ListaPrestamo(int maxPrestamo){
        
        this.maxPrestamo = maxPrestamo;
        this.cantElementos = 0;
        this.listaPrestamo = new Prestamo[maxPrestamo];
        
    }
    /**
     * Metodo para agregar un nuevo prestamo a la lista
     * @param prestamo se ingresa una variable del tipo prestamo con sus atributos
     * @return retorna un boleano verdadero si el prestamo se agrego con exito, de lo contrario un false
     */
    public boolean agregarPrestamo(Prestamo prestamo){
        
        if(this.cantElementos >= this.maxPrestamo){
            return false;
        }else{
            
            this.listaPrestamo[cantElementos] = prestamo;
            cantElementos++;
            return true;
            
        }
    }
    /**
     * Metodo para obtener un prestamo de la lista ingresando una posicion
     * @param pos se ingresa la posicion a buscar en la lista
     * @return retorna el prestamo en dicha posicion
     */
    public Prestamo getPrestamo(int pos){
        return listaPrestamo[pos];
    }
    /**
     * Metodo para obtener el total de prestamos ingresados a la lista
     * @return retorna el total de prestamos ingresados a la lista
     */
    public int getTotalPrestamos(){
        return cantElementos;
    }
    
    /**
     * Metodo para modificar un prestamo de la lista de prestamos
     * @param pos se ingresa la posicion del prestamo en la lista
     * @param prestamo se ingresa el prestamo a modificar
     */
    public void setPrestamo(int pos, Prestamo prestamo){
        listaPrestamo[pos] = prestamo;
    }
}
