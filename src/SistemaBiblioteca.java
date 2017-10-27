
/**
 * Interface para implementar los contratos de acuerdo a los requerimientos del taller 2
 * @author Yeison Olivares, Rodrigo Dominguez
 */
public interface SistemaBiblioteca {
    
   void desplegarDeuda(String rut);
   void libroMasSolicitado(String fecha1, String fecha2);
   void generarArchivo();
   void menuOpciones();

}
