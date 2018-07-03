package aplicacion.controlador.beans;

import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PerfilBean implements Serializable{

    private Perfil perfil;

    public PerfilBean() {
        perfil = new Perfil();
        perfil.setUsuario(new Usuario());
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

}
