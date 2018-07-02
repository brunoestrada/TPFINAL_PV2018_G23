
package aplicacion.modelo.dominio;

import java.io.Serializable;


public class PelAct implements Serializable {
    private Integer pcCodigo;
    private Director directores;
    private Pelicula peliculas;
    private boolean pcEstado;

    public PelAct() {
    }

    public PelAct(Integer pcCodigo, Director directores, Pelicula peliculas, boolean pcEstado) {
        this.pcCodigo = pcCodigo;
        this.directores = directores;
        this.peliculas = peliculas;
        this.pcEstado = pcEstado;
    }

    /**
     * @return the pcCodigo
     */
    public Integer getPcCodigo() {
        return pcCodigo;
    }

    /**
     * @param pcCodigo the pcCodigo to set
     */
    public void setPcCodigo(Integer pcCodigo) {
        this.pcCodigo = pcCodigo;
    }

    /**
     * @return the directores
     */
    public Director getDirectores() {
        return directores;
    }

    /**
     * @param directores the directores to set
     */
    public void setDirectores(Director directores) {
        this.directores = directores;
    }

    /**
     * @return the peliculas
     */
    public Pelicula getPeliculas() {
        return peliculas;
    }

    /**
     * @param peliculas the peliculas to set
     */
    public void setPeliculas(Pelicula peliculas) {
        this.peliculas = peliculas;
    }

    /**
     * @return the pcEstado
     */
    public boolean isPcEstado() {
        return pcEstado;
    }

    /**
     * @param pcEstado the pcEstado to set
     */
    public void setPcEstado(boolean pcEstado) {
        this.pcEstado = pcEstado;
    }
    
}
