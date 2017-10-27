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
public class Libro {
    
    private int isbn;
    private String titulo;
    private String autor;
    private Date annioPublic;
    
    public Libro(int isbn, String titulo, String autor, Date annioPublic){
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.annioPublic = annioPublic;
    }
    
    public int getIsbn(){
        return isbn;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getAutor(){
        return autor;
    }
    
    public Date getAnnioPublic(){
        return annioPublic;
    }
    
    public void setIsbn(int isbn){
        this.isbn = isbn;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public void setAnnioPublic(Date annioPublic){
        this.annioPublic = annioPublic;
    }
    
    
    
}
