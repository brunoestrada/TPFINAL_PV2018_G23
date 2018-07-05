package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.PeliClasBean;
import aplicacion.hibernate.dao.imp.PeliculaClasificacionDAOImp;
import aplicacion.modelo.dominio.PelCla;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import aplicacion.hibernate.dao.IPeliculaClasificacionDAO;

@ManagedBean
@ViewScoped
public class PeliClasFormBean implements Serializable {

    @ManagedProperty(value = "#{peliClasBean}")
    private PeliClasBean peliClasBean;

    public PeliClasFormBean() {
        peliClasBean = new PeliClasBean();
    }

    public void agregar(PelCla pelCla) {
        try {
            IPeliculaClasificacionDAO peliculaClasDAO = new PeliculaClasificacionDAOImp();
            peliClasBean.getPelCla().getPelicula().setEstado(true);
            peliClasBean.getPelCla().getClasificacion().setEstado(true);
            peliClasBean.getPelCla().setEstado(true);
            peliculaClasDAO.agregar(peliClasBean.getPelCla());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pelicula Agregada Exitosamente!", "Pelicula Agregada Exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('cargarPelicula').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al agregar pelicula!", "Error al agregar pelicula!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public void editar(PelCla pelCla) {
        try {
            IPeliculaClasificacionDAO peliculaClasDAO = new PeliculaClasificacionDAOImp();
            peliculaClasDAO.editar(peliClasBean.getPelCla());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pelicula editada exitosamente!", "Pelicula editada exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('editarPelicula').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al editar pelicula!", "Error al editar pelicula!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public void eliminar(PelCla pelCla) {
        try {
            IPeliculaClasificacionDAO peliculaClasDAO = new PeliculaClasificacionDAOImp();
            peliClasBean.getPelCla().getPelicula().setEstado(false);
            peliClasBean.getPelCla().setEstado(false);
            peliculaClasDAO.eliminar(peliClasBean.getPelCla());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pelicula eliminada!", "Pelicula eliminada!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('eliminarPelicula').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar pelicula!", "Error al eliminar pelicula!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public List<PelCla> cargarPeliculas() {
        IPeliculaClasificacionDAO peliculaClaDAO = new PeliculaClasificacionDAOImp();
        return peliculaClaDAO.listaDePeliculas();
    }

    public void establecerPelicula(PelCla pelCla) {
        peliClasBean.setPelCla(pelCla);
    }

    public void limpiarCampos() {
        peliClasBean = new PeliClasBean();
    }

    public PeliClasBean getPeliClasBean() {
        return peliClasBean;
    }

    public void setPeliClasBean(PeliClasBean peliClasBean) {
        this.peliClasBean = peliClasBean;
    }

}