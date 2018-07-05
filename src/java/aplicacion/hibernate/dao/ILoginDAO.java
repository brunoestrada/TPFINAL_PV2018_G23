package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.Usuario;

public interface ILoginDAO {

    /**
     * Valida la existencia de un usuario
     *
     * @param nombreUsuario
     * @param password
     * @return null si no existe
     */
    Usuario validarUsuario(String nombreUsuario, String password);
    
    public void agregarUsuario(Usuario usuario);
}
