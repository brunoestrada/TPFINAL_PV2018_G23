package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.VentaBean;
import aplicacion.hibernate.dao.IVentaDAO;
import aplicacion.hibernate.dao.imp.VentaDAOImp;
import aplicacion.modelo.dominio.ButacaCartelera;
import aplicacion.modelo.dominio.Cartelera;
import aplicacion.modelo.dominio.VentaEntradas;
import java.io.Serializable;
import java.util.ArrayList;
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
    private List<ButacaCartelera> butacasCartelera;
    private Cartelera cartelera;

    public VentaFormBean() {
        ventaBean = new VentaBean();
        cartelera = new Cartelera();
        butacasCartelera = new ArrayList<>();
    }

    public void realizarVenta(VentaEntradas entradas) {
        try {
            IVentaDAO ventaDAO = new VentaDAOImp();
            ventaBean.getVenta().getButacaCartelera().setEstado(true);
            ventaBean.getVenta().getButacaCartelera().setDisponible(false);
            ventaBean.getVenta().getPerfil().setEstado(true);
            ventaBean.getVenta().setButacaCartelera(ventaBean.getVenta().getButacaCartelera());
            ventaBean.getVenta().setEstado(true);
            ventaDAO.agregar(ventaBean.getVenta());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Venta realizada exitosamente!", "Venta realizada exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            cargarButacasDisponibles();
            RequestContext.getCurrentInstance().execute("PF('ventaButaca').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al realizar la venta!", "Error al realizar la venta!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }
    
    public List<VentaEntradas> cargarVentas() {
        IVentaDAO ventaDAO = new VentaDAOImp();
        return ventaDAO.obtenerVentas();
    }

    public void cargarButacasDisponibles() {
        IVentaDAO ventaDAO = new VentaDAOImp();
        butacasCartelera = ventaDAO.obtenerButacasDisponibles(cartelera);
    }

    public void establecerVenta(VentaEntradas entradas) {
        ventaBean.setVenta(entradas);
    }

    public void establecerButaca(ButacaCartelera butaca) {
        ventaBean.getVenta().setButacaCartelera(butaca);
    }

    public List<ButacaCartelera> devolverButaca() {
        List<ButacaCartelera> lista = new ArrayList();
        lista.add(ventaBean.getVenta().getButacaCartelera());
        return lista;
    }

    public void limpiarCampos() {
        ventaBean = new VentaBean();
    }

    public VentaBean getVentaBean() {
        return ventaBean;
    }

    public void setVentaBean(VentaBean ventaBean) {
        this.ventaBean = ventaBean;
    }

    public List<ButacaCartelera> getButacasCartelera() {
        return butacasCartelera;
    }

    public void setButacasCartelera(List<ButacaCartelera> butacasCartelera) {
        this.butacasCartelera = butacasCartelera;
    }

    public Cartelera getCartelera() {
        return cartelera;
    }

    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
    }

}
