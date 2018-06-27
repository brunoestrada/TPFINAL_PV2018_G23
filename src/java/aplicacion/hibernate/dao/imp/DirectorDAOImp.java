package aplicacion.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Director;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import aplicacion.hibernate.dao.IDirectorDAO;

public class DirectorDAOImp implements IDirectorDAO {

    @Override
    public void agregar(Director director) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.save(director);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editar(Director director) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(director);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Director director) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(director);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Director> obtenerDirectores() {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        Criteria criteria = session.createCriteria(Director.class);
        criteria.add(Restrictions.eq("estado", true));
        criteria.addOrder(Order.asc("nombre"));
        List directores = criteria.list();
        return directores;
    }

}
