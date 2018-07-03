package aplicacion.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.ButacaCartelera;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import aplicacion.hibernate.dao.IButacaCarteleraDAO;

public class ButacaCarteleraDAOImp implements IButacaCarteleraDAO {

    @Override
    public void agregar(ButacaCartelera bc) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.save(bc);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editar(ButacaCartelera bc) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(bc);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(ButacaCartelera bc) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(bc);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<ButacaCartelera> obtenerButacasCart() {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        Criteria criteria = session.createCriteria(ButacaCartelera.class);
        criteria.add(Restrictions.eq("estado", true));
        criteria.addOrder(Order.asc("codigo"));
        List butacas = criteria.list();
        return butacas;
    }

    @Override
    public List<ButacaCartelera> obtenerButacasDisponibles(String sala) {
        List<ButacaCartelera> butacas = obtenerButacasCart();
        List listaFiltrada = new ArrayList();
        for (int i = 0; i < butacas.size(); i++) {
            if (butacas.get(i).getCartelera().getSala().getNombre().equals(sala) && butacas.get(i).isDisponible() == true) {
                listaFiltrada.add(butacas.get(i));
            }
        }
        return listaFiltrada;
    }

}
