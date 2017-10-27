
/**
 * Lista para almacenar los clientes registrados
 * @author Yeison Olivares, Rodrigo Dominguez
 * 
 */
public class ListaCliente {
    
    private Cliente ListaCliente [];
    private int maxCliente;
    private int cantElementos;
    
    /**
     * Constructor de la lista
     * @param maxCliente asigna el valor máximo que puede contener la lista
     */
    public ListaCliente(int maxCliente){
        
        this.maxCliente = maxCliente;
        this.cantElementos = 0;
        this.ListaCliente = new Cliente[maxCliente];
    }
    
    /**
     * Agregar un nuevo cliente a la lista
     * @param cliente Se ingresa una variable de tipo Cliente con todos sus atributos
     * @return retorna un boleano verdadero si el cliente se agrego con exito, de lo contrario un false
     */
    public boolean agregarCliente(Cliente cliente){
        
        if (this.cantElementos == this.maxCliente){
            return false;
        }else{
            this.ListaCliente[cantElementos] = cliente;
            cantElementos ++;
            return true;
        }
    }
    /**
     * Busca el cliente ingresando una posicion en la lista
     * @param pos se ingresa la posicion a buscar
     * @return retorna el cliente en la posicion ingresada
     */
    public Cliente getCliente(int pos){
        return ListaCliente[pos];
    }
    /**
     * Busca un cliente especifico ingresando un rut
     * @param rut se ingresa el rut a consultar
     * @return retorna la posición del cliente encontrado sino retorna -1 como indicador que no fue encontrado
     */
    public int getClientePorRut(String rut){
        for(int i = 0; i<cantElementos;i++){
           if(ListaCliente[i].getRut().equals(rut)){
               return i;
           }
        }
        return -1;
    }    
    /**
     * Metodo que devuelve el total de clientes ingresados a la lista (similar a .length)
     * @return Retorna la cantidad de clientes ingresados a la lista
     */
    public int getTotalClientes(){
        return cantElementos;
    }
}
