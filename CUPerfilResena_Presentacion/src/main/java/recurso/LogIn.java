/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package recurso;

import DTO.UsuarioDTO;
import Interfaz.IAdmin;
import Interfaz.Perfil;
import implementaciones.Administrador;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus
 */
public class LogIn extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    public LogIn() {
        initComponents();
          

        // creamos lo de el label registro clickeable
        lblRegistrarse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //abrimos los eventos de click en los label
                abrirRegistro();
            }
        });
    }

    private void entrar() {
        IAdmin admin = new Administrador();

        String correo = txtCorreo.getText();
        String contrasena = txtContrasena.getText();

        // Llamar al método del subsistema para iniciar sesión y obtener información del usuario
        UsuarioDTO usuarioDTO = admin.ObtenerInfo(correo, contrasena);

        // Verificar si se obtuvo información del usuario
        if (usuarioDTO != null) {
            // Verificar el estado de la cuenta
            if (usuarioDTO.getEstado().equals("eliminado")) {
                String correoUsuario = txtCorreo.getText();
                JOptionPane.showMessageDialog(this, "Tu cuenta ha sido eliminada. No puedes iniciar sesion.", "Error de inicio de sesion", JOptionPane.ERROR_MESSAGE);

            } else if (usuarioDTO.getEstado().equals("desactivado")) {

                int opcion = JOptionPane.showConfirmDialog(this, "La cuenta esta desactivada. ¿Desea activarla?", "Error de inicio de sesion", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

                if (opcion == JOptionPane.YES_OPTION) {
                    usuarioDTO.setEstado("activado");
                    admin.actualizarEstado(usuarioDTO);

                }
            } else {
                LimiteTienda tienda = new LimiteTienda();
                tienda.setVisible(true);
                
                dispose(); // Cerrar la ventana de inicio de sesión
            }
        } else {
            // Mostrar mensaje de error si las credenciales son incorrectas o la cuenta no existe
            JOptionPane.showMessageDialog(this, "Error: Correo o contraseña incorrectos.", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo para abrir Registro
     */
    private void abrirRegistro() {
        // Crear una nueva instancia del JFrame que deseas abrir
        Registroo registro = new Registroo();

        registro.setVisible(true);
        // Puedes cerrar el frame actual si es necesario
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Agrupador = new javax.swing.JPanel();
        etiquetaUsuario = new javax.swing.JLabel();
        etiquetaContrasena = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnIniciarSesion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblRegistrarse = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Agrupador.setBackground(new java.awt.Color(255, 255, 255));
        Agrupador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiquetaUsuario.setText("Correo:");
        etiquetaUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        etiquetaUsuario.setForeground(new java.awt.Color(0, 0, 0));
        Agrupador.add(etiquetaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        etiquetaContrasena.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        etiquetaContrasena.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaContrasena.setText("Contraseña:");
        Agrupador.add(etiquetaContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

        txtContrasena.setBackground(new java.awt.Color(234, 234, 234));
        txtContrasena.setForeground(new java.awt.Color(51, 51, 51));
        Agrupador.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 180, -1));

        txtCorreo.setBackground(new java.awt.Color(234, 234, 234));
        txtCorreo.setForeground(new java.awt.Color(51, 51, 51));
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        Agrupador.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 180, -1));

        btnIniciarSesion.setText("Iniciar sesion");
        btnIniciarSesion.setBackground(new java.awt.Color(0, 102, 153));
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        Agrupador.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 120, 40));

        btnSalir.setText("Salir");
        btnSalir.setBackground(new java.awt.Color(0, 102, 153));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        Agrupador.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 120, 40));

        lblRegistrarse.setText("Registrarse");
        lblRegistrarse.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblRegistrarse.setForeground(new java.awt.Color(0, 102, 153));
        Agrupador.add(lblRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("¿No tienes una cuenta?");
        Agrupador.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user-Cuent.png"))); // NOI18N
        Agrupador.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 160, 160));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Agrupador, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Agrupador, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed

        try {

            entrar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: vuelva a intentarlo.", "Error de eliminación", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Agrupador;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel etiquetaContrasena;
    private javax.swing.JLabel etiquetaUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblRegistrarse;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
