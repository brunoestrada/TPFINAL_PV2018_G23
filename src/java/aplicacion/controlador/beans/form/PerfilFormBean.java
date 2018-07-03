package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.PerfilBean;
import aplicacion.hibernate.dao.IPerfilDAO;
import aplicacion.hibernate.dao.imp.PerfilDAOImp;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
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

    public PerfilFormBean() {
        perfilBean = new PerfilBean();
    }

    public void agregarPerfil(Perfil perfil) {
        try {
            perfilBean.getPerfil().getUsuario().setTipoUsuario("FINAL");
            perfilBean.getPerfil().getUsuario().setEstado(true);
            perfilBean.getPerfil().setEstado(true);
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
            perfilBean.getPerfil().getUsuario().setTipoUsuario("FINAL");
            perfilBean.getPerfil().getUsuario().setEstado(true);
            perfilBean.getPerfil().setEstado(true);
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
            IPerfilDAO perfilDAO = new PerfilDAOImp();
            perfilDAO.editar(perfilBean.getPerfil());
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil Editado", "Perfil Editado");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
            RequestContext.getCurrentInstance().execute("PF('editarPerfilUsuario').hide()");
        } catch (Exception e) {
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Perfil No Editado", "Perfil No Editado");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }
    }

    public void eliminarPerfil(Perfil perfil) {
        try {
            IPerfilDAO perfilDAO = new PerfilDAOImp();
            perfilBean.getPerfil().getUsuario().setEstado(false);
            perfilBean.getPerfil().setEstado(false);
            perfilDAO.eliminar(perfilBean.getPerfil());
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil Eliminado", "Perfil Eliminado");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
            RequestContext.getCurrentInstance().execute("PF('eliminarPerfilUsuario').hide()");
        } catch (Exception e) {
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Perfil No Eliminado", "Perfil No Eliminado");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }
    }
    
    public List<Perfil> obtenerPerfil(){
        List<Perfil> listaFiltrada = new ArrayList<>();
        List<Perfil> lista = new ArrayList<>();
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        IPerfilDAO perfilDAO = new PerfilDAOImp();
        lista = perfilDAO.obtenerPerfiles();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getUsuario().getNombreUsuario().equals(usuario.getNombreUsuario())) {
                listaFiltrada.add(lista.get(i));
            }
        }
        return listaFiltrada;
    }
    
    public List<Perfil> cargarTabla() {
        IPerfilDAO perfilDAO = new PerfilDAOImp();
        return perfilDAO.obtenerPerfiles();
    }

    public void establecerPerfil(Perfil perfil) {
        perfilBean.setPerfil(perfil);
    }

    public void limpiarCampos() {
        perfilBean.setPerfil(new Perfil());
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

}
