package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.ClasificacionBean;
import aplicacion.hibernate.dao.IClasificacionDAO;
import aplicacion.hibernate.dao.imp.ClasificacionDAOImp;
import aplicacion.modelo.dominio.Clasificacion;
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
public class ClasificacionFormBean implements Serializable {

    @ManagedProperty(value = "#{clasificacionBean}")
    private ClasificacionBean clasificacionBean;

    public ClasificacionFormBean() {
        clasificacionBean = new ClasificacionBean();
    }

    public void agregar(Clasificacion clasificacion) {
        try {
            IClasificacionDAO clasificacionDAO = new ClasificacionDAOImp();
            clasificacionBean.getClasificacion().setCodigo(0);
            clasificacionBean.getClasificacion().setEstado(true);
            clasificacionDAO.agregar(clasificacionBean.getClasificacion());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Clasificacion Agregada Exitosamente!", "Clasificacion Agregada Exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('cargarClasificacion').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al agregar clasificacion!", "Error al agregar clasificacion!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public void editar(Clasificacion clasificacion) {
        try {
            IClasificacionDAO clasificacionDAO = new ClasificacionDAOImp();
            clasificacionDAO.editar(clasificacionBean.getClasificacion());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Clasificacion editada exitosamente!", "Clasificacion editada exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('editarClasificacion').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al editar clasificacion!", "Error al editar clasificacion!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public void eliminar(Clasificacion clasificacion) {
        try {
            IClasificacionDAO clasificacionDAO = new ClasificacionDAOImp();
            clasificacionBean.getClasificacion().setEstado(false);
            clasificacionDAO.eliminar(clasificacionBean.getClasificacion());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Clasificacion eliminada exitosamente!", "Clasificacion eliminada exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('eliminarClasificacion').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar clasificacion!", "Error al eliminar clasificacion!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public List<Clasificacion> cargarClasificaciones() {
        IClasificacionDAO clasificacionDAO = new ClasificacionDAOImp();
        return clasificacionDAO.obtenerClasificaciones();
    }

    public void establecerClasificacion(Clasificacion clasificacion) {
        clasificacionBean.setClasificacion(clasificacion);
    }

    public void limpiarCampos() {
        clasificacionBean = new ClasificacionBean();
    }

    public ClasificacionBean getClasificacionBean() {
        return clasificacionBean;
    }

    public void setClasificacionBean(ClasificacionBean clasificacionBean) {
        this.clasificacionBean = clasificacionBean;
    }

}
