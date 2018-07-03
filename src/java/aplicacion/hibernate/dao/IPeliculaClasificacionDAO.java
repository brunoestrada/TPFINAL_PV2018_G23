package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.PelCla;
import java.util.List;

public interface IPeliculaClasificacionDAO {
    
    public void agregar(PelCla peliculaClas);
    
    public void editar(PelCla peliculaClas);
    
    public void eliminar(PelCla peliculaClas);
    
    public List<PelCla> listaDePeliculas();
    
}
