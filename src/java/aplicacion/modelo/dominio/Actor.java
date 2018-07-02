
package aplicacion.modelo.dominio;

import java.io.Serializable;

public class Actor implements Serializable {

    private Integer actCodigo;
    private String actApellidos;
    private String actNombres;
    private boolean actEstado;

    public Actor() {
    }

    public Actor(Integer actCodigo, String actApellidos, String actNombres, boolean actEstado) {
        this.actCodigo = actCodigo;
        this.actApellidos = actApellidos;
        this.actNombres = actNombres;
        this.actEstado = actEstado;
    }

    /**
     * @return the actCodigo
     */
    public Integer getActCodigo() {
        return actCodigo;
    }

    /**
     * @param actCodigo the actCodigo to set
     */
    public void setActCodigo(Integer actCodigo) {
        this.actCodigo = actCodigo;
    }

    /**
     * @return the actApellidos
     */
    public String getActApellidos() {
        return actApellidos;
    }

    /**
     * @param actApellidos the actApellidos to set
     */
    public void setActApellidos(String actApellidos) {
        this.actApellidos = actApellidos;
    }

    /**
     * @return the actNombres
     */
    public String getActNombres() {
        return actNombres;
    }

    /**
     * @param actNombres the actNombres to set
     */
    public void setActNombres(String actNombres) {
        this.actNombres = actNombres;
    }

    /**
     * @return the actEstado
     */
    public boolean isActEstado() {
        return actEstado;
    }

    /**
     * @param actEstado the actEstado to set
     */
    public void setActEstado(boolean actEstado) {
        this.actEstado = actEstado;
    }
    
}
