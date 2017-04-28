package controlador;

import modelo.DatosUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ModeloUsuario;
import ventanas.VentanaLogin;
import ventanas.VentanaPrincipal;

/**
 *
 * @author Carlos Ramos
 */
public class ControlLogin {
    VentanaLogin vistaLogin;
    ModeloUsuario modeloUser;
    VentanaPrincipal ventanaPrincipal;
    
    ControlVentanas controlVentanas;
    
    public ControlLogin(VentanaLogin v, ModeloUsuario modelo){
        vistaLogin = v;
        vistaLogin.getBotonEntrar().addActionListener(new AccionBtnEntrar());
        this.modeloUser = modelo;
    }

    public void setControlVentanas(ControlVentanas controlV) {
        controlVentanas = controlV;
    }
    
    private class AccionBtnEntrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String user = vistaLogin.getTextFieldUsuario().getText();
            String pass = String.copyValueOf(vistaLogin.getPasswordfield().getPassword());

            DatosUsuario usuario = modeloUser.buscarUsuario(user, pass);
            if(usuario == null){
                JOptionPane.showMessageDialog(vistaLogin, "Usuario no registrado", "Error", JOptionPane.WARNING_MESSAGE);
                vistaLogin.borrarCampos();
            }else{
                ArrayList<String> IUs = modeloUser.obtenerIUs(usuario);
                controlVentanas.setIUs(IUs);
                controlVentanas.setUsuario(usuario);
                controlVentanas.setVentanaLogin(vistaLogin);
                controlVentanas.mostrarVentanaPrincipal();
                vistaLogin.dispose();
            }
        }
    }
    
}
