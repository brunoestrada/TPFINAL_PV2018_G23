package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.PrecioCartelera;
import java.util.List;

public interface IPrecioCartDAO {

    public void agregar(PrecioCartelera precioCartelera);

    public void editar(PrecioCartelera precioCartelera);

    public void eliminar(PrecioCartelera precioCartelera);
    
    public List<PrecioCartelera> obtenerPrecioCarteleras();

}
