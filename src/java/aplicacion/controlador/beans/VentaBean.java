package aplicacion.controlador.beans;

import aplicacion.modelo.dominio.ButacaCartelera;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.VentaEntradas;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class VentaBean implements Serializable {

    private VentaEntradas venta;

    public VentaBean() {
        venta = new VentaEntradas();
        venta.setButacaCartelera(new ButacaCartelera());
        venta.setPerfil(new Perfil());
    }

    public VentaEntradas getVenta() {
        return venta;
    }

    public void setVenta(VentaEntradas venta) {
        this.venta = venta;
    }

}
