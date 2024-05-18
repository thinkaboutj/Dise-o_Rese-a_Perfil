/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Entity.Usuario;
import DAO.UsuarioDAO;
import java.util.Date;
import DTO.UsuarioDTO;

/**
 *
 * @author jesus
 */
public class PerfilBO {

    private final UsuarioDAO usuarioDAO;

    public PerfilBO() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void actualizarPerfil(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null || usuarioDTO.getCorreo() == null || usuarioDTO.getContrasena() == null) {
            System.out.println("Error: Datos de usuario incompletos.");
            return;
        }

        // Llamar al método de actualización del DAO con los datos del DTO
        usuarioDAO.actualizarPerfil(usuarioDTO.getCorreo(), usuarioDTO.getContrasena(), usuarioDTO.getNombre(), usuarioDTO.getNacimiento());
    }

    public void actualizarEstado(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null || usuarioDTO.getCorreo() == null || usuarioDTO.getEstado() == null) {
            System.out.println("Error: Datos de usuario incompletos.");
            return;
        }

        // Crear un objeto Usuario con los datos del DTO
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDTO.getCorreo());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEstado(usuarioDTO.getEstado());

        // Llamar al método de actualización del DAO con el objeto Usuario
        usuarioDAO.ActualizarUsuario(usuario);
    }

    // Método para desactivar la cuenta
    public void desactivarCuenta(String correo, String contrasena) {

        // Validar que los campos no estén en blanco
        if (correo == null || correo.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            System.out.println("Error: Correo electrónico y contraseña no pueden estar vacíos.");
            return;
        }

        // Llamar al método del DAO para eliminar la cuenta
        usuarioDAO.DesactivarUsuario(correo, contrasena);
    }

    public void eliminarCuenta(String correo, String contrasena) {
        // Validar que los campos no estén en blanco
        if (correo == null || correo.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            System.out.println("Error: Correo electrónico y contraseña no pueden estar vacíos.");
            return;
        }

        // Llamar al método del DAO para eliminar la cuenta
        usuarioDAO.eliminarUsuario(correo, contrasena);
    }

    public UsuarioDTO obtenerInfoUsuario(String contrasena, String correoElectronico) {
        // Obtener información del usuario desde la base de datos
        Usuario usuario = usuarioDAO.obtenerPorContrasenaYCorreo(contrasena, correoElectronico);

        // Crear un objeto UsuarioDTO con los datos obtenidos
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setCorreo(usuario.getEmail());
        usuarioDTO.setEstado(usuario.getEstado());
        usuarioDTO.setNacimiento(usuario.getFechaNacimiento());

        return usuarioDTO;
    }

    public void registrarUsuario(Usuario usuario) {
        // Usuario usuario = new Usuario();
        //usuario.setNombre(usuarioDTO.getNombre());
        //usuario.setEmail(usuarioDTO.getCorreo());
        //usuario.setFechaNacimiento(usuarioDTO.getNacimiento());
        //usuario.setContrasena(usuarioDTO.getContrasena());
        //usuario.setEstado("activo"); // O cualquier otro estado por defecto

        usuarioDAO.insertarUsuario(usuario);
    }

    public void actualizarDatosUsuario(String correo, String contrasena, String nombre, Date fechaNacimiento) {
        if (correo == null || contrasena == null || nombre == null || fechaNacimiento == null) {
            System.out.println("Error: Datos de usuario incompletos.");
            return;
        }

        // Llamar al método de actualización del DAO con los datos del usuario
        usuarioDAO.ActualizarDatos(correo, contrasena, nombre, fechaNacimiento);
    }

}
