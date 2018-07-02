package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.Actor;
import java.util.List;

public interface IActorDAO {

    public void agregar(Actor actor);

    public void editar(Actor actor);

    public void eliminar(Actor actor);

    public List<Actor> obtenerActores();
}
