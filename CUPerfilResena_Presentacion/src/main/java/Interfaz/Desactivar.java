/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import DTO.UsuarioDTO;
import implementaciones.Administrador;
import javax.swing.JOptionPane;
import recurso.LogIn;

/**
 *
 * @author jesus
 */
public class Desactivar extends javax.swing.JFrame {

    /**
     * Creates new form Desactivar
     */
    public Desactivar() {
        initComponents();
    }

    private void desactivado() {
        IAdmin admin = new Administrador();

        String correo = txtCorreo.getText();
        String contrasena = txtContrasena.getText();

        // Validar que los campos de texto no estén en blanco
        if (correo.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Debes ingresar el correo y la contraseña.", "Error de desacrivacion", JOptionPane.ERROR_MESSAGE);
            return;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setCorreo(correo);
        usuarioDTO.setContrasena(contrasena);

        if (usuarioDTO != null) {

            admin.desactivar(usuarioDTO, contrasena);
            JOptionPane.showMessageDialog(this, "Cuenta desasctivada exitosamente.");

            LogIn login = new LogIn();

            login.setVisible(true);
            this.dispose();

        } else {
            // Mostrar mensaje de error si las credenciales son incorrectas
            JOptionPane.showMessageDialog(this, "Error: Correo o contraseña incorrectos.", "Error de eliminación", JOptionPane.ERROR_MESSAGE);
        }

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
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtContrasena = new java.awt.TextField();
        jLabel10 = new javax.swing.JLabel();
        txtCorreo = new java.awt.TextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Agrupador.setBackground(new java.awt.Color(255, 255, 255));
        Agrupador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user-Cuent.png"))); // NOI18N
        Agrupador.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 150, 140));

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 472, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Agrupador.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 30));

        btnCancelar.setBackground(new java.awt.Color(0, 102, 153));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        Agrupador.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 110, 40));

        btnDesactivar.setBackground(new java.awt.Color(0, 102, 153));
        btnDesactivar.setForeground(new java.awt.Color(255, 255, 255));
        btnDesactivar.setText("Desactivar");
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });
        Agrupador.add(btnDesactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 110, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Usted esta apunto de desactivar su cuenta");
        Agrupador.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 310, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("para continuar confirme su contraseña");
        Agrupador.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 270, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Ingrese la constraseña:");
        Agrupador.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 310, -1));
        Agrupador.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 270, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("La desactivacion sera temporalmente,");
        Agrupador.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 260, -1));
        Agrupador.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 270, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Ingrese el correo:");
        Agrupador.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 310, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Agrupador, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Agrupador, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:

        Perfil perfil = new Perfil();

        perfil.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        // TODO add your handling code here:
        try {
            desactivado();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: vuelva a intentarlo.", "Error de eliminación", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btnDesactivarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Agrupador;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private java.awt.TextField txtContrasena;
    private java.awt.TextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
