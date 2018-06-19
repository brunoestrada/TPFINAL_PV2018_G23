package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.Perfil;
import java.util.List;

public interface IPerfilDAO {

    public void agregar(Perfil perfil);
    
    public void editar(Perfil perfil);
    
    public void eliminar(Perfil perfil);
    
    public List<Perfil> obtenerPerfiles();

}
