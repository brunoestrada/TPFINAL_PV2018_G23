package aplicacion.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.hibernate.dao.ICarteleraDAO;
import aplicacion.modelo.dominio.Cartelera;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CarteleraDAOImp implements ICarteleraDAO, Serializable {

    @Override
    public void agregar(Cartelera cartelera) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.save(cartelera);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editar(Cartelera cartelera) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(cartelera);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Cartelera cartelera) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(cartelera);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Cartelera> obtenerCarteleras() {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        Criteria criteria = session.createCriteria(Cartelera.class);
        criteria.add(Restrictions.eq("estado", true));
        criteria.addOrder(Order.asc("sala"));
        List carteleras = criteria.list();
        return carteleras;
    }

}
