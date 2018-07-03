package aplicacion.controlador.converters;

import aplicacion.hibernate.dao.IPerfilDAO;
import aplicacion.hibernate.dao.imp.PerfilDAOImp;
import aplicacion.modelo.dominio.Perfil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Perfil.class, value = "perfilConverter")
public class PerfilConverter implements Converter {

    private List<Perfil> listaPerfiles;

    public PerfilConverter() {
        listaPerfiles = new ArrayList<>();
        IPerfilDAO perfilDAO = new PerfilDAOImp();
        listaPerfiles = perfilDAO.obtenerPerfiles();
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            for (Perfil perfil : listaPerfiles) {
                if (String.valueOf(perfil.getCodigo()).equals(string)) {
                    return perfil;
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
            Perfil perfil = (Perfil) o;
            String resultado = String.valueOf(perfil.getCodigo());
            return resultado;
        } else {
            return "";
        }
    }

}
