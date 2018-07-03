package aplicacion.controlador.beans;

import aplicacion.modelo.dominio.Clasificacion;
import aplicacion.modelo.dominio.PelCla;
import aplicacion.modelo.dominio.Pelicula;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PeliClasBean implements Serializable {

    private PelCla pelCla;

    public PeliClasBean() {
        pelCla = new PelCla();
        pelCla.setPelicula(new Pelicula());
        pelCla.setClasificacion(new Clasificacion());
    }

    public PelCla getPelCla() {
        return pelCla;
    }

    public void setPelCla(PelCla pelCla) {
        this.pelCla = pelCla;
    }

}
