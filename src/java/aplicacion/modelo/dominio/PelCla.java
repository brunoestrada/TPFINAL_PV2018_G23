package aplicacion.modelo.dominio;

import java.io.Serializable;


public class PelCla implements Serializable{

    private Integer codigo;
    private Clasificacion clasificacion;
    private Pelicula pelicula;
    private boolean estado;

    public PelCla() {
    }

    public PelCla(Integer pcCodigo, Clasificacion clasificaciones, Pelicula peliculas, boolean pcEstado) {
        this.codigo = pcCodigo;
        this.clasificacion = clasificaciones;
        this.pelicula = peliculas;
        this.estado = pcEstado;
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
     * @return the clasificacion
     */
    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
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
