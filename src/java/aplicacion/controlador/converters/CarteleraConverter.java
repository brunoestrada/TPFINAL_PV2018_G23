package aplicacion.controlador.converters;

import aplicacion.hibernate.dao.ICarteleraDAO;
import aplicacion.hibernate.dao.imp.CarteleraDAOImp;
import aplicacion.modelo.dominio.Cartelera;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Cartelera.class, value = "carteleraConverter")
public class CarteleraConverter implements Converter {

    private List<Cartelera> listaCartelera;

    public CarteleraConverter() {
        listaCartelera = new ArrayList<>();
        ICarteleraDAO carteleraDAO = new CarteleraDAOImp();
        listaCartelera = carteleraDAO.obtenerCarteleras();
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            for (Cartelera cartelera : listaCartelera) {
                if (String.valueOf(cartelera.getCodigo()).equals(string)) {
                    return cartelera;
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
            Cartelera cartelera = (Cartelera) o;
            String resultado = String.valueOf(cartelera.getCodigo());
            return resultado;
        } else {
            return "";
        }
    }

}
