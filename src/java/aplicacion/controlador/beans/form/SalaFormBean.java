package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.SalaBean;
import aplicacion.hibernate.dao.ISalaDAO;
import aplicacion.hibernate.dao.imp.SalaDAOImp;
import aplicacion.modelo.dominio.Sala;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class SalaFormBean implements Serializable {

    @ManagedProperty(value = "#{salaBean}")
    private SalaBean salaBean;

    public SalaFormBean() {
        salaBean = new SalaBean();
    }

    public void agregar(Sala sala) {
        try {
            ISalaDAO salaDAO = new SalaDAOImp();
            salaBean.getSala().setEstado(true);
            salaDAO.agregar(salaBean.getSala());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sala Agregada Exitosamente!", "Sala Agregada Exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('cargarSala').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al agregar sala!", "Error al agregar sala!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public void editar(Sala sala) {
        try {
            ISalaDAO salaDAO = new SalaDAOImp();
            salaDAO.editar(salaBean.getSala());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sala editada exitosamente!", "Sala editada exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('editarSala').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al editar sala!", "Error al editar sala!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public void eliminar(Sala sala) {
        try {
            ISalaDAO salaDAO = new SalaDAOImp();
            salaBean.getSala().setEstado(false);
            salaDAO.eliminar(salaBean.getSala());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sala eliminada exitosamente!", "Sala eliminada exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('eliminarSala').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar sala!", "Error al eliminar sala!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public List<Sala> cargarSalas() {
        ISalaDAO salaDAO = new SalaDAOImp();
        return salaDAO.obtenerSalas();
    }

    public void establecerSala(Sala sala) {
        salaBean.setSala(sala);
    }

    public void limpiarCampos() {
        salaBean = new SalaBean();
    }

    public SalaBean getSalaBean() {
        return salaBean;
    }

    public void setSalaBean(SalaBean salaBean) {
        this.salaBean = salaBean;
    }

}
