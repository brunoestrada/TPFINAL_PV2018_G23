package aplicacion.controlador.converters;

import aplicacion.hibernate.dao.ISalaDAO;
import aplicacion.hibernate.dao.imp.SalaDAOImp;
import aplicacion.modelo.dominio.Sala;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Sala.class, value = "salaConverter")
public class SalaConverter implements Converter {

    private List<Sala> listaSalas;

    public SalaConverter() {
        listaSalas = new ArrayList<>();
        ISalaDAO salaDAO = new SalaDAOImp();
        listaSalas = salaDAO.obtenerSalas();
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            for (Sala sala : listaSalas) {
                if (String.valueOf(sala.getCodigo()).equals(string)) {
                    return sala;
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
            Sala sala = (Sala) o;
            String resultado = String.valueOf(sala.getCodigo());
            return resultado;
        } else {
            return "";
        }
    }

}
