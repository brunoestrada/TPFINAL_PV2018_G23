package aplicacion.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import aplicacion.hibernate.dao.ILoginDAO;

public class LoginDAOImp implements ILoginDAO {

    @Override
    public Usuario validarUsuario(String nombreUsuario, String password) {
        Usuario usuario = null;
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("nombreUsuario", nombreUsuario));
        criteria.add(Restrictions.eq("password", password));
        criteria.add(Restrictions.eq("estado", true));
        if (!criteria.list().isEmpty()) {
            usuario = (Usuario) criteria.list().get(0);
        }
        return usuario;
    }

}
