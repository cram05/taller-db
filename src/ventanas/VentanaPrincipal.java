package ventanas;

import javax.swing.JButton;
import javax.swing.JLabel;
import modelo.ModeloUsuario;

/**
 *
 * @author Carlos Ramos
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    ModeloUsuario modeloUser;
    VentanaLogin ventanaLogin;
    
    public VentanaPrincipal(ModeloUsuario modelo) {
        initComponents();
        modeloUser = modelo;
        deshabilitarBotones();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonVerProd = new javax.swing.JButton();
        botonProdOferta = new javax.swing.JButton();
        botonGenFactura = new javax.swing.JButton();
        botonDetalleCompra = new javax.swing.JButton();
        botonActualizarProd = new javax.swing.JButton();
        botonActProdOferta = new javax.swing.JButton();
        botonListaVentas = new javax.swing.JButton();
        labelCerrarSesion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Interfaces de Usuario");

        jLabel2.setText("Las IU se habilitan segun los permisos para determinado usuario");

        botonVerProd.setText("Ver Productos");

        botonProdOferta.setText("Productos en Oferta");

        botonGenFactura.setText("Generar Factura");

        botonDetalleCompra.setText("Detalle de Compra ");

        botonActualizarProd.setText("Actualizar Productos");

        botonActProdOferta.setText("Actualizar Productos de Oferta");

        botonListaVentas.setText("Lista de Ventas");

        labelCerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCerrarSesion.setForeground(new java.awt.Color(0, 0, 255));
        labelCerrarSesion.setText("Cerrar Sesion");
        labelCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCerrarSesionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel2)))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonVerProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonListaVentas))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonActualizarProd)
                                    .addComponent(botonDetalleCompra)
                                    .addComponent(botonActProdOferta))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonProdOferta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonGenFactura)))))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelCerrarSesion)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVerProd)
                    .addComponent(botonListaVentas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonProdOferta)
                    .addComponent(botonGenFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonDetalleCompra)
                .addGap(35, 35, 35)
                .addComponent(botonActualizarProd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonActProdOferta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCerrarSesion)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCerrarSesionMouseClicked
        
    }//GEN-LAST:event_labelCerrarSesionMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActProdOferta;
    private javax.swing.JButton botonActualizarProd;
    private javax.swing.JButton botonDetalleCompra;
    private javax.swing.JButton botonGenFactura;
    private javax.swing.JButton botonListaVentas;
    private javax.swing.JButton botonProdOferta;
    private javax.swing.JButton botonVerProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelCerrarSesion;
    // End of variables declaration//GEN-END:variables

    public void deshabilitarBotones() {
        botonVerProd.setEnabled(false);
        botonProdOferta.setEnabled(false);
        botonGenFactura.setEnabled(false);
        botonDetalleCompra.setEnabled(false);
        botonActualizarProd.setEnabled(false);
        botonActProdOferta.setEnabled(false);
        botonListaVentas.setEnabled(false);
    }
    
    public void habilitarBoton(String nomBoton){
        switch(nomBoton){
            case "Ventana productos": botonVerProd.setEnabled(true);    break;
            case "Ventana productos de oferta": botonProdOferta.setEnabled(true);    break;
            case "Formulario de factura": botonGenFactura.setEnabled(true);    break;
            case "Ventana detalle de compra" : botonDetalleCompra.setEnabled(true); break;
            case "Ventana actualizar productos de oferta" : botonActProdOferta.setEnabled(true);    break;
            case "Ventana lista de venta" : botonListaVentas.setEnabled(true);    break;
            case "Ventana actualizar productos" : botonActualizarProd.setEnabled(true);  break;
        }
    }

    public JButton getBotonActProdOferta() {
        return botonActProdOferta;
    }

    public JButton getBotonActualizarProd() {
        return botonActualizarProd;
    }

    public JButton getBotonDetalleCompra() {
        return botonDetalleCompra;
    }

    public JButton getBotonGenFactura() {
        return botonGenFactura;
    }

    public JButton getBotonListaVentas() {
        return botonListaVentas;
    }

    public JButton getBotonProdOferta() {
        return botonProdOferta;
    }

    public JButton getBotonVerProd() {
        return botonVerProd;
    }

    public void setVentanaLogin(VentanaLogin vLogin) {
        ventanaLogin = vLogin;
    }

    public JLabel getLabelCerrarSesion() {
        return labelCerrarSesion;
    }

}
