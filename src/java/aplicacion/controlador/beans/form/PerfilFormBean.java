package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.PerfilBean;
import aplicacion.controlador.beans.UsuarioBean;
import aplicacion.hibernate.dao.IPerfilDAO;
import aplicacion.hibernate.dao.IUsuarioDAO;
import aplicacion.hibernate.dao.imp.PerfilDAOImp;
import aplicacion.hibernate.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class PerfilFormBean implements Serializable {

    @ManagedProperty(value = "#{perfilBean}")
    private PerfilBean perfilBean;
    private UsuarioBean usuarioBean;

    public PerfilFormBean() {
        perfilBean = new PerfilBean();
        usuarioBean = new UsuarioBean();
    }

    public void agregarPerfil(Perfil perfil) {
        try {
            usuarioBean.getUsuario().setCodigo(0);
            usuarioBean.getUsuario().setEstado(true);
            usuarioBean.getUsuario().setTipoUsuario("FINAL");
            IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
            usuarioDAO.agregar(usuarioBean.getUsuario());
            perfilBean.getPerfil().setCodigo(0);
            perfilBean.getPerfil().setEstado(true);
            perfilBean.getPerfil().setUsuario(usuarioBean.getUsuario());
            IPerfilDAO perfilDAO = new PerfilDAOImp();
            perfilDAO.agregar(perfilBean.getPerfil());
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Agregado", "Usuario Agregado");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
            RequestContext.getCurrentInstance().execute("PF('cargarPerfilUsuario').hide()");
        } catch (Exception e) {
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario existente", "Usuario existente");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }
    }
    
    public void agregarPerfilInicial(Perfil perfil) {
        try {
            usuarioBean.getUsuario().setCodigo(0);
            usuarioBean.getUsuario().setEstado(true);
            usuarioBean.getUsuario().setTipoUsuario("FINAL");
            IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
            usuarioDAO.agregar(usuarioBean.getUsuario());
            perfilBean.getPerfil().setCodigo(0);
            perfilBean.getPerfil().setEstado(true);
            perfilBean.getPerfil().setUsuario(usuarioBean.getUsuario());
            IPerfilDAO perfilDAO = new PerfilDAOImp();
            perfilDAO.agregar(perfilBean.getPerfil());
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cuenta creada con exito!", "Cuenta creada con exito!");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
            RequestContext.getCurrentInstance().execute("PF('crearCuenta').hide()");
        } catch (Exception e) {
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear la cuenta", "Error al crear la cuenta");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }
    }
    
    public void editarPerfil(Perfil perfil) {
        try {
            IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
            IPerfilDAO perfilDAO = new PerfilDAOImp();
            usuarioDAO.editar(usuarioBean.getUsuario());
            perfilDAO.editar(perfilBean.getPerfil());
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil Editado", "Perfil Editado");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
            RequestContext.getCurrentInstance().execute("PF('editarPerfilUsuario').hide()");
        } catch (Exception e) {
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Perfil No Editado", "Perfil No Editado");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }
    }
    
    public void eliminarPerfil(Perfil perfil){
        try {
            IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
            IPerfilDAO perfilDAO = new PerfilDAOImp();
            perfilBean.getPerfil().setEstado(false);
            perfilDAO.eliminar(perfilBean.getPerfil());
            usuarioBean.getUsuario().setEstado(false);
            usuarioDAO.eliminar(usuarioBean.getUsuario());
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil Eliminado", "Perfil Eliminado");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
            RequestContext.getCurrentInstance().execute("PF('eliminarPerfilUsuario').hide()");
        } catch (Exception e) {
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Perfil No Eliminado", "Perfil No Eliminado");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }
    }

    public List<Perfil> cargarTabla() {
        IPerfilDAO perfilDAO = new PerfilDAOImp();
        return perfilDAO.obtenerPerfiles();
    }

    public void establecerPerfil(Perfil perfil, Usuario usuario) {
        usuarioBean.setUsuario(usuario);
        perfilBean.setPerfil(perfil);
    }

    public void limpiarCampos() {
        usuarioBean.setUsuario(new Usuario());
        usuarioBean.getUsuario().setNombreUsuario("");
        usuarioBean.getUsuario().setPassword("");
        perfilBean.setPerfil(new Perfil());
        perfilBean.getPerfil().setApellido("");
        perfilBean.getPerfil().setNombre("");
        perfilBean.getPerfil().setDni("");
        perfilBean.getPerfil().setDireccion("");
        perfilBean.getPerfil().setEmail("");
        perfilBean.getPerfil().setFechaNac(null);
    }
    
    public Date getFechaActual() {
        return new Date(System.currentTimeMillis());
    }

    public PerfilBean getPerfilBean() {
        return perfilBean;
    }

    public void setPerfilBean(PerfilBean perfilBean) {
        this.perfilBean = perfilBean;
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

}
