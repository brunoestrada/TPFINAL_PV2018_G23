package aplicacion.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.PelCla;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import aplicacion.hibernate.dao.IPeliculaClasificacionDAO;

public class PeliculaClasificacionDAOImp implements IPeliculaClasificacionDAO {

    @Override
    public void agregar(PelCla peliculaClas) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.save(peliculaClas);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editar(PelCla peliculaClas) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(peliculaClas);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(PelCla peliculaClas) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(peliculaClas);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<PelCla> listaDePeliculas() {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        Criteria criteria = session.createCriteria(PelCla.class);
        criteria.add(Restrictions.eq("estado", true));
        criteria.addOrder(Order.asc("codigo"));
        List peliculas = criteria.list();
        return peliculas;
    }

}
