package aplicacion.controlador.converters;

import aplicacion.hibernate.dao.IClasificacionDAO;
import aplicacion.hibernate.dao.imp.ClasificacionDAOImp;
import aplicacion.modelo.dominio.Clasificacion;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Clasificacion.class, value = "clasificacionConverter")
public class ClasificacionConverter implements Converter {
    
    private List<Clasificacion> listaClasificaciones;

    public ClasificacionConverter() {
        listaClasificaciones = new ArrayList<>();
        IClasificacionDAO clasificacionDAO = new ClasificacionDAOImp();
        listaClasificaciones = clasificacionDAO.obtenerClasificaciones();
    }
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            for (Clasificacion clasificacion : listaClasificaciones) {
                if (String.valueOf(clasificacion.getCodigo()).equals(string)) {
                    return clasificacion;
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
            Clasificacion clasificacion = (Clasificacion) o;
            String resultado = String.valueOf(clasificacion.getCodigo());
            return resultado;
        } else {
            return "";
        }
    }

}
