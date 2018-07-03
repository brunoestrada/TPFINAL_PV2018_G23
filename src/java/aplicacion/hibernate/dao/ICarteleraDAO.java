package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.Cartelera;
import java.util.List;

public interface ICarteleraDAO {

    public void agregar(Cartelera cartelera);

    public void editar(Cartelera cartelera);

    public void eliminar(Cartelera cartelera);

    public List<Cartelera> obtenerCarteleras();

}
