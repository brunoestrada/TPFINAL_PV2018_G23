package aplicacion.controlador.beans;

import aplicacion.modelo.dominio.Cartelera;
import aplicacion.modelo.dominio.Pelicula;
import aplicacion.modelo.dominio.Sala;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CarteleraBean implements Serializable {

    private Cartelera cartelera;

    public CarteleraBean() {
        cartelera = new Cartelera();
        cartelera.setPelicula(new Pelicula());
        cartelera.setSala(new Sala());
    }

    public Cartelera getCartelera() {
        return cartelera;
    }

    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
    }

}
