package controlador;

import modelo.DatosUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ModeloUsuario;
import ventanas.FormularioFactura;
import ventanas.VentanaActualizarProd;
import ventanas.VentanaActualizarProdOferta;
import ventanas.VentanaDetalleCompra;
import ventanas.VentanaListaVentas;
import ventanas.VentanaLogin;
import ventanas.VentanaPrincipal;
import ventanas.VentanaProdLibros;
import ventanas.VentanaProdMusicas;
import ventanas.VentanaProdOferta;
import ventanas.VentanaProdPeliculas;
import ventanas.VentanaProductos;

/**
 *
 * @author Carlos Ramos
 */
public class ControlVentanas {
    VentanaPrincipal ventanaPrincipal;
    
    VentanaProductos ventanaProd;
    VentanaProdOferta ventanaProdOferta;
    VentanaDetalleCompra ventanaDetalleC;
    FormularioFactura frmFactura;
    VentanaProdMusicas ventanaProdMus;
    VentanaProdLibros ventanaProdLibros;
    VentanaProdPeliculas ventanaProdPelis;
    VentanaListaVentas ventanaListaVentas;
    VentanaActualizarProd ventanaActProd;
    VentanaActualizarProdOferta ventanaActProdOferta;
    
    VentanaLogin ventanaLogin;
    
    ModeloUsuario modeloUser;
    DatosUsuario usuario;
    ArrayList<String> IUs;

    ControlVentanas(VentanaPrincipal ventanaPrincipal, ModeloUsuario modeloUser) {
        this.modeloUser = modeloUser;
        this.ventanaPrincipal = ventanaPrincipal;
        addActionListenerABotones();
        ventanaPrincipal.getLabelCerrarSesion().addMouseListener(new ListenerCerrarSesion());
    }

    public void mostrarVentanaPrincipal() {
        instanciarVentanas(IUs);
        habilitarBtnsIUs(IUs);
        ventanaPrincipal.setVisible(true);
    }
    
    public void instanciarVentanas(ArrayList<String> IUs) {
        for (String IU : IUs) {
            crearVentana(IU);
        }
    }
    
    public void habilitarBtnsIUs(ArrayList<String> IUs){
        for (String IU : IUs) {
            ventanaPrincipal.habilitarBoton(IU);
        }
    }
    
    private void crearVentana(String IU) {
        switch(IU){
            case "Ventana productos" : ventanaProd = new VentanaProductos(ventanaPrincipal);    break;
            case "Ventana productos de oferta" : ventanaProdOferta = new VentanaProdOferta(ventanaPrincipal);    break;
            case "Ventana detalle de compra" : ventanaDetalleC = new VentanaDetalleCompra(ventanaPrincipal);    break;
            case "Formulario de factura" : frmFactura = new FormularioFactura(ventanaPrincipal);   break;
            case "Ventana productos musicas" : ventanaProdMus = new VentanaProdMusicas();   break;
            case "Ventana productos libros" : ventanaProdLibros = new VentanaProdLibros();    break;
            case "Ventana productos peliculas" : ventanaProdPelis = new VentanaProdPeliculas();  break;
            case "Ventana lista de venta" : ventanaListaVentas = new VentanaListaVentas(ventanaPrincipal); break;
            case "Ventana actualizar productos" : ventanaActProd = new VentanaActualizarProd(ventanaPrincipal);    break;
            case "Ventana actualizar productos de oferta" : ventanaActProdOferta = new VentanaActualizarProdOferta(ventanaPrincipal); break;
            default:    JOptionPane.showMessageDialog(ventanaPrincipal, "no existe ventana");
        }
    }

    void setIUs(ArrayList<String> IUs) {
        this.IUs = IUs;
    }

    void setUsuario(DatosUsuario usuario) {
        this.usuario = usuario;
    }

    public void setVentanaLogin(VentanaLogin ventanaLogin) {
        this.ventanaLogin = ventanaLogin;
    }
    
    public void setVentanaMenu(VentanaPrincipal v){
        ventanaPrincipal = v;
    }

    private void addActionListenerABotones() {
        ventanaPrincipal.getBotonActProdOferta().addActionListener(new AccionAbrirVentana(ventanaPrincipal));
        ventanaPrincipal.getBotonActualizarProd().addActionListener(new AccionAbrirVentana(ventanaPrincipal));
        ventanaPrincipal.getBotonDetalleCompra().addActionListener(new AccionAbrirVentana(ventanaPrincipal));
        ventanaPrincipal.getBotonGenFactura().addActionListener(new AccionAbrirVentana(ventanaPrincipal));
        ventanaPrincipal.getBotonListaVentas().addActionListener(new AccionAbrirVentana(ventanaPrincipal));
        ventanaPrincipal.getBotonProdOferta().addActionListener(new AccionAbrirVentana(ventanaPrincipal));
        ventanaPrincipal.getBotonVerProd().addActionListener(new AccionAbrirVentana(ventanaPrincipal));
    }
    
    public void cerrarVentanas() {
        for (String IU : IUs) {
            cerrarVentana(IU);
        }
    }
    
    private void cerrarVentana(String IU) {
        switch(IU){
            case "Ventana productos" : ventanaProd.dispose();    break;
            case "Ventana productos de oferta" : ventanaProdOferta.dispose(); break;
            case "Ventana detalle de compra" : ventanaDetalleC.dispose();    break;
            case "Formulario de factura" : frmFactura.dispose();   break;
            case "Ventana productos musicas" : ventanaProdMus.dispose();   break;
            case "Ventana productos libros" : ventanaProdLibros.dispose();    break;
            case "Ventana productos peliculas" : ventanaProdPelis.dispose();  break;
            case "Ventana lista de venta" : ventanaListaVentas.dispose(); break;
            case "Ventana actualizar productos" : ventanaActProd.dispose();    break;
            case "Ventana actualizar productos de oferta" : ventanaActProdOferta.dispose(); break;
        }
    }

    private class ListenerCerrarSesion implements MouseListener {

        public ListenerCerrarSesion() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            modeloUser.cerrarSesion();
            cerrarVentanas();//probar???
            IUs = new ArrayList<>();//probar???
            ventanaPrincipal.deshabilitarBotones();
            ventanaPrincipal.dispose();
            ventanaLogin.borrarCampos();
            ventanaLogin.setVisible(true);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    private class AccionAbrirVentana implements ActionListener {
        VentanaPrincipal ventanaPrincipal;

        public AccionAbrirVentana(VentanaPrincipal ventanaPrincipal) {
            this.ventanaPrincipal = ventanaPrincipal;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Object boton = e.getSource();
            
            if(boton == ventanaPrincipal.getBotonActProdOferta()){
                ventanaActProdOferta.setVisible(true);
            }else if(boton == ventanaPrincipal.getBotonActualizarProd()){
                ventanaActProd.setVisible(true);
            }else if(boton == ventanaPrincipal.getBotonDetalleCompra()){
                ventanaDetalleC.setVisible(true);
            }else if(boton == ventanaPrincipal.getBotonGenFactura()){
                frmFactura.setVisible(true);
            }else if(boton == ventanaPrincipal.getBotonListaVentas()){
                ventanaListaVentas.setVisible(true);
            }else if(boton == ventanaPrincipal.getBotonProdOferta()){
                ventanaProdOferta.setVisible(true);
            }else if(boton == ventanaPrincipal.getBotonVerProd()){
                ventanaProd.setVisible(true);
            }
            ventanaPrincipal.setVisible(false);
        }
    }
    
    
}
