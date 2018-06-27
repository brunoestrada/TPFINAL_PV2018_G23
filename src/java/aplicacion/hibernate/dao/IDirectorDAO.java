package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.Director;
import java.util.List;

public interface IDirectorDAO {

    public void agregar(Director director);

    public void editar(Director director);

    public void eliminar(Director director);

    public List<Director> obtenerDirectores();

}
