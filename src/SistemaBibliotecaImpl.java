import ucn.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Implementacion de la interface SistemaBiblioteca
 * @author Yeison Olivares, Rodrigo Dominguez
 * @see SistemaBiblioteca
 */
public class SistemaBibliotecaImpl implements SistemaBiblioteca{
    private ListaCliente listaCliente;
    private ListaLibro listaLibro;
    private ListaPrestamo listaPrestamo;
    /**
     * Constructor del Implements
     * @param listaCliente asigna la lista de clientes
     * @param listaLibro asigna la lista de libros
     * @param listaPrestamo asigna la lista de prestamos
     */
    public SistemaBibliotecaImpl(ListaCliente listaCliente, ListaLibro listaLibro, ListaPrestamo listaPrestamo){
        
        this.listaCliente = listaCliente;
        this.listaLibro = listaLibro;
        this.listaPrestamo = listaPrestamo;
        
    }
    /**
     * Metodo que deacuerdo a un rut ingresado despliega el total de la deuda del cliente
     * @param rut se ingresaa el rut del cliente a consultar deuda
     */
    @Override
    public void desplegarDeuda(String rut) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");      //formato de fecha utilizado
        int deudaTotal = 0;
        
        for (int i = 0; i < listaPrestamo.getTotalPrestamos(); i++) {       //Buscador en la lista prestamo
            if (listaPrestamo.getPrestamo(i).getIdCliente().compareToIgnoreCase(rut) == 0) {    //condicion rut ingresado = rut de la lista
                if (listaPrestamo.getPrestamo(i).getFechaRealEntrega() != "0") {                //condicion si entrego el libro o aun no lo entrega
                    try {
                        Date fechaInicio = listaPrestamo.getPrestamo(i).getFechaAproxEntrega();                     
                        Date fechaTermino = formato.parse(listaPrestamo.getPrestamo(i).getFechaRealEntrega());
                        int diaDiferencia = (int) ((fechaTermino.getTime() - fechaInicio.getTime()) / 86400000);    //calcular la diferencia de fechas
                        if (diaDiferencia > 0) {        //condicion que evalua la cantidad de dias de atraso
                            StdOut.println("Codigo de prestamo: " + listaPrestamo.getPrestamo(i).getCodigo());
                            StdOut.println("La fecha del prestamo es: " + formato.format(listaPrestamo.getPrestamo(i).getFechaPrestamo()));
                            StdOut.println("La fecha de devolucion estimada es: " + formato.format(listaPrestamo.getPrestamo(i).getFechaAproxEntrega()));
                            StdOut.println("La fecha de devolucion real es: " + listaPrestamo.getPrestamo(i).getFechaRealEntrega());
                            StdOut.println("La diferencia real de la estimada es: " + diaDiferencia);
                            if (diaDiferencia >= 1 && diaDiferencia <= 7) { //condicion que verifica los dias de atraso
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
                            StdOut.println("");
                        }
                    } catch (ParseException ex) {
                        
                    }
                }
            }
        }
        if (deudaTotal > 0) {
            StdOut.println("La deuda total es de: $" + deudaTotal);
        }else{
            StdOut.println("El rut ingresado no presenta deudas.");
        }
        
    }
    /**
     * Metodo que muestra el libro mas solicitado en un rango de fechas especifico
     * @param fecha1 se ingresa la fecha inicial del rango
     * @param fecha2 se ingresa la fecha final del rango
     */
    @Override
    public void libroMasSolicitado(String fecha1, String fecha2) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String librosPedidos [][] = new String[listaPrestamo.getTotalPrestamos()][2];
        int aux = 0;
        int aux2 = 0;
        
        for (int i = 0; i < librosPedidos.length; i++) {
            librosPedidos[i][0] = "0";
            librosPedidos[i][1] = "0";
        }
        
