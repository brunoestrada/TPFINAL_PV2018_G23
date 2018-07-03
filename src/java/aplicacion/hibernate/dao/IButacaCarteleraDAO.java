package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.ButacaCartelera;
import java.util.List;

public interface IButacaCarteleraDAO {

    public void agregar(ButacaCartelera bc);

    public void editar(ButacaCartelera bc);

    public void eliminar(ButacaCartelera bc);

    public List<ButacaCartelera> obtenerButacasCart();
    
    public List<ButacaCartelera> obtenerButacasDisponibles(String sala);

}
