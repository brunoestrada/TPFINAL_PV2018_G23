package aplicacion.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.hibernate.dao.IPeliculaDirectorDAO;
import aplicacion.modelo.dominio.PelDir;
import aplicacion.modelo.dominio.Pelicula;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class PeliculaDirectorDAOImp implements IPeliculaDirectorDAO {

    @Override
    public void agregar(PelDir pelDir) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.save(pelDir);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editar(PelDir pelDir) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(pelDir);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(PelDir pelDir) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(pelDir);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<PelDir> listaDePeliculas() {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        Criteria criteria = session.createCriteria(PelDir.class);
        criteria.add(Restrictions.eq("estado", true));
        criteria.addOrder(Order.asc("codigo"));
        List peliculas = criteria.list();
        return peliculas;
    }
    
    @Override
    public List<Pelicula> peliculas() {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        Criteria criteria = session.createCriteria(Pelicula.class);
        criteria.add(Restrictions.eq("estado", true));
        criteria.addOrder(Order.asc("nombre"));
        List peliculas = criteria.list();
        return peliculas;
    }

}
