package aplicacion.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Clasificacion;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import aplicacion.hibernate.dao.IClasificacionDAO;

public class ClasificacionDAOImp implements IClasificacionDAO {

    @Override
    public void agregar(Clasificacion clasificacion) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.save(clasificacion);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editar(Clasificacion clasificacion) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(clasificacion);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Clasificacion clasificacion) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(clasificacion);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Clasificacion> obtenerClasificaciones() {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        Criteria criteria = session.createCriteria(Clasificacion.class);
        criteria.add(Restrictions.eq("estado", true));
        criteria.addOrder(Order.asc("descripcion"));
        List peliculas = criteria.list();
        return peliculas;
    }

}
