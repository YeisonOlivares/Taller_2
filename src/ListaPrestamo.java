/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wolf Paradise
 */
public class ListaPrestamo {
    
    private Prestamo[] listaPrestamo;
    private int maxPrestamo;
    private int cantElementos;
    
    public ListaPrestamo(int maxPrestamo){
        
        this.maxPrestamo = maxPrestamo;
        this.cantElementos = 0;
        this.listaPrestamo = new Prestamo[maxPrestamo];
        
    }
    
    public boolean agregarPrestamo(Prestamo prestamo){
        
        if(this.cantElementos >= this.maxPrestamo){
            return false;
        }
        
        else{
            
            this.listaPrestamo[cantElementos] = prestamo;
            cantElementos++;
            return true;
            
        }
    }
    
    public Prestamo getPrestamo(int pos){
        return listaPrestamo[pos];
    }
    
    public int getTotalPrestamos(){
        return cantElementos;
    }
}
