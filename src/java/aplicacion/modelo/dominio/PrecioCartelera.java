package aplicacion.modelo.dominio;

import java.io.Serializable;
import java.util.Objects;

public class PrecioCartelera implements Serializable {

    private Integer codigo;
    private Cartelera cartelera;
    private String descripcion;
    private double precio;

    public PrecioCartelera() {
    }

    public PrecioCartelera(Integer preCodigo, Cartelera carteleras, String preDescripcion, double prePrecio) {
        this.codigo = preCodigo;
        this.cartelera = carteleras;
        this.descripcion = preDescripcion;
        this.precio = prePrecio;
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
     * @return the cartelera
     */
    public Cartelera getCartelera() {
        return cartelera;
    }

    /**
     * @param cartelera the cartelera to set
     */
    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.codigo;
        hash = 61 * hash + Objects.hashCode(this.descripcion);
        hash = 61 * hash + Objects.hashCode(this.precio);
        hash = 61 * hash + Objects.hashCode(this.cartelera);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PrecioCartelera other = (PrecioCartelera) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.precio, other.precio)) {
            return false;
        }
        if (!Objects.equals(this.cartelera, other.cartelera)) {
            return false;
        }
        return true;
    }

}
