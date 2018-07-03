package aplicacion.modelo.dominio;

import java.io.Serializable;

public class PelDir implements Serializable {

    private Integer codigo;
    private Director director;
    private Pelicula pelicula;
    private boolean estado;

    public PelDir() {
    }

    public PelDir(Integer pdCodigo, Director directores, Pelicula peliculas, boolean pdEstado) {
        this.codigo = pdCodigo;
        this.director = directores;
        this.pelicula = peliculas;
        this.estado = pdEstado;
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the director
     */
    public Director getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(Director director) {
        this.director = director;
    }

    /**
     * @return the pelicula
     */
    public Pelicula getPelicula() {
        return pelicula;
    }

    /**
     * @param pelicula the pelicula to set
     */
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
