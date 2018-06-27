package aplicacion.controlador.beans;

import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

    private Usuario usuario;

    public UsuarioBean() {
//        Usuario usuarioSesion = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
//        if (usuarioSesion != null) {
//            String nombreUsuario = usuarioSesion.getNombreUsuario();
//            IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
//            usuario = usuarioDAO.obtenerUsuario(nombreUsuario);
//        }
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
