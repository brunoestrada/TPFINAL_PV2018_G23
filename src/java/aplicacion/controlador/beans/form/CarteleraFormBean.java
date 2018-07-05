package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.CarteleraBean;
import aplicacion.hibernate.dao.ICarteleraDAO;
import aplicacion.hibernate.dao.imp.CarteleraDAOImp;
import aplicacion.modelo.dominio.Cartelera;
import aplicacion.modelo.util.Utilidades;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class CarteleraFormBean implements Serializable {

    @ManagedProperty(value = "#{carteleraBean}")
    private CarteleraBean carteleraBean;
    private List<Cartelera> carteleras;
    private List<Cartelera> filtro;
    private int horario1;
    private int horario2;
    private Date filtroFecha;
    private String fechita;
    private String fechita2;

    public CarteleraFormBean() {
        carteleraBean = new CarteleraBean();
        carteleras = new ArrayList<>();
        filtro = new ArrayList<>();
    }
    
    @PostConstruct
    public void init() {
        llenarCartelera();
    }

    public void llenarCartelera() {
        carteleras = cargarCarteleras();
    }
    
    public void filtroSala1() {
        llenarCartelera();
        filtro.clear();
        for (Cartelera c : carteleras) {
            if (c.getSala().getNombre().equals("Sala 1")) {
                filtro.add(c);
            }
        }
        carteleras.clear();
        carteleras = filtro;
    }

    public void filtroSala2() {
        llenarCartelera();
        filtro.clear();
        for (Cartelera c : carteleras) {
            if (c.getSala().getNombre().equals("Sala 2")) {
                filtro.add(c);
            }
        }
        carteleras.clear();
        carteleras = filtro;
    }

    public void filtroSala3() {
        llenarCartelera();
        filtro.clear();
        for (Cartelera c : carteleras) {
            if (c.getSala().getNombre().equals("Sala 3")) {
                filtro.add(c);
            }
        }
        carteleras.clear();
        carteleras = filtro;
    }

    public void asignarCartelera(Cartelera cartelera) {
        carteleraBean.setCartelera(cartelera);
    }

    public void filtroHorario() {
        llenarCartelera();
        filtro.clear();
        for (Cartelera c : carteleras) {
            if (Integer.parseInt(c.getHorario()) >= horario1 && Integer.parseInt(c.getHorario()) <= horario2) {
                filtro.add(c);
            }
        }
        carteleras.clear();
        carteleras = filtro;

    }

    public void filtroporFecha() throws ParseException {
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy-mm-dd");
        fechita = fecha.format(filtroFecha);
        fechita2 = fecha.format(carteleras.get(0).getFecha());
        llenarCartelera();
        filtro.clear();
        for (Cartelera c : carteleras) {
            if (c.getFecha() == (fecha.parse(fechita))) {
                filtro.add(c);
            }
        }
        carteleras.clear();
        carteleras = filtro;
    }
    
    public void exportarPeliculaPdf(ActionEvent actionEvent) throws JRException, IOException {
        Map<String, Object> parametros = new HashMap<String, Object>();
        //puedo pasar parametros al report, siempre que el diseño lo soporte
        //parametros.put("usuario", "pepito");

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/pelicula.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(this.getCarteleras()));
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentType("application/pdf");
        response.addHeader("Content-disposition", "attachment; filename=reportPeliculas.pdf");
        ServletOutputStream stream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        //exportamos a un archivo en disco
        //JasperExportManager.exportReportToPdfFile(jasperPrint, "e:/reportePrendas.pdf");
        //mostrar en visor jasper
        //JasperViewer.viewReport(jasperPrint,false);
        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void agregar(Cartelera cartelera) {
        try {
            ICarteleraDAO carteleraDAO = new CarteleraDAOImp();
            carteleraBean.getCartelera().getPelicula().setEstado(true);
            carteleraBean.getCartelera().getSala().setEstado(true);
            carteleraBean.getCartelera().setEstado(true);
            carteleraDAO.agregar(carteleraBean.getCartelera());
            Utilidades.generarButacas(carteleraBean.getCartelera());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cartelera Agregada Exitosamente!", "Cartelera Agregada Exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('cargarCartelera').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al agregar cartelera!", "Error al agregar cartelera!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            System.out.println(e);
        }
    }

    public void editar(Cartelera cartelera) {
        try {
            ICarteleraDAO carteleraDAO = new CarteleraDAOImp();
            carteleraDAO.editar(carteleraBean.getCartelera());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cartelera editada exitosamente!", "Cartelera editada exitosamente!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('editarCartelera').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al editar cartelera!", "Error al editar cartelera!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            System.out.println(e);
        }
    }

    public void eliminar(Cartelera cartelera) {
        try {
            ICarteleraDAO carteleraDAO = new CarteleraDAOImp();
            carteleraBean.getCartelera().setEstado(false);
            carteleraDAO.eliminar(carteleraBean.getCartelera());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cartelera eliminada!", "Cartelera eliminada!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().execute("PF('eliminarCartelera').hide()");
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar cartelera!", "Error al eliminar cartelera!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            System.out.println(e);
        }
    }

    public List<Cartelera> cargarCarteleras() {
        ICarteleraDAO carteleraDAO = new CarteleraDAOImp();
        return carteleraDAO.obtenerCarteleras();
    }

    public void establecerCartelera(Cartelera cartelera) {
        carteleraBean.setCartelera(cartelera);
    }

    public void limpiarCampos() {
        carteleraBean = new CarteleraBean();
    }

    public CarteleraBean getCarteleraBean() {
        return carteleraBean;
    }

    public void setCarteleraBean(CarteleraBean carteleraBean) {
        this.carteleraBean = carteleraBean;
    }

    public List<Cartelera> getCarteleras() {
        return carteleras;
    }

    public void setCarteleras(List<Cartelera> carteleras) {
        this.carteleras = carteleras;
    }

    public List<Cartelera> getFiltro() {
        return filtro;
    }

    public void setFiltro(List<Cartelera> filtro) {
        this.filtro = filtro;
    }

    public int getHorario1() {
        return horario1;
    }

    public void setHorario1(int horario1) {
        this.horario1 = horario1;
    }

    public int getHorario2() {
        return horario2;
    }

    public void setHorario2(int horario2) {
        this.horario2 = horario2;
    }

    public Date getFiltroFecha() {
        return filtroFecha;
    }

    public void setFiltroFecha(Date filtroFecha) {
        this.filtroFecha = filtroFecha;
    }

    public String getFechita() {
        return fechita;
    }

    public void setFechita(String fechita) {
        this.fechita = fechita;
    }

    public String getFechita2() {
        return fechita2;
    }

    public void setFechita2(String fechita2) {
        this.fechita2 = fechita2;
    }
    
}
