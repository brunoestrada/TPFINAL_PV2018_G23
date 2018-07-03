package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.Sala;
import java.util.List;

public interface ISalaDAO {

    public void agregar(Sala sala);

    public void editar(Sala sala);

    public void eliminar(Sala sala);

    public List<Sala> obtenerSalas();
}
