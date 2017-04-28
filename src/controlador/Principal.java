package controlador;

import modelo.ModeloUsuario;
import ventanas.VentanaLogin;
import ventanas.VentanaPrincipal;

/**
 *
 * @author Carlos Ramos
 */
public class Principal {
    public static void main(String[] args) {
        ModeloUsuario modeloUser = new ModeloUsuario();//modelo
        
        VentanaLogin vLogin = new VentanaLogin(modeloUser);
        
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(modeloUser);
        ventanaPrincipal.setVentanaLogin(vLogin);
        
        ControlLogin controlLogin = new ControlLogin(vLogin,modeloUser);
        ControlVentanas controlVentanas = new ControlVentanas(ventanaPrincipal, modeloUser);
        controlLogin.setControlVentanas(controlVentanas);
        
        vLogin.setVisible(true);
    }
            
}
