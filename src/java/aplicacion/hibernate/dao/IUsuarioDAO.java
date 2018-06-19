package aplicacion.hibernate.dao;

import aplicacion.modelo.dominio.Usuario;

public interface IUsuarioDAO {

    /**
     * Valida la existencia de un usuario
     *
     * @param nombreUsuario
     * @param password
     * @return null si no existe
     */
    Usuario validarUsuario(String nombreUsuario, String password);

    Usuario obtenerUsuario(String nombreUsuario);

    public void agregar(Usuario usuario);

    public void editar(Usuario usuario);

    public void eliminar(Usuario usuario);

}
