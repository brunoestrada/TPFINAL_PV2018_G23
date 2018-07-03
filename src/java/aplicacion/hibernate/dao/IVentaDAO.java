package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.ButacaCartelera;
import aplicacion.modelo.dominio.VentaEntradas;
import java.util.List;

public interface IVentaDAO {
    
    public void agregar(VentaEntradas entradas);
    
    public void editar(VentaEntradas entradas);
    
    public void eliminar(VentaEntradas entradas);
    
    public void vender(VentaEntradas entradas);
    
    public List<VentaEntradas> obtenerVentas();
    
    public List<ButacaCartelera> obtenerButacasDisponibles();
    
}
