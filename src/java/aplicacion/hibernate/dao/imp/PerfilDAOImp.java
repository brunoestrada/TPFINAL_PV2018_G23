package aplicacion.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.hibernate.dao.IPerfilDAO;
import aplicacion.modelo.dominio.Perfil;
import org.hibernate.Session;

public class PerfilDAOImp implements IPerfilDAO {

    @Override
    public void agregar(Perfil perfil) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.save(perfil);
        session.getTransaction().commit();
        session.close();
    }
}
