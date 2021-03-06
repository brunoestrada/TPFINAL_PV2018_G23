package aplicacion.controlador.beans.form;

import aplicacion.hibernate.dao.imp.LoginDAOImp;
import aplicacion.modelo.dominio.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import aplicacion.hibernate.dao.ILoginDAO;

@ManagedBean
@RequestScoped
public class LoginFormBean {

    private String nombreUsuario;
    private String password;

    public LoginFormBean() {
    }

    public String validarUsuario() {
        String resultado = null;
        ILoginDAO usuarioDAO = new LoginDAOImp();
        Usuario usuario = usuarioDAO.validarUsuario(nombreUsuario, password);
        if (usuario != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValidado", usuario);
            resultado = "/menu/menu?faces-redirect=true";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", "Bienvenido");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        } else {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario Invalido", "Usuario Invalido");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        return resultado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
