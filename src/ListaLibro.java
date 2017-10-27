/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wolf Paradise
 */
public class ListaLibro {
    
    private Libro[] ListaLibro;
    private int maxLibro;
    private int cantElementos;
    
    public ListaLibro(int maxLibro){
        
        this.maxLibro = maxLibro;
        this.cantElementos = 0;
        this.ListaLibro = new Libro[maxLibro];
        
    }
    
    public boolean agregarLibro(Libro libro){
        
        if(this.cantElementos >= this.maxLibro){
            return false;
        }
        
        else{
            this.ListaLibro[cantElementos] = libro;
            cantElementos++;
            return true;
        }   
    }
    
    public Libro getLibro(int pos){
        return ListaLibro[pos];
    }
    
    public int getTotalLibros(){
        return cantElementos;
    }
}
