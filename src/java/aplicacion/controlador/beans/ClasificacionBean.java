package aplicacion.controlador.beans;

import aplicacion.modelo.dominio.Clasificacion;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ClasificacionBean implements Serializable {

    private Clasificacion clasificacion;

    public ClasificacionBean() {
        clasificacion = new Clasificacion();
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

}
