package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.CarteleraBean;
import aplicacion.hibernate.dao.IButacaCarteleraDAO;
import aplicacion.hibernate.dao.ICarteleraDAO;
import aplicacion.hibernate.dao.imp.ButacaCarteleraDAOImp;
import aplicacion.hibernate.dao.imp.CarteleraDAOImp;
import aplicacion.modelo.dominio.ButacaCartelera;
import aplicacion.modelo.dominio.Cartelera;
import aplicacion.modelo.util.Utilidades;
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
public class CarteleraFormBean implements Serializable {

    @ManagedProperty(value = "#{carteleraBean}")
    private CarteleraBean carteleraBean;

    public CarteleraFormBean() {
        carteleraBean = new CarteleraBean();
    }

    public void agregar(Cartelera cartelera) {
        try {
            ICarteleraDAO carteleraDAO = new CarteleraDAOImp();
            carteleraBean.getCartelera().getPelicula().setEstado(true);
            carteleraBean.getCartelera().getSala().setEstado(true);
            carteleraBean.getCartelera().setEstado(true);
            carteleraDAO.agregar(carteleraBean.getCartelera());
            Utilidades.generarButacas(carteleraBean.getCartelera().getSala().getNombre(), carteleraBean.getCartelera());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cartelera Agregada Exitosamente!", "Cartelera Agregada Exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('cargarCartelera').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al agregar cartelera!", "Error al agregar cartelera!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            System.out.println(e);
        }
    }

    public void editar(Cartelera cartelera) {
        try {
            ICarteleraDAO carteleraDAO = new CarteleraDAOImp();
            carteleraDAO.editar(carteleraBean.getCartelera());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cartelera editada exitosamente!", "Cartelera editada exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('editarCartelera').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al editar cartelera!", "Error al editar cartelera!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            System.out.println(e);
        }
    }

    public void eliminar(Cartelera cartelera) {
        try {
            ICarteleraDAO carteleraDAO = new CarteleraDAOImp();
            carteleraBean.getCartelera().setEstado(true);
            carteleraDAO.eliminar(carteleraBean.getCartelera());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cartelera eliminada!", "Cartelera eliminada!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('eliminarCartelera').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar cartelera!", "Error al eliminar cartelera!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            System.out.println(e);
        }
    }

    public List<Cartelera> cargarCarteleras() {
        ICarteleraDAO carteleraDAO = new CarteleraDAOImp();
        return carteleraDAO.obtenerCarteleras();
    }

    public void establecerCartelera(Cartelera cartelera) {
        carteleraBean.setCartelera(cartelera);
    }

    public void limpiarCampos() {
        carteleraBean = new CarteleraBean();
    }

    public CarteleraBean getCarteleraBean() {
        return carteleraBean;
    }

    public void setCarteleraBean(CarteleraBean carteleraBean) {
        this.carteleraBean = carteleraBean;
    }

}
