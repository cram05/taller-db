package modelo;

import java.util.ArrayList;

/**
 *
 * @author Carlos Ramos
 */
public class DatosUsuario {
    private int idUser;
    private int idSesion;
    private String rol;
    private String ventanaPrincipal;

    public DatosUsuario(int idUser, int idSesion) {
        this.idUser = idUser;
        this.idSesion = idSesion;
    }

    public void addIdUsario(int idUser) {
        this.idUser = idUser;
    }

    public void addIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdSesion() {
        return idSesion;
    }

}
