package aplicacion.controlador.beans;

import aplicacion.modelo.dominio.ButacaCartelera;
import aplicacion.modelo.dominio.Cartelera;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ButacaCartBean implements Serializable {
    
    private ButacaCartelera butacaCartelera;
    
    public ButacaCartBean() {
        butacaCartelera = new ButacaCartelera();
        butacaCartelera.setCartelera(new Cartelera());
    }
    
    public ButacaCartelera getButacaCartelera() {
        return butacaCartelera;
    }
    
    public void setButacaCartelera(ButacaCartelera butacaCartelera) {
        this.butacaCartelera = butacaCartelera;
    }
    
}