        try {
            Date fechaInicio = formato.parse(fecha1);
            Date fechaTermino = formato.parse(fecha2);
            int diferenciaDias = (int) ((fechaTermino.getTime() - fechaInicio.getTime()) / 86400000);
            
            if (diferenciaDias >= 0) {
                for (int i = 0; i < listaPrestamo.getTotalPrestamos(); i++) {
                    int diferenciaIngreso = (int) ((listaPrestamo.getPrestamo(i).getFechaPrestamo().getTime() - fechaInicio.getTime()) / 86400000);
                    if (diferenciaIngreso > 0 && diferenciaIngreso <= diferenciaDias) {
                        for (int j = 0; j < librosPedidos.length; j++) {
                            if (librosPedidos[j][0].compareTo(Integer.toString(listaPrestamo.getPrestamo(i).getLibroPedido())) == 0) {
                                break;
                            }
                            aux++;
                        }
                        if (aux != librosPedidos.length) {
                            int contador = Integer.parseInt(librosPedidos[aux][1]) + 1;
                            librosPedidos[aux][1] = Integer.toString(contador);
                        }
                        if (aux == librosPedidos.length) {
                            librosPedidos[aux2][0] = Integer.toString(listaPrestamo.getPrestamo(i).getLibroPedido());
                            librosPedidos[aux2][1] = "1";
                            aux2 ++;
                        }
                        aux = 0;
                    }
                }
                int max = 0;

                for (int i = 0; i < librosPedidos.length; i++) {
                    if (Integer.parseInt(librosPedidos[i][1]) > max) {
                        max = Integer.parseInt(librosPedidos[i][1]);
                    }
                }
                StdOut.println("=====Los Libros mas solicitados=====");
                for (int i = 0; i < librosPedidos.length; i++) {
                    if (max == Integer.parseInt(librosPedidos[i][1])) {
                        for (int j = 0; j < listaLibro.getTotalLibros(); j++) {
                            if (Integer.parseInt(librosPedidos[i][0]) == listaLibro.getLibro(j).getIsbn()) {
                                StdOut.println("Titulo: " + listaLibro.getLibro(j).getTitulo());
                                StdOut.println("      -ISBN: " + listaLibro.getLibro(j).getIsbn());
                                StdOut.println("      -Autor: " + listaLibro.getLibro(j).getAutor());
                                StdOut.println("      -Año de publicacion: " + formato.format(listaLibro.getLibro(j).getAnnioPublic()));
                                StdOut.println("      -Cantidad de veces Solicitado: " + max);
                                StdOut.println("");
                            }
                        }
                    }
                }
            }
            if (diferenciaDias < 0) {
                StdOut.println("debe ingresar un rango de fechas valido.");
            }
        } catch (Exception e) {
            StdOut.println("la fecha es incorrecta");
        }
    }
    /**
     * Metodo que genera un archivo de devoluciones aun pendientes de entrega
     */
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
            int pos = listaCliente.getClientePorRut(rut);
            
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
    }
    
    /**
     * Metodo que muestra un menu principal para seleccionar una funcionalidad del programa
     */
    @Override
    @SuppressWarnings("fallthrough")
    public void menuOpciones() {
        StdOut.println("######  Sistema Bibloteca UCN  ######");
        StdOut.println("");
        StdOut.println("");
        StdOut.println("Opcion      |       Descripcion");
        StdOut.println("    1       |       Mostrar deuda para un cliente en especifico.");
        StdOut.println("    2       |       Buscar el libro mas solicitado.");
        StdOut.println("    3       |       Generar archivo con devoluciones pendientes.");
        StdOut.println("    9       |       Salir");
        StdOut.println("");
        StdOut.println("");
        StdOut.print("Ingrese su opcion: ");
        String opcionS = StdIn.readString();
        try {
            int opcion = Integer.parseInt(opcionS);
            switch(opcion){
            case 1:
                StdOut.print("Ingrese Rut a consultar: ");
                String rut = StdIn.readString();
                desplegarDeuda(rut);
                StdOut.println("");
                StdOut.print("Desea volver al menu principal? (Si = volver No = salir): ");
                String volver = StdIn.readString();
                if (volver.equalsIgnoreCase("si")) {
                    menuOpciones();
                }else if (volver.equalsIgnoreCase("no")) {
                    System.exit(0);
                }else if (true) {
                    StdOut.println("Opcion no valida. Vuelva a intentarlo");
                    menuOpciones();
                }
                
                
            case 2:
                StdOut.print("Ingrese la fecha inicial a consultar en formato dd/mm/aaaa: ");
                String fecha1 = StdIn.readString();
                StdOut.println("");
                StdOut.print("Ingrese la fecha final a consultar en formato dd/mm/aaaa: ");
                String fecha2 = StdIn.readString();
                libroMasSolicitado(fecha1, fecha2);
                StdOut.println("");
                StdOut.print("Desea volver al menu principal? (Si = volver No = salir): ");
                volver = StdIn.readString();
                if (volver.equalsIgnoreCase("si")) {
                    menuOpciones();
                }else if (volver.equalsIgnoreCase("no")) {
                    System.exit(0);
                }else if (true) {
                    StdOut.println("Opcion no valida. Vuelva a intentarlo");
                    menuOpciones();
                }
            case 3:
                StdOut.println("Generando archivo en la ruta: /Textos/Devoluciones_Pendientes.txt ......");
                generarArchivo();
                StdOut.println("");
                StdOut.println("Archivo Generado con exito!");
                StdOut.println("");
                StdOut.print("Desea volver al menu principal? (Si = volver No = salir): ");
                volver = StdIn.readString();
                if (volver.equalsIgnoreCase("si")) {
                    menuOpciones();
                }else if (volver.equalsIgnoreCase("no")) {
                    System.exit(0);
                }else if (true) {
                    StdOut.println("Opcion no valida. Vuelva a intentarlo");
                    menuOpciones();
                }
            case 9:
                StdOut.println("Formateando C:/*..");
                System.exit(0);
                
            default:
                StdOut.println("Opcion no valida, Reintente");
                menuOpciones();
        }
        } catch (Exception e) {
            StdOut.println("La opcion ingresada no es valida debe ingresar un numero");
            menuOpciones();
        }
        
        
    }   
}
