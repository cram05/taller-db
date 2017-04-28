
package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Ramos
 */
public class ModeloUsuario {
    private DatosUsuario datosUser;
    public ModeloUsuario() {
        datosUser = null;
    }
    
    public DatosUsuario buscarUsuario(String user, String pass) {
        try {
            int idUser = ConsultasSQL.obtenerIdUsuario(user, pass);
            if(idUser > 0){//existe usuario
                ConsultasSQL.activarUsuario(idUser);//activo=true
                int idSesion = ConsultasSQL.crearSesion(idUser);
                datosUser = new DatosUsuario(idUser, idSesion);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la Base de Datos");
        }
        return datosUser;
    }

    public ArrayList<String> obtenerIUs(DatosUsuario usuario) {
        return ConsultasSQL.obtenerIUs(usuario.getIdUser());
    }

    public DatosUsuario getDatosUser() {
        return datosUser;
    }

    public void cerrarSesion() {
        ConsultasSQL.desactivarSesion(datosUser.getIdSesion());
    }

}
