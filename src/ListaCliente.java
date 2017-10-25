/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wolf Paradise
 */
public class ListaCliente {
    
    private Cliente[] ListaCliente;
    private int maxCliente;
    private int cantElementos;
    
    public ListaCliente(int maxCliente){
        
        this.maxCliente = maxCliente;
        this.cantElementos = 0;
        this.ListaCliente = new Cliente[maxCliente];
        
    }
    
    public boolean agregarCliente(Cliente cliente){
        
        if (this.cantElementos == this.maxCliente){
            return false;
        }
        else{
            this.ListaCliente[cantElementos] = cliente;
            cantElementos ++;
            return true;
            
        }
        
    }
    
    
    
}
