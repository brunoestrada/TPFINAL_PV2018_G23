package aplicacion.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.hibernate.dao.IVentaDAO;
import aplicacion.modelo.dominio.ButacaCartelera;
import aplicacion.modelo.dominio.Cartelera;
import aplicacion.modelo.dominio.VentaEntradas;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class VentaDAOImp implements IVentaDAO {

    @Override
    public void agregar(VentaEntradas entradas) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.save(entradas);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editar(VentaEntradas entradas) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(entradas);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(VentaEntradas entradas) {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        session.beginTransaction();
        session.update(entradas);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<VentaEntradas> obtenerVentas() {
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        Criteria criteria = session.createCriteria(VentaEntradas.class);
        criteria.add(Restrictions.eq("estado", true));
        criteria.addOrder(Order.asc("codigo"));
        List butacas = criteria.list();
        return butacas;
    }

    @Override
    public List<ButacaCartelera> obtenerButacasDisponibles(Cartelera cartelera) {
        List<ButacaCartelera> listaFiltrada = new ArrayList<>();
        Session session = HibernateUtil.getSESSION_FACTORY().openSession();
        Criteria criteria = session.createCriteria(ButacaCartelera.class);
        criteria.add(Restrictions.eq("estado", true));
        criteria.add(Restrictions.eq("disponible", true));
        criteria.addOrder(Order.asc("codigo"));
        List <ButacaCartelera> listaButacas = new ArrayList<>();
        listaButacas = criteria.list();
        for (int i = 0; i < listaButacas.size(); i++) {
            if (listaButacas.get(i).getCartelera().getCodigo().equals(cartelera.getCodigo())) {
                listaFiltrada.add(listaButacas.get(i));
            }
        }
        return listaFiltrada;
    }

}
