package aplicacion.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.hibernate.dao.IPrecioCartDAO;
import aplicacion.modelo.dominio.PrecioCartelera;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class PrecioCartDAOImp implements IPrecioCartDAO {

    @Override
    public void agregar(PrecioCartelera precioCartelera) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.save(precioCartelera);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editar(PrecioCartelera precioCartelera) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(precioCartelera);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(PrecioCartelera precioCartelera) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(precioCartelera);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<PrecioCartelera> obtenerPrecioCarteleras() {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        Criteria criteria = session.createCriteria(PrecioCartelera.class);
        criteria.addOrder(Order.asc("codigo"));
        List precios = criteria.list();
        return precios;
    }

}
