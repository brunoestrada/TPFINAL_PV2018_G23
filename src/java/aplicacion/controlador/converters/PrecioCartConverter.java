package aplicacion.controlador.converters;

import aplicacion.hibernate.dao.IPrecioCartDAO;
import aplicacion.hibernate.dao.imp.PrecioCartDAOImp;
import aplicacion.modelo.dominio.PrecioCartelera;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = PrecioCartelera.class, value = "precioCartConverter")
public class PrecioCartConverter implements Converter {

    private List<PrecioCartelera> listaPrecios;

    public PrecioCartConverter() {
        listaPrecios = new ArrayList<>();
        IPrecioCartDAO precioCartDAO = new PrecioCartDAOImp();
        listaPrecios = precioCartDAO.obtenerPrecioCarteleras();
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            for (PrecioCartelera pc : listaPrecios) {
                if (String.valueOf(pc.getCodigo()).equals(string)) {
                    return pc;
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
            PrecioCartelera pc = (PrecioCartelera) o;
            String resultado = String.valueOf(pc.getCodigo());
            return resultado;
        } else {
            return "";
        }
    }
}
