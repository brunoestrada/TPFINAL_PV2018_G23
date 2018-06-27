package aplicacion.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Pelicula;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import aplicacion.hibernate.dao.IPeliculaDAO;

public class PeliculaDAOImp implements IPeliculaDAO {

    @Override
    public void agregar(Pelicula pelicula) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.save(pelicula);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editar(Pelicula pelicula) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(pelicula);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Pelicula pelicula) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(pelicula);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Pelicula> obtenerPeliculas() {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        Criteria criteria = session.createCriteria(Pelicula.class);
        criteria.add(Restrictions.eq("estado", true));
        criteria.addOrder(Order.asc("nombre"));
        List peliculas = criteria.list();
        return peliculas;
    }

}
