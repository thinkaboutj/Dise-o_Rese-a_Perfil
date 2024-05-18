/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entity.Usuario;
import java.util.Date;

/**
 *
 * @author jesus
 */
public interface IUsuarioDAO {
    
    public void insertarUsuario(Usuario usuario);
    
    public void ActualizarUsuario(Usuario Usuario);

    public void eliminarUsuario( String correo, String contrasena);
    
    public Usuario obtenerporID (Usuario usuario);
    
    public Usuario obtenerPorContrasenaYCorreo(String contrasena, String correo);
    
     public void DesactivarUsuario( String correo, String contrasena);
     
     public void actualizarPerfil(String correo, String contrasena, String nuevoNombre, Date nuevaFechaNacimiento);
     
     public void ActualizarDatos(String correo, String contrasena, String nombre, Date fechaNacimiento);
     
    
}
