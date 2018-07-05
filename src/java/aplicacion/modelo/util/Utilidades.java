package aplicacion.modelo.util;

import aplicacion.hibernate.dao.IButacaCarteleraDAO;
import aplicacion.hibernate.dao.imp.ButacaCarteleraDAOImp;
import aplicacion.modelo.dominio.ButacaCartelera;
import aplicacion.modelo.dominio.Cartelera;

public class Utilidades {

    public static void generarButacas(Cartelera cartelera) {
        Character letra = 'A';
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= 10; j++) {
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