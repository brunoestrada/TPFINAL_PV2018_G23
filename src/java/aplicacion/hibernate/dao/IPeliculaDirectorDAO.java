package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.PelDir;
import aplicacion.modelo.dominio.Pelicula;
import java.util.List;

public interface IPeliculaDirectorDAO {
    
    public void agregar(PelDir pelDir);
    
    public void editar(PelDir pelDir);
    
    public void eliminar(PelDir pelDir);
    
    public List<PelDir> listaDePeliculas();
    
    public List<Pelicula> peliculas();
    
}
