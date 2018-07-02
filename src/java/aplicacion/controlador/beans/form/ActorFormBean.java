package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.ActorBean;
import aplicacion.hibernate.dao.IActorDAO;
import aplicacion.hibernate.dao.imp.ActorDAOImp;
import aplicacion.modelo.dominio.Actor;
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
public class ActorFormBean implements Serializable {

    @ManagedProperty(value = "#{actorBean}")
    private ActorBean actorBean;

    public ActorFormBean() {
        actorBean = new ActorBean();
    }

    public void agregarActor(Actor actor) {
        try {

            actorBean.getActor().setActCodigo(0);
            actorBean.getActor().setActEstado(true);
            IActorDAO actorDAO = new ActorDAOImp();
            actorDAO.agregar(actorBean.getActor());

            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actor Agregado", "Actor Agregado");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
            RequestContext.getCurrentInstance().execute("PF('cargarActor').hide()");
        } catch (Exception e) {
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Agregar Actor", "Error al Agregar Actor");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }
    }

    public void editarActor(Actor actor) {
        try {
            IActorDAO actorDAO = new ActorDAOImp();
            actorDAO.editar(actorBean.getActor());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actor Editado", "Actor Editado");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('editarActor').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Actor no Editado", "Actor no Editado");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);

        }

    }

    public void eliminarActor(Actor actor) {
        try {
            IActorDAO actorDAO = new ActorDAOImp();
            actorBean.getActor().setActEstado(false);
            actorDAO.eliminar(actorBean.getActor());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actor Eliminado", "Actor Eliminado");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('eliminarActor').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Actor NO Eliminado", "Actor NO Eliminado");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);

        }
    }

    public List<Actor> cargarTabla() {
        IActorDAO actorDAO = new ActorDAOImp();
        return actorDAO.obtenerActores();
    }

    public void establecerActor(Actor actor) {
        actorBean.setActor(actor);
    }

    public void limpiarCampos() {
        actorBean.getActor().setActApellidos("");
        actorBean.getActor().setActNombres("");
    }

    /**
     * @return the actorBean
     */
    public ActorBean getActorBean() {
        return actorBean;
    }

    /**
     * @param actorBean the actorBean to set
     */
    public void setActorBean(ActorBean actorBean) {
        this.actorBean = actorBean;
    }

}
