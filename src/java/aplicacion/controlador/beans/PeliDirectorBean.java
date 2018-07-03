package aplicacion.controlador.beans;

import aplicacion.modelo.dominio.Director;
import aplicacion.modelo.dominio.PelDir;
import aplicacion.modelo.dominio.Pelicula;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PeliDirectorBean implements Serializable {

    private PelDir peliculaDir;

    public PeliDirectorBean() {
        peliculaDir = new PelDir();
        peliculaDir.setPelicula(new Pelicula());
        peliculaDir.setDirector(new Director());
    }

    public PelDir getPeliculaDir() {
        return peliculaDir;
    }

    public void setPeliculaDir(PelDir peliculaDir) {
        this.peliculaDir = peliculaDir;
    }

}
