package aplicacion.modelo.dominio;

import java.io.Serializable;

public class Director implements Serializable {

    private Integer codigo;
    private String apellido;
    private String nombre;
    private boolean estado;

    public Director() {
    }

    public Director(Integer dirCodigo, String dirApellidos, String dirNombres, boolean dirEstado) {
        this.codigo = dirCodigo;
        this.apellido = dirApellidos;
        this.nombre = dirNombres;
        this.estado = dirEstado;
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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
