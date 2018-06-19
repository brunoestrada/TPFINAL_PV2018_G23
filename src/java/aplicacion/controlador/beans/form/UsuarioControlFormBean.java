package aplicacion.controlador.beans.form;

import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class UsuarioControlFormBean implements Serializable{

    public UsuarioControlFormBean() {
    }

    public String mostrarNombreUsuario() {
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        return usuario.getNombreUsuario();
    }

    public boolean verificarSesion() {
        boolean sesionValida = false;
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado") != null) {
            sesionValida = true;
        }
        return sesionValida;
    }

    public boolean verificarSesionUF() {
        boolean sesionValida = false;
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        if (usuario.getTipoUsuario().equals("FINAL")) {
            sesionValida = true;
        }
        return sesionValida;
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cerrando Sesión", "Cerrando Sesión");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        String resultado = "/index?faces-redirect=true";
        return resultado;
    }
}
