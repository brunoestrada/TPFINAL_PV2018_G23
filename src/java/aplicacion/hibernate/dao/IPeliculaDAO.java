package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.Pelicula;
import java.util.List;

public interface IPeliculaDAO {

    public void agregar(Pelicula pelicula);

    public void editar(Pelicula pelicula);

    public void eliminar(Pelicula pelicula);

    public List<Pelicula> obtenerPeliculas();
}
