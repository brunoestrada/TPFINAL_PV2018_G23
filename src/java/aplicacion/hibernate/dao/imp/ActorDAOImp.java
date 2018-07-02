package aplicacion.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.hibernate.dao.IActorDAO;
import aplicacion.modelo.dominio.Actor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class ActorDAOImp implements IActorDAO{

    @Override
    public void agregar(Actor actor) {
        
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.save(actor);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editar(Actor actor) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(actor);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Actor actor) {
       Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(actor);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Actor> obtenerActores() {
        
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        Criteria criteria = session.createCriteria(Actor.class);
        criteria.add(Restrictions.eq("actEstado", true));
        criteria.addOrder(Order.asc("actApellidos"));
        List actores = criteria.list();
        return actores;
    }
    
}
