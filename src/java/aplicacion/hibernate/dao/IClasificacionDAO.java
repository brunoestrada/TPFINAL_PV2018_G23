package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.Clasificacion;
import java.util.List;

public interface IClasificacionDAO {

    public void agregar(Clasificacion clasificacion);

    public void editar(Clasificacion clasificacion);

    public void eliminar(Clasificacion clasificacion);

    public List<Clasificacion> obtenerClasificaciones();

}
