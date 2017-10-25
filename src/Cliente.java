/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wolf Paradise
 */
public class Cliente {
    
    private String rut;
    private String nombre;
    private String apellido;
    private int celular;
    private String email;
    private ListaPrestamo listaPrestamo;
    
    public Cliente(String rut, String nombre, String apellido, int celular, String email, ListaPrestamo listaPrestamo){
    this.rut = rut;
    this.nombre = nombre;
    this.apellido = apellido;
    this.celular = celular;
    this.email = email;
    this.listaPrestamo = null;
    
    }
    
    public String getRut(){
        return this.rut;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getApellido(){
        return this.apellido;
    }
    
    public int getCelular(){
        return this.celular;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public ListaPrestamo getlistaPrestamo(){
        return this.listaPrestamo;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    
}
