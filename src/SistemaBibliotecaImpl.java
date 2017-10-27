import ucn.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void menuOpciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
