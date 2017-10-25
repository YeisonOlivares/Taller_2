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
public class Prestamo {
    
    private String codigo;
    private String idCliente;
    private String libroPedido;
    private Date fechaPrestamo;
    private Date fechaAproxEntrega;
    private Date fechaRealEntrega;
    
    public Prestamo(String codigo, String idCliente, String libroPedido, Date fechaPrestamo, Date fechaAproxEntrega, Date fechaRealEntrega){
        
        this.codigo = codigo;
        this.idCliente = idCliente;
        this.libroPedido = libroPedido;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaAproxEntrega = fechaAproxEntrega;
        this.fechaRealEntrega = fechaRealEntrega;
        
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    
    public String getIdCliente(){
        return this.idCliente;
    }
    
    public String getLibroPedido(){
        return this.libroPedido;
    }
    
    public Date getFechaPrestamo(){
        return this.fechaPrestamo;
    }
    
    public Date getFechaAproxEntrega(){
        return this.fechaAproxEntrega;
    }
    
    public Date getFechaRealEntrega(){
        return this.fechaRealEntrega;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    public void setIdCliente(String idCliente){
        this.idCliente = idCliente;
    }
    
    public void setLibroPedido(String libroPedido){
        this.libroPedido = libroPedido;
    }
    
    public void setFechaPrestamo(Date fechaPrestamo){
        this.fechaPrestamo = fechaPrestamo;
    }
    
    public void setFechaAproxEntrega(Date fechaAproxEntrega){
        this.fechaAproxEntrega = fechaAproxEntrega;
    }
    
    public void setFechaRealEntrega(Date fechaRealEntrega){
        this.fechaRealEntrega = fechaRealEntrega;
    }
    
}
