package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.PeliculaBean;
import aplicacion.modelo.dominio.Pelicula;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import aplicacion.hibernate.dao.IPeliculaDAO;
import aplicacion.hibernate.dao.imp.PeliculaDAOImp;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class PeliculaFormBean implements Serializable{

    private PeliculaBean peliculaBean;

    public PeliculaFormBean() {
        peliculaBean = new PeliculaBean();
    }

    public void agregar(Pelicula pelicula) {
        try {
            IPeliculaDAO peliculaDAO = new PeliculaDAOImp();
            peliculaBean.getPelicula().setCodigo(0);
            peliculaBean.getPelicula().setEstado(true);
            peliculaDAO.agregar(peliculaBean.getPelicula());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pelicula Agregada Exitosamente!", "Pelicula Agregada Exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('cargarPelicula').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al agregar pelicula!", "Error al agregar pelicula!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public void editar(Pelicula pelicula) {
        try {
            IPeliculaDAO peliculaDAO = new PeliculaDAOImp();
            peliculaDAO.editar(peliculaBean.getPelicula());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pelicula editada exitosamente!", "Pelicula editada exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('editarPelicula').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al editar pelicula!", "Error al editar pelicula!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public void eliminar(Pelicula pelicula) {
        try {
            IPeliculaDAO peliculaDAO = new PeliculaDAOImp();
            peliculaBean.getPelicula().setEstado(false);
            peliculaDAO.eliminar(peliculaBean.getPelicula());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pelicula eliminada!", "Pelicula eliminada!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('eliminarPelicula').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar pelicula!", "Error al eliminar pelicula!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public List<Pelicula> cargarPeliculas() {
        IPeliculaDAO peliculaDAO = new PeliculaDAOImp();
        return peliculaDAO.obtenerPeliculas();
    }

    public void establecerPelicula(Pelicula pelicula) {
        peliculaBean.setPelicula(pelicula);
    }
    
    public void limpiarCampos(){
        peliculaBean = new PeliculaBean();
    }
    
    public PeliculaBean getPeliculaBean() {
        return peliculaBean;
    }

    public void setPeliculaBean(PeliculaBean peliculaBean) {
        this.peliculaBean = peliculaBean;
    }

}
