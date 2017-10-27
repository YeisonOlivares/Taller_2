/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
/**
 *
 * @author Wolf Paradise
 */
public interface SistemaBiblioteca {
    
   void desplegarDeuda(String rut);
   void libroMasSolicitado(String fecha1, String fecha2);
   void generarArchivo();
   void menuOpciones();
   
   
}
