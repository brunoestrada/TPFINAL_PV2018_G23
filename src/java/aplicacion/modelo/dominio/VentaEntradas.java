package aplicacion.modelo.dominio;

import java.io.Serializable;

public class VentaEntradas implements Serializable {

    private Integer codigo;
    private ButacaCartelera butacaCartelera;
    private Perfil perfil;
    private double precio;
    private String descripcion;
    private boolean estado;

    public VentaEntradas() {
    }

    public VentaEntradas(Integer venCodigo, ButacaCartelera butacasCarteleras, Perfil perfiles, double venPrecio, String venDescripcion, boolean venEstado) {
        this.codigo = venCodigo;
        this.butacaCartelera = butacasCarteleras;
        this.perfil = perfiles;
        this.precio = venPrecio;
        this.descripcion = venDescripcion;
        this.estado = venEstado;
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
     * @return the butacaCartelera
     */
    public ButacaCartelera getButacaCartelera() {
        return butacaCartelera;
    }

    /**
     * @param butacaCartelera the butacaCartelera to set
     */
    public void setButacaCartelera(ButacaCartelera butacaCartelera) {
        this.butacaCartelera = butacaCartelera;
    }

    /**
     * @return the perfil
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
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
