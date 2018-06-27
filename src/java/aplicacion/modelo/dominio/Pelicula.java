package aplicacion.modelo.dominio;

public class Pelicula {

    private Integer codigo;
    private String nombre;
    private String descripcion;
    private boolean estado;

    public Pelicula() {
    }

    public Pelicula(Integer pelCodigo, String pelNombre, String pelDescripcion, boolean pelEstado) {
        this.codigo = pelCodigo;
        this.nombre = pelNombre;
        this.descripcion = pelDescripcion;
        this.estado = pelEstado;
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
