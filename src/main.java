/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ucn.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Wolf Paradise
 */
public class main {
    
    public static void main(String[] args) throws ParseException{
        int contarClientes = ContarCliente("Textos/Clientes.txt");
        int contarLibros = ContarLibro("Textos/Libros.txt");
        int contarPrestamos = ContarPrestamo("Textos/Prestamos.txt");
        ListaCliente cliente = new ListaCliente(contarClientes * 2);
        ListaLibro libro = new ListaLibro(contarLibros * 2);
        ListaPrestamo prestamo = new ListaPrestamo(contarPrestamos * 2);
        GenerarListaClientes(cliente);
        GenerarListaLibros(libro);
        GenerarListaPrestamos(prestamo);
        StdOut.print(prestamo.getTotalPrestamos());
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

    private static void GenerarListaClientes(ListaCliente cliente) {    
        In archivo = new In("Textos/Clientes.txt");
        String linea = archivo.readLine();
        String registro [] = linea.split(",");
        Cliente C1 = new Cliente(registro[0], registro[1], registro[2], Integer.parseInt(registro[3]), registro[4], null);
        cliente.agregarCliente(C1);
        int aux = 0;
        
        while (!archivo.isEmpty()) {            
            linea = archivo.readLine();                                  
            registro = linea.split(",");
            
            for (int i = 0; i < cliente.getTotalClientes(); i++) {
                if (registro[0].compareTo(cliente.getCliente(i).getRut()) == 0) {
                    break;
                }
                aux++;
            }
            if (aux == cliente.getTotalClientes()) {
                C1 = new Cliente(registro[0], registro[1], registro[2], Integer.parseInt(registro[3]), registro[4], null);
                cliente.agregarCliente(C1);
            }
            aux = 0;
        }
        archivo.close();
    }

    private static void GenerarListaLibros(ListaLibro libro) throws ParseException {
        In archivo = new In("Textos/Libros.txt");
        String linea = archivo.readLine();
        String registro [] = linea.split(",");
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        Date fecha = df.parse(registro[3]);
        Libro L1 = new Libro(Integer.parseInt(registro[0]), registro[1], registro[2], fecha);
        libro.agregarLibro(L1);
        int aux = 0;
        
        while (!archivo.isEmpty()) {            
            linea = archivo.readLine();                                  
            registro = linea.split(",");
            
            for (int i = 0; i < libro.getTotalLibros(); i++) {
                if (Integer.parseInt(registro[0]) == libro.getLibro(i).getIsbn()) {
                    break;
                }
                aux++;
            }
            if (aux == libro.getTotalLibros()) {
                L1 = new Libro(Integer.parseInt(registro[0]), registro[1], registro[2], fecha);
                libro.agregarLibro(L1);
            }
            aux = 0;
        }
        archivo.close();
    }

    private static void GenerarListaPrestamos(ListaPrestamo prestamo) throws ParseException {
        In archivo = new In("Textos/Prestamos.txt");
        String linea = archivo.readLine();
        String registro [] = linea.split(",");
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        Date fechaPedido = df.parse(registro[3]);
        Date fechaEstimada = df.parse(registro[4]);
        Prestamo P1 = new Prestamo(registro[0], registro[1], registro[2], fechaPedido, fechaEstimada, registro[5]);
        prestamo.agregarPrestamo(P1);
        int aux = 0;
        
        while (!archivo.isEmpty()) {            
            linea = archivo.readLine();                                  
            registro = linea.split(",");
            
            for (int i = 0; i < prestamo.getTotalPrestamos(); i++) {
                if (registro[0].compareTo(prestamo.getPrestamo(i).getCodigo()) == 0) {
                    break;
                }
                aux++;
            }
            if (aux == prestamo.getTotalPrestamos()) {
                P1 = new Prestamo(registro[0], registro[1], registro[2], fechaPedido, fechaEstimada, registro[5]);
                prestamo.agregarPrestamo(P1);
            }
            aux = 0;
        }
        archivo.close();
    }
}
