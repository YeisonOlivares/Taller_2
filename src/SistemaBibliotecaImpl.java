/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wolf Paradise
 */
public class SistemaBibliotecaImpl implements SistemaBiblioteca{
    private ListaCliente listaCliente;
    private ListaLibro listaLibro;
    private ListaPrestamo listaPrestamo;
    
    public SistemaBibliotecaImpl(ListaCliente listaCliente, ListaLibro listaLibro, ListaPrestamo listaPrestamo){
        
        this.listaCliente = listaCliente;
        this.listaLibro = listaLibro;
        this.listaPrestamo = listaPrestamo;
        
    }
    
    @Override
    public void desplegarDeuda(String rut){
        
        
        
}
    
}
