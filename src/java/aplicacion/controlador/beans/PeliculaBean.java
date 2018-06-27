package aplicacion.controlador.beans;

import aplicacion.modelo.dominio.Pelicula;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PeliculaBean implements Serializable{

    private Pelicula pelicula;

    public PeliculaBean() {
        pelicula = new Pelicula();
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

}
