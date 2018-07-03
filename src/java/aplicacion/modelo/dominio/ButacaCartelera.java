package aplicacion.modelo.dominio;

import java.io.Serializable;
import java.util.Objects;

public class ButacaCartelera implements Serializable {

    private Integer codigo;
    private Cartelera cartelera;
    private String identificadorButaca;
    private boolean disponible;
    private boolean estado;

    public ButacaCartelera() {
    }

    public ButacaCartelera(Integer bcCodigo, Cartelera carteleras, String bcIdentificadorButaca, boolean bcDisponible, boolean bcEstado) {
        this.codigo = bcCodigo;
        this.cartelera = carteleras;
        this.identificadorButaca = bcIdentificadorButaca;
        this.disponible = bcDisponible;
        this.estado = bcEstado;
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
     * @return the identificadorButaca
     */
    public String getIdentificadorButaca() {
        return identificadorButaca;
    }

    /**
     * @param identificadorButaca the identificadorButaca to set
     */
    public void setIdentificadorButaca(String identificadorButaca) {
        this.identificadorButaca = identificadorButaca;
    }

    /**
     * @return the disponible
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
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
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.codigo;
        hash = 61 * hash + Objects.hashCode(this.cartelera);
        hash = 61 * hash + Objects.hashCode(this.identificadorButaca);
        hash = 61 * hash + Objects.hashCode(this.disponible);
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
        final ButacaCartelera other = (ButacaCartelera) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.cartelera, other.cartelera)) {
            return false;
        }
        if (!Objects.equals(this.identificadorButaca, other.identificadorButaca)) {
            return false;
        }
        if (!Objects.equals(this.disponible, other.disponible)) {
            return false;
        }
        return true;
    }
    

}
