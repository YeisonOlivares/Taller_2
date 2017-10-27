
/**
 * Lista para almacenar los libros registrados
 * @author Yeison Olivares, Rodrigo Dominguez
 */
public class ListaLibro {
    
    private Libro[] ListaLibro;
    private int maxLibro;
    private int cantElementos;
    /**
     * Constructor de la lista
     * @param maxLibro asigna un valor inicial del total de elementos a 0
     */
    public ListaLibro(int maxLibro){
        
        this.maxLibro = maxLibro;
        this.cantElementos = 0;
        this.ListaLibro = new Libro[maxLibro];
   
    }
    /**
     * Metodo para agregar un nuevo libro a la lista
     * @param libro se ingresa una variable de tipo Libro con todos sus atributos
     * @return retorna un boleano verdadero si el libro de agrego con exito, de lo contrario un false
     */
    public boolean agregarLibro(Libro libro){
        
        if(this.cantElementos >= this.maxLibro){
            return false;
        }else{
            this.ListaLibro[cantElementos] = libro;
            cantElementos++;
            return true;
        }   
    }
    /**
     * Metodo para obtener el libro en la posicion ingresada
     * @param pos se ingresa la posicion a consultar en la lista
     * @return retorna el libro en dicha posicion
     */
    public Libro getLibro(int pos){
        return ListaLibro[pos];
    }
    /**
     * Metodo para obtener el total de libros ingresados
     * @return retorna la cantidad de libros ingresados
     */
    public int getTotalLibros(){
        return cantElementos;
    }
}
