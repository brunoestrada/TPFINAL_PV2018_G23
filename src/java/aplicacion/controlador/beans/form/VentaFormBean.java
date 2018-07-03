package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.PeliClasBean;
import aplicacion.controlador.beans.VentaBean;
import aplicacion.hibernate.dao.IPeliculaClasificacionDAO;
import aplicacion.hibernate.dao.IVentaDAO;
import aplicacion.hibernate.dao.imp.PeliculaClasificacionDAOImp;
import aplicacion.hibernate.dao.imp.VentaDAOImp;
import aplicacion.modelo.dominio.ButacaCartelera;
import aplicacion.modelo.dominio.PelCla;
import aplicacion.modelo.dominio.VentaEntradas;
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
public class VentaFormBean implements Serializable {

    @ManagedProperty(value = "#{ventaBean}")
    private VentaBean ventaBean;

    public void realizarVenta(VentaEntradas entradas) {
        IVentaDAO ventaDAO = new VentaDAOImp();
            ventaBean.getVenta().getButacaCartelera().setEstado(true);
            ventaBean.getVenta().getButacaCartelera().setDisponible(false);
            ventaBean.getVenta().getPerfil().setEstado(true);
            ventaBean.getVenta().setEstado(true);
            ventaDAO.agregar(ventaBean.getVenta());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Venta realizada exitosamente!", "Venta realizada exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('cargarVenta').hide()");
    }

    public List<VentaEntradas> cargarVentas() {
        IVentaDAO ventaDAO = new VentaDAOImp();
        return ventaDAO.obtenerVentas();
    }

    public List<ButacaCartelera> cargarButacas() {
        IVentaDAO ventaDAO = new VentaDAOImp();
        return ventaDAO.obtenerButacasDisponibles();
    }

    public void establecerPelicula(VentaEntradas entradas) {
        ventaBean.setVenta(entradas);
    }

    public void limpiarCampos() {
        ventaBean = new VentaBean();
    }

    public VentaFormBean() {
        ventaBean = new VentaBean();
    }

    public VentaBean getVentaBean() {
        return ventaBean;
    }

    public void setVentaBean(VentaBean ventaBean) {
        this.ventaBean = ventaBean;
    }

}
