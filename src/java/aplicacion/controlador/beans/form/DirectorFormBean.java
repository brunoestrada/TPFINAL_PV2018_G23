package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.DirectorBean;
import aplicacion.hibernate.dao.imp.DirectorDAOImp;
import aplicacion.modelo.dominio.Director;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import aplicacion.hibernate.dao.IDirectorDAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class DirectorFormBean implements Serializable{

    @ManagedProperty(value = "#{directorBean}")
    private DirectorBean directorBean;

    public DirectorFormBean() {
        directorBean = new DirectorBean();
    }

    public void agregar(Director director) {
        try {
            IDirectorDAO directorDAO = new DirectorDAOImp();
            directorBean.getDirector().setCodigo(0);
            directorBean.getDirector().setEstado(true);
            directorDAO.agregar(directorBean.getDirector());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Director Agregado Exitosamente!", "Director Agregado Exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('cargarDirector').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al agregar director!", "Error al agregar director!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public void editar(Director director) {
        try {
            IDirectorDAO directorDAO = new DirectorDAOImp();
            directorDAO.editar(directorBean.getDirector());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Director editado exitosamente!", "Director editado exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('editarDirector').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al editar director!", "Error al editar director!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public void eliminar(Director director) {
        try {
            IDirectorDAO directorDAO = new DirectorDAOImp();
            directorBean.getDirector().setEstado(false);
            directorDAO.eliminar(directorBean.getDirector());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Director eliminado exitosamente!", "Director eliminado exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('eliminarDirector').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar director!", "Error al eliminar director!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public List<Director> cargarDirectores() {
        IDirectorDAO directorDAO = new DirectorDAOImp();
        return directorDAO.obtenerDirectores();
    }

    public void establecerDirector(Director director) {
        directorBean.setDirector(director);
    }

    public void limpiarCampos() {
        directorBean = new DirectorBean();
    }

    public DirectorBean getDirectorBean() {
        return directorBean;
    }

    public void setDirectorBean(DirectorBean directorBean) {
        this.directorBean = directorBean;
    }

}
