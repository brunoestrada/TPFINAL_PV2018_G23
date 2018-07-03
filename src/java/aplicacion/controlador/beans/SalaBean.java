package aplicacion.controlador.beans;

import aplicacion.modelo.dominio.Sala;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class SalaBean implements Serializable {

    private Sala sala;

    public SalaBean() {
        sala = new Sala();
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

}
