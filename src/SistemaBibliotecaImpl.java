import ucn.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
    public void desplegarDeuda(String rut) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        int deudaTotal = 0;
        for (int i = 0; i < listaPrestamo.getTotalPrestamos(); i++) {
            if (listaPrestamo.getPrestamo(i).getIdCliente().compareToIgnoreCase(rut) == 0) {
                if (listaPrestamo.getPrestamo(i).getFechaRealEntrega() != "0") {
                    try {
                        Date fechaInicio = listaPrestamo.getPrestamo(i).getFechaAproxEntrega();                     
                        Date fechaTermino = formato.parse(listaPrestamo.getPrestamo(i).getFechaRealEntrega());
                        int diaDiferencia = (int) ((fechaTermino.getTime() - fechaInicio.getTime()) / 86400000);
                        if (diaDiferencia > 0) {
                            StdOut.println("Codigo de prestamo: " + listaPrestamo.getPrestamo(i).getCodigo());
                            StdOut.println("La fecha del prestamo es: " + formato.format(listaPrestamo.getPrestamo(i).getFechaPrestamo()));
                            StdOut.println("La fecha de devolucion estimada es: " + formato.format(listaPrestamo.getPrestamo(i).getFechaAproxEntrega()));
                            StdOut.println("La fecha de devolucion real es: " + listaPrestamo.getPrestamo(i).getFechaRealEntrega());
                            StdOut.println("La diferencia real de la estimada es: " + diaDiferencia);
                            if (diaDiferencia >= 1 && diaDiferencia <= 7) {
                                StdOut.println("la deuda asociada es de $100");
                                deudaTotal += 100;
                            }
                            if (diaDiferencia >= 8 && diaDiferencia <= 14) {
                                StdOut.println("La deuda asociada es de $300");
                                deudaTotal += 300;
                            }
                            if (diaDiferencia >= 15) {
                                StdOut.println("La deuda asociada es de $700");
                                deudaTotal += 700;
                            }
                        }

                        
                    } catch (ParseException ex) {
                        
                    }
                }
            }
        }
        StdOut.println("La deuda total es de: $" + deudaTotal);
    }

    @Override
    public void libroMasSolicitado(Date fecha1, Date fecha2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void generarArchivo() {
        Out arch = new Out ("Textos/Devoluciones_Pendientes.txt");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        //Ordenamiento
        for(int i =0;i<listaPrestamo.getTotalPrestamos() - 2;i++){
            for(int j=i+1;j<listaPrestamo.getTotalPrestamos() - 1; j++){
                
                
                
                Calendar calFecha1 = new GregorianCalendar();
                calFecha1.setTime(listaPrestamo.getPrestamo(i).getFechaAproxEntrega());
                
                Calendar calFecha2 = new GregorianCalendar();
                calFecha2.setTime(listaPrestamo.getPrestamo(j).getFechaAproxEntrega());
                
                if(calFecha2.before(calFecha1)){
                    Prestamo aux1 = listaPrestamo.getPrestamo(i);
                    Prestamo aux2 = listaPrestamo.getPrestamo(j);
                    listaPrestamo.setPrestamo(i, aux2);
                    listaPrestamo.setPrestamo(j, aux1);
                }
            }
        }
        
        //Crear Archivo
        for(int i = 0; i <listaPrestamo.getTotalPrestamos(); i++){
            
            
            
            String rut = listaPrestamo.getPrestamo(i).getIdCliente();
            StdOut.println(rut);
            int pos = listaCliente.getClientePorRut(rut);
            StdOut.println(pos);
            
            
            if (listaPrestamo.getPrestamo(i).getFechaRealEntrega().equals("0") && pos != -1){
                
                Date fechaPrestamo = listaPrestamo.getPrestamo(i).getFechaPrestamo();
                Date fechaAprox = listaPrestamo.getPrestamo(i).getFechaAproxEntrega();
                String fP = formato.format(fechaPrestamo);
                String fA = formato.format(fechaAprox);
                
                
                arch.println(listaPrestamo.getPrestamo(i).getCodigo() + " " + 
                        fP + " " +
                        fA + " " +
                        listaCliente.getCliente(pos).getApellido() + " " + 
                        listaCliente.getCliente(pos).getNombre() + " " + 
                        listaCliente.getCliente(pos).getCelular() + " " + 
                        listaCliente.getCliente(pos).getEmail() + " " + 
                        listaPrestamo.getPrestamo(i).getLibroPedido());
                   
            }
            
        }
        
        for(int i = 0;i<listaPrestamo.getTotalPrestamos();i++){
        StdOut.println(listaPrestamo.getPrestamo(i).getFechaAproxEntrega());
    }
        
        
    }

    @Override
    public void menuOpciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
