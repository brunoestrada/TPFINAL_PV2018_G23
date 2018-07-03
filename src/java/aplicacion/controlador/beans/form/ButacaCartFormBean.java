package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.ButacaCartBean;
import aplicacion.hibernate.dao.imp.ButacaCarteleraDAOImp;
import aplicacion.modelo.dominio.ButacaCartelera;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import aplicacion.hibernate.dao.IButacaCarteleraDAO;

@ManagedBean
@ViewScoped
public class ButacaCartFormBean implements Serializable {

    @ManagedProperty(value = "#{butacaCartBean}")
    private ButacaCartBean butacaCartBean;

    public ButacaCartFormBean() {
        butacaCartBean = new ButacaCartBean();
    }

    public List<ButacaCartelera> cargarButacas() {
        IButacaCarteleraDAO butacaCartelera = new ButacaCarteleraDAOImp();
        return butacaCartelera.obtenerButacasCart();
    }

    public List<ButacaCartelera> cargarButacasDisponibles(String nombreSala) {
        IButacaCarteleraDAO butacaCartelera = new ButacaCarteleraDAOImp();
        return butacaCartelera.obtenerButacasDisponibles(nombreSala);
    }

    public ButacaCartBean getButacaCartBean() {
        return butacaCartBean;
    }

    public void setButacaCartBean(ButacaCartBean butacaCartBean) {
        this.butacaCartBean = butacaCartBean;
    }

}
