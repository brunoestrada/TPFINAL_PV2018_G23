package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.UsuarioBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UsuarioFormBean {

    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;

    public UsuarioFormBean() {
        usuarioBean = new UsuarioBean();
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }
    
}
