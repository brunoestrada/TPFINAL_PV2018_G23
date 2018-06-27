package aplicacion.controlador.beans;

import aplicacion.modelo.dominio.Director;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DirectorBean implements Serializable {

    private Director director;

    public DirectorBean() {
        director = new Director();
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

}
