package aplicacion.controlador.converters;

import aplicacion.hibernate.dao.IButacaCarteleraDAO;
import aplicacion.hibernate.dao.imp.ButacaCarteleraDAOImp;
import aplicacion.modelo.dominio.ButacaCartelera;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = ButacaCartelera.class, value = "butacaCartConverter")
public class ButacaCartConverter implements Converter{
    
    private List<ButacaCartelera> listaButacas;

    public ButacaCartConverter() {
        listaButacas =  new ArrayList<>();
        IButacaCarteleraDAO butacaCarteleraDAO = new ButacaCarteleraDAOImp();
        listaButacas = butacaCarteleraDAO.obtenerButacasCart();
    }
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            for (ButacaCartelera butacaCart : listaButacas) {
                if (String.valueOf(butacaCart.getCodigo()).equals(string)) {
                    return butacaCart;
                }
            }
        } catch (Exception ex) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != "") {
            ButacaCartelera butaca = (ButacaCartelera) o;
            String resultado = String.valueOf(butaca.getCodigo());
            return resultado;
        } else {
            return "";
        }
    }
    
}
