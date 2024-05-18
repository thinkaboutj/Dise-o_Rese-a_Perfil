/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package recurso;

import BO.PerfilBO;
import DTO.UsuarioDTO;
import Interfaz.IAdmin;
import implementaciones.Administrador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus
 */
public class Registroo extends javax.swing.JFrame {

    /**
     * Creates new form Registroo
     */
    public Registroo() {
        initComponents();
    }
// Obtener los datos del formulario

    private void registrarUsuario() {

        IAdmin admin = new Administrador();

        // Obtener los datos del formulario
        String nombre = txtNombre.getText();
        String contrasena = txtContrasena.getText();
        String correo = txtCorreo.getText();
        String fechaNacimiento = dateNacimiento.getDate().toString();

        // Convertir la fecha de nacimiento de String a Date
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNacimientoDate = dateFormat.parse(fechaNacimiento);

            // Crear un objeto UsuarioDTO con los datos del formulario
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setNombre(nombre);
            usuarioDTO.setContrasena(contrasena);
            usuarioDTO.setCorreo(correo);
            usuarioDTO.setNacimiento(fechaNacimientoDate);

            // Llamar al método de registro en el admin
            admin.crearCuenta(usuarioDTO);

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente");

            // Limpiar los campos del formulario
            txtNombre.setText("");
            txtContrasena.setText("");
            txtCorreo.setText("");
            dateNacimiento.setDate(null);
        } catch (ParseException e) {
            e.printStackTrace();  // Manejo de error en caso de que la cadena no sea un formato válido
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

        Agrupador3 = new javax.swing.JPanel();
        btnCancelar3 = new javax.swing.JButton();
        btnRegistrarse3 = new javax.swing.JButton();
        txtCorreo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        dateNacimiento = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Agrupador3.setBackground(new java.awt.Color(255, 255, 255));
        Agrupador3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar3.setBackground(new java.awt.Color(0, 102, 153));
        btnCancelar3.setText("Cancelar");
        btnCancelar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar3ActionPerformed(evt);
            }
        });
        Agrupador3.add(btnCancelar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 100, 40));

        btnRegistrarse3.setText("Registrarse");
        btnRegistrarse3.setBackground(new java.awt.Color(0, 102, 153));
        btnRegistrarse3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarse3ActionPerformed(evt);
            }
        });
        Agrupador3.add(btnRegistrarse3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 100, 40));

        txtCorreo.setBackground(new java.awt.Color(242, 242, 242));
        txtCorreo.setForeground(new java.awt.Color(0, 0, 0));
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        Agrupador3.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 120, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Correo:");
        Agrupador3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Fecha de nacimiento:");
        Agrupador3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        txtContrasena.setBackground(new java.awt.Color(242, 242, 242));
        txtContrasena.setForeground(new java.awt.Color(0, 0, 0));
        txtContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContrasenaActionPerformed(evt);
            }
        });
        Agrupador3.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 120, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Contraseña:");
        Agrupador3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre:");
        Agrupador3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        txtNombre.setBackground(new java.awt.Color(242, 242, 242));
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        Agrupador3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 120, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro-icom.png"))); // NOI18N
        Agrupador3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 180, 190));
        Agrupador3.add(dateNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Agrupador3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Agrupador3, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar3ActionPerformed
        LogIn inicio = new LogIn();
        inicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelar3ActionPerformed

    private void btnRegistrarse3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarse3ActionPerformed

        // Obtener los datos del formulario
        String nombre = txtNombre.getText();
        String contrasena = txtContrasena.getText();
        String correo = txtCorreo.getText();
        String fechaNacimiento = dateNacimiento.getDate().toString();

        // Validar que los campos no estén vacíos
        if (nombre.isEmpty() || contrasena.isEmpty() || correo.isEmpty() || fechaNacimiento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Detener la ejecución del método si hay campos vacíos
        }

        try {
            registrarUsuario();

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente");

            // Limpiar los campos del formulario
            txtNombre.setText("");
            txtContrasena.setText("");
            txtCorreo.setText("");
            dateNacimiento.setDate(null);

            // Abrir la ventana de inicio de sesión
            LogIn inicio = new LogIn();
            inicio.setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un problema al registrar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Mostrar información sobre el error en la consola
        }

    }//GEN-LAST:event_btnRegistrarse3ActionPerformed

    private void txtContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContrasenaActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Agrupador3;
    private javax.swing.JButton btnCancelar3;
    private javax.swing.JButton btnRegistrarse3;
    private com.github.lgooddatepicker.components.DatePicker dateNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}