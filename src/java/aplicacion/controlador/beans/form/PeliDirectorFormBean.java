package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.PeliDirectorBean;
import aplicacion.hibernate.dao.IPeliculaDirectorDAO;
import aplicacion.hibernate.dao.imp.PeliculaDirectorDAOImp;
import aplicacion.modelo.dominio.PelDir;
import aplicacion.modelo.dominio.Pelicula;
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
public class PeliDirectorFormBean implements Serializable {

    @ManagedProperty(value = "#{peliDirectorBean}")
    private PeliDirectorBean peliDirectorBean;

    public PeliDirectorFormBean() {
        peliDirectorBean = new PeliDirectorBean();
    }

    public void agregar(PelDir pelDir) {
        try {
            peliDirectorBean.getPeliculaDir().getPelicula().setEstado(true);
            peliDirectorBean.getPeliculaDir().getDirector().setEstado(true);
            peliDirectorBean.getPeliculaDir().setEstado(true);
            IPeliculaDirectorDAO peliculaDirectorDAO = new PeliculaDirectorDAOImp();
            peliculaDirectorDAO.agregar(peliDirectorBean.getPeliculaDir());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Director agregado con exito!", "Director agregado con exito!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('cargarDirector').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al agregar director!", "Error al agregar director!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public void editar(PelDir pelDir) {
        try {
            IPeliculaDirectorDAO peliculaDirectorDAO = new PeliculaDirectorDAOImp();
            peliculaDirectorDAO.editar(peliDirectorBean.getPeliculaDir());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Director editado con exito!", "Director editado con exito!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('editarDirector').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al editar director!", "Error al editar director!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public void eliminar(PelDir pelDir) {
        try {
            peliDirectorBean.getPeliculaDir().setEstado(false);
            IPeliculaDirectorDAO peliculaDirectorDAO = new PeliculaDirectorDAOImp();
            peliculaDirectorDAO.eliminar(peliDirectorBean.getPeliculaDir());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Director eliminado con exito!", "Director eliminado con exito!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('eliminarDirector').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar director!", "Error al eliminar director!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public List<PelDir> cargarDirectores() {
        IPeliculaDirectorDAO peliculaDirectorDAO = new PeliculaDirectorDAOImp();
        return peliculaDirectorDAO.listaDePeliculas();
    }
    
    public List<Pelicula> listarPeliculas() {
        IPeliculaDirectorDAO peliculaDirectorDAO = new PeliculaDirectorDAOImp();
        return peliculaDirectorDAO.peliculas();
    }

    public void establecerDirector(PelDir pelDir) {
        peliDirectorBean.setPeliculaDir(pelDir);
    }

    public void limpiarCampos() {
        peliDirectorBean = new PeliDirectorBean();
    }

    public PeliDirectorBean getPeliDirectorBean() {
        return peliDirectorBean;
    }

    public void setPeliDirectorBean(PeliDirectorBean peliDirectorBean) {
        this.peliDirectorBean = peliDirectorBean;
    }

}
