package aplicacion.modelo.dominio;

import java.io.Serializable;

public class Clasificacion implements Serializable {

    private Integer codigo;
    private String descripcion;
    private boolean estado;

    public Clasificacion() {
    }

    public Clasificacion(Integer claCodigo, String claDescripcion, boolean claEstado) {
        this.codigo = claCodigo;
        this.descripcion = claDescripcion;
        this.estado = claEstado;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
