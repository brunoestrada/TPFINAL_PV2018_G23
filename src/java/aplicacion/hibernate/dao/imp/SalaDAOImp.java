package aplicacion.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.hibernate.dao.ISalaDAO;
import aplicacion.modelo.dominio.Sala;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class SalaDAOImp implements ISalaDAO, Serializable {

    @Override
    public void agregar(Sala sala) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.save(sala);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editar(Sala sala) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(sala);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Sala sala) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(sala);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Sala> obtenerSalas() {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        Criteria criteria = session.createCriteria(Sala.class);
        criteria.add(Restrictions.eq("estado", true));
        criteria.addOrder(Order.asc("nombre"));
        List salas = criteria.list();
        return salas;
    }

}
