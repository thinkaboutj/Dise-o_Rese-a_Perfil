/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import BO.PerfilBO;
import DTO.UsuarioDTO;
import Entity.Usuario;
import Interfaz.IAdmin;
import java.util.Date;
import java.util.prefs.Preferences;

/**
 *
 * @author jesus
 */
public class Administrador implements IAdmin {

    private PerfilBO perfilBO = new PerfilBO();

    public Administrador() {
    }

    @Override
    public void Editar(UsuarioDTO usuarioDTO) {
        // Validar que el DTO no sea nulo y contenga los datos necesarios
        if (usuarioDTO == null || usuarioDTO.getCorreo() == null || usuarioDTO.getContrasena() == null) {
            System.out.println("Error: Datos de usuario incompletos.");
            return;
        }

        // Llamar al método de actualización de perfil en el BO
        perfilBO.actualizarPerfil(usuarioDTO);
    }

    @Override
    public void desactivar(UsuarioDTO usuarioDTO, String contraseñaConfirmada) {
        if (usuarioDTO == null || usuarioDTO.getCorreo() == null || usuarioDTO.getCorreo().isEmpty()
                || usuarioDTO.getContrasena() == null || usuarioDTO.getContrasena().isEmpty()) {
            System.out.println("Error: UsuarioDTO incompleto.");
            return;
        }

        // Llamar al método del BO para eliminar la cuenta
        perfilBO.desactivarCuenta(usuarioDTO.getCorreo(), usuarioDTO.getContrasena());
    }

    @Override
    public void actualizar(UsuarioDTO usuarioDTO) {
        perfilBO.actualizarPerfil(usuarioDTO);

    }

    @Override
    public UsuarioDTO ObtenerInfo(String correoElectronico, String contrasena) {
        if (correoElectronico == null || correoElectronico.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            System.out.println("Error: El correo electrónico y la contraseña no pueden estar vacíos.");
            return null;
        }

        // Obtener la información utilizando el correo y la contraseña
        UsuarioDTO usuarioDTO = perfilBO.obtenerInfoUsuario(contrasena, correoElectronico);

        if (usuarioDTO == null) {
            System.out.println("Error: No se encontró un usuario con esos credenciales.");
            return null;
        }

        // Devolver el usuarioDTO con la información obtenida
        return usuarioDTO;

    }

    @Override
    public void crearCuenta(UsuarioDTO usuarioDTO) {
        // Validar que los campos obligatorios no estén en blanco
        if (usuarioDTO != null && usuarioDTO.getNombre() != null && !usuarioDTO.getNombre().isEmpty()
                && usuarioDTO.getCorreo() != null && !usuarioDTO.getCorreo().isEmpty()
                && usuarioDTO.getContrasena() != null && !usuarioDTO.getContrasena().isEmpty()) {

            // Crear una instancia de Usuario a partir de UsuarioDTO
            Usuario usuario = new Usuario();
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setEmail(usuarioDTO.getCorreo());
            usuario.setFechaNacimiento(usuarioDTO.getNacimiento());
            usuario.setContrasena(usuarioDTO.getContrasena());
            usuario.setEstado("activo");

            // Insertar el nuevo usuario en la base de datos
            perfilBO.registrarUsuario(usuario);
            System.out.println("Usuario registrado exitosamente.");
        } else {
            System.out.println("Error: Datos de usuario inválidos.");
        }
    }

    @Override
    public void Eliminar(UsuarioDTO usuarioDTO, String contrasenaConfirmada) {

        // Validar que el usuarioDTO no sea nulo y contenga correo y contraseña
        if (usuarioDTO == null || usuarioDTO.getCorreo() == null || usuarioDTO.getCorreo().isEmpty()
                || usuarioDTO.getContrasena() == null || usuarioDTO.getContrasena().isEmpty()) {
            System.out.println("Error: UsuarioDTO incompleto.");
            return;
        }

        // Llamar al método del BO para eliminar la cuenta
        perfilBO.eliminarCuenta(usuarioDTO.getCorreo(), usuarioDTO.getContrasena());
    }

    @Override
    public void actualizarEstado(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null || usuarioDTO.getCorreo() == null || usuarioDTO.getEstado() == null) {
            System.out.println("Error: Datos de usuario incompletos.");
            return;
        }

        // Llamar al método del BO para actualizar el estado del usuario
        perfilBO.actualizarEstado(usuarioDTO);
    }
    
    @Override
     public void actualizarDatosUsuario(String correo, String contrasena, String nombre, Date fechaNacimiento) {
        if (correo == null || contrasena == null || nombre == null || fechaNacimiento == null) {
            System.out.println("Error: Datos de usuario incompletos.");
            return;
        }

        // Llamar al método de actualización del perfil en el BO
        perfilBO.actualizarDatosUsuario(correo, contrasena, nombre, fechaNacimiento);
    }

}
