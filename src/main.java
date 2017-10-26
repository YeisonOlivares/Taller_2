/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ucn.*;
/**
 *
 * @author Wolf Paradise
 */
public class main {
    
    public static void main(String[] args){
        int contarClientes = ContarCliente("Textos/Clientes.txt");
        int contarLibros = ContarLibro("Textos/Libros.txt");
        int contarPrestamos = ContarPrestamo("Textos/Prestamos.txt");
        ListaCliente cliente = new ListaCliente(contarClientes * 2);
        ListaLibro libro = new ListaLibro(contarLibros * 2);
        ListaPrestamo prestamo = new ListaPrestamo(contarPrestamos * 2);
        GenerarArreglo(cliente,libro,prestamo);
        SistemaBibliotecaImpl sys = new SistemaBibliotecaImpl(cliente, libro, prestamo);
        
    }

    private static int ContarCliente(String textosClientestxt) {
        int contar = 0;
        In archivo = new In ("Textos/Clientes.txt");                    
        while (!archivo.isEmpty()) {
            String linea = archivo.readLine();
            contar ++;
        }
        archivo.close();
        return contar;
    }

    private static int ContarLibro(String textosLibrostxt) {
        int contar = 0;
        In archivo = new In ("Textos/Libros.txt");                    
        while (!archivo.isEmpty()) {
            String linea = archivo.readLine();
            contar ++;
        }
        archivo.close();
        return contar;
    }

    private static int ContarPrestamo(String textosPrestamostxt) {
        int contar = 0;
        In archivo = new In ("Textos/Prestamos.txt");                    
        while (!archivo.isEmpty()) {
            String linea = archivo.readLine();
            contar ++;
        }
        archivo.close();
        return contar;
    }

    private static void GenerarArreglo(ListaCliente cliente, ListaLibro libro, ListaPrestamo prestamo) {    
        In archivo = new In("Textos/Clientes.txt");
        
        
        
        
    }
    
}
