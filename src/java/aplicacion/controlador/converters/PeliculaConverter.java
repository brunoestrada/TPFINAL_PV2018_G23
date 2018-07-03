package aplicacion.controlador.converters;

import aplicacion.hibernate.dao.IPeliculaDirectorDAO;
import aplicacion.hibernate.dao.imp.PeliculaDirectorDAOImp;
import aplicacion.modelo.dominio.Pelicula;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Pelicula.class, value = "peliculaConverter")
public class PeliculaConverter implements Converter {

    private List<Pelicula> listaPeliculas;

    public PeliculaConverter() {
        listaPeliculas = new ArrayList<>();
        IPeliculaDirectorDAO peliculaDirectorDAO = new PeliculaDirectorDAOImp();
        listaPeliculas = peliculaDirectorDAO.peliculas();
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            for (Pelicula pelicula : listaPeliculas) {
                if (String.valueOf(pelicula.getCodigo()).equals(string)) {
                    return pelicula;
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
            Pelicula pelicula = (Pelicula) o;
            String resultado = String.valueOf(pelicula.getCodigo());
            return resultado;
        } else {
            return "";
        }
    }

}