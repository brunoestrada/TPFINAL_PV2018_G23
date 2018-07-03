package aplicacion.modelo.util;

import aplicacion.hibernate.dao.IButacaCarteleraDAO;
import aplicacion.hibernate.dao.IPerfilDAO;
import aplicacion.hibernate.dao.imp.ButacaCarteleraDAOImp;
import aplicacion.hibernate.dao.imp.PerfilDAOImp;
import aplicacion.modelo.dominio.ButacaCartelera;
import aplicacion.modelo.dominio.Cartelera;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

public class Utilidades {

    public static void generarButacas(String sala, Cartelera cartelera) {
        Character letra = 'A';
        if (sala.toLowerCase().equals("sala 1")) {
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= 5; j++) {
                    String letraString = String.valueOf(letra);
                    String ident = letraString + j;
                    ButacaCartelera butacaCartelera = new ButacaCartelera();
                    IButacaCarteleraDAO butacaCarteleraDAO = new ButacaCarteleraDAOImp();
                    butacaCartelera.setCodigo(0);
                    butacaCartelera.setIdentificadorButaca(ident);
                    butacaCartelera.setDisponible(true);
                    butacaCartelera.setEstado(true);
                    butacaCartelera.setCartelera(cartelera);
                    butacaCarteleraDAO.agregar(butacaCartelera);
                }
                letra++;
            }
        }
        if (sala.toLowerCase().equals("sala 2")) {
            for (int i = 0; i < 3; i++) {
                for (int j = 1; j <= 5; j++) {
                    String letraString = String.valueOf(letra);
                    String ident = letraString + j;
                    ButacaCartelera butacaCartelera = new ButacaCartelera();
                    IButacaCarteleraDAO butacaCarteleraDAO = new ButacaCarteleraDAOImp();
                    butacaCartelera.setCodigo(0);
                    butacaCartelera.setIdentificadorButaca(ident);
                    butacaCartelera.setDisponible(true);
                    butacaCartelera.setEstado(true);
                    butacaCartelera.setCartelera(cartelera);
                    butacaCarteleraDAO.agregar(butacaCartelera);
                }
                letra++;
            }
        }
        if (sala.toLowerCase().equals("sala 3")) {
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= 5; j++) {
                    String letraString = String.valueOf(letra);
                    String ident = letraString + j;
                    ButacaCartelera butacaCartelera = new ButacaCartelera();
                    IButacaCarteleraDAO butacaCarteleraDAO = new ButacaCarteleraDAOImp();
                    butacaCartelera.setCodigo(0);
                    butacaCartelera.setIdentificadorButaca(ident);
                    butacaCartelera.setDisponible(true);
                    butacaCartelera.setEstado(true);
                    butacaCartelera.setCartelera(cartelera);
                    butacaCarteleraDAO.agregar(butacaCartelera);
                }
                letra++;
            }
        }
    }

}
