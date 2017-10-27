import java.util.Date;
/**
 *Clase Libro
 * @author Yeison Olivares, Rodigo Dominguez
 */
public class Libro {
    
    private int isbn;
    private String titulo;
    private String autor;
    private Date annioPublic;
    
    /**
     * Constructor de la clase Libro
     * @param isbn Asigna el código único que corresponde a cada libro
     * @param titulo Asigna el título a cada libro
     * @param autor Asigna el autor del libro a cada uno
     * @param annioPublic Asigna el año de publicación a cada libro
     */
    public Libro(int isbn, String titulo, String autor, Date annioPublic){
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.annioPublic = annioPublic;
    }
    
    /**
     * Obtener código único
     * @return retorna el código único del libro consultado
     */
    public int getIsbn(){
        return this.isbn;
    }
    
    /**
     * Obtener titulo de libro
     * @return retorna el titulo del libro consultado
     */
    public String getTitulo(){
        return this.titulo;
    }
    /**
     * Obtener el autor del libro
     * @return retorna el autor del libro consultado
     */
    public String getAutor(){
        return this.autor;
    }
    
    /**
     * Obtener el año de publicación
     * @return retorna el año de publicación del libro consultado
     */
    public Date getAnnioPublic(){
        return this.annioPublic;
    }
    
    /**
     * Cambiar código único
     * @param isbn Corresponde al nuevo código que reemplazará al anterior
     */
    public void setIsbn(int isbn){
        this.isbn = isbn;
    }
    /**
     * Cambiar titulo del libro
     * @param titulo Corresponde al nuevo titulo que tendrá el libro
     */
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    /**
     * Cambiar el autor del libro
     * @param autor Corresponde al nombre del nuevo autor del libro
     */
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    /**
     * Cambiar año de publicación
     * @param annioPublic Corresponde al nuevo año de publicación del libro
     */
    public void setAnnioPublic(Date annioPublic){
        this.annioPublic = annioPublic;
    }
    
    
    
}
