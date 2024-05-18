/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Entity.Usuario;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import interfaces.IUsuarioDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class UsuarioDAO implements IUsuarioDAO {

    private final MongoCollection<Usuario> usuariosCollection;

    public UsuarioDAO() {
        this.usuariosCollection = ConexionBD.getDatabase().getCollection("Usuario", Usuario.class);
    }

    @Override
    public void insertarUsuario(Usuario usuario) {
        try {
            usuariosCollection.insertOne(usuario);
            System.out.println("Usuario insertado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
        }
    }

    @Override
    public Usuario obtenerporID(Usuario usuario) {
        try {
            Document filtro = new Document("_id", usuario.getId());

            Usuario usuarioEncontrado = usuariosCollection.find(filtro).first();
            if (usuarioEncontrado != null) {
                return usuarioEncontrado;
            } else {
                System.out.println("Usuario no encontrado.");
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error al obtener usuario por ID: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Usuario obtenerPorContrasenaYCorreo(String contrasena, String correo) {
        try {
            Document filtro = new Document("contrasena", contrasena)
                    .append("email", correo);

            Usuario usuarioEncontrado = usuariosCollection.find(filtro).first();
            if (usuarioEncontrado != null) {
                return usuarioEncontrado;
            } else {
                System.out.println("Usuario no encontrado.");
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error al obtener usuario por contraseña y correo: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void eliminarUsuario(String correo, String contrasena) {
        try {
            // Buscar el usuario por correo y contraseña
            Document filtro = new Document("email", correo)
                    .append("contrasena", contrasena);
            FindIterable<Usuario> resultado = usuariosCollection.find(filtro);

            if (resultado.iterator().hasNext()) {
                // Obtener el ID del usuario encontrado
                ObjectId idUsuario = resultado.first().getId();

                // Crear el filtro para actualizar el estado del usuario a eliminado
                Document filtroActualizar = new Document("_id", idUsuario);
                Document actualizacion = new Document("$set", new Document("estado", "eliminado"));

                usuariosCollection.updateOne(filtroActualizar, actualizacion);
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("Error: Usuario no encontrado.");
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
        }
    }

    @Override
    public void DesactivarUsuario(String correo, String contrasena) {
        try {
            // Buscar el usuario por correo y contraseña
            Document filtro = new Document("email", correo)
                    .append("contrasena", contrasena);
            FindIterable<Usuario> resultado = usuariosCollection.find(filtro);

            // Verificar si se encontró un usuario
            if (resultado.iterator().hasNext()) {
                // Obtener el ID del usuario encontrado
                ObjectId idUsuario = resultado.first().getId();

                // Crear el filtro para actualizar el estado del usuario a eliminado
                Document filtroActualizar = new Document("_id", idUsuario);
                Document actualizacion = new Document("$set", new Document("estado", "desactivado"));

                // Actualizar el estado del usuario a eliminado
                usuariosCollection.updateOne(filtroActualizar, actualizacion);
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("Error: Usuario no encontrado.");
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
        }
    }

    @Override
    public void ActualizarUsuario(Usuario usuario) {

        try {
            // Buscar el usuario por correo electrónico (o cualquier otro identificador único)
            Document filtro = new Document("email", usuario.getEmail());
            Document actualizacion = new Document("$set", new Document("nombre", usuario.getNombre())
                    .append("estado", usuario.getEstado()));

            usuariosCollection.updateOne(filtro, actualizacion);
            System.out.println("Usuario actualizado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
        }

    }
    
    @Override
    public void actualizarPerfil(String correo, String contrasena, String nuevoNombre, Date nuevaFechaNacimiento) {
        try {
            // Buscar el usuario por correo y contraseña
            Document filtro = new Document("email", correo)
                    .append("contrasena", contrasena);
            FindIterable<Usuario> resultado = usuariosCollection.find(filtro);

            // Verificar si se encontró un usuario
            if (resultado.iterator().hasNext()) {
                // Obtener el ID del usuario encontrado
                ObjectId idUsuario = resultado.first().getId();

                // Crear el filtro para actualizar los datos del usuario
                Document filtroActualizar = new Document("_id", idUsuario);
                Document actualizacion = new Document("$set", new Document("nombre", nuevoNombre)
                        .append("fechaNacimiento", nuevaFechaNacimiento));

                // Actualizar los datos del usuario
                usuariosCollection.updateOne(filtroActualizar, actualizacion);
                System.out.println("Perfil de usuario actualizado correctamente.");
            } else {
                System.out.println("Error: Usuario no encontrado.");
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
        }
    }
    
    @Override
    public void ActualizarDatos(String correo, String contrasena, String nombre, Date fechaNacimiento) {
    try {
        // Verificar que el correo y la contraseña coincidan para actualizar el usuario
        Document filtro = new Document("email", correo).append("contrasena", contrasena);
        Document actualizacion = new Document("$set", new Document("nombre", nombre)
                .append("fechaNacimiento", fechaNacimiento));

        usuariosCollection.updateOne(filtro, actualizacion);
        System.out.println("Usuario actualizado correctamente.");
    } catch (Exception e) {
        System.err.println("Error al actualizar usuario: " + e.getMessage());
    }

}
}

/**
 * private MongoClient mongoClient; private MongoDatabase database; private
 * MongoCollection<Document> collection;
 *
 * private MongoCollection<Usuario> usuariosCollection;
 *
 * public UsuarioDAO() { }
 *
 * @Override public void insertarUsuario(Usuario usuario) { try { mongoClient =
 * MongoClients.create("mongodb://localhost:27017"); database =
 * mongoClient.getDatabase("Usuarios"); collection =
 * database.getCollection("Usuario");
 *
 * Document cliente = new Document("_id", new ObjectId()) .append("nombre",
 * usuario.getNombre()) .append("email", usuario.getEmail())
 * .append("contrasena", usuario.getContrasena()) .append("fechaNacimiento",
 * usuario.getFechaNacimiento()) .append("estado", usuario.getEstado());
 *
 * collection.insertOne(cliente); System.out.println("Usuario insertado
 * correctamente."); } catch (Exception e) { System.err.println("Error al
 * insertar usuario: " + e.getMessage()); } }
 *
 *
 * @Override public void ActualizarUsuario(Usuario usuario) {
 *
 * mongoClient = MongoClients.create("mongodb://localhost:27017"); database =
 * mongoClient.getDatabase("Usuarios"); collection =
 * database.getCollection("Usuario");
 *
 * try { Document filtro = new Document("_id", usuario.getId()); Document
 * actualizacion = new Document("$set", new Document("nombre",
 * usuario.getNombre()) .append("email", usuario.getEmail()));
 *
 * usuariosCollection.updateOne(filtro, actualizacion);
 * System.out.println("Usuario actualizado correctamente."); } catch (Exception
 * e) { System.err.println("Error al actualizar usuario: " + e.getMessage()); }
 *
 * }
 *
 * @Override public void eliminarUsuario(Usuario usuario) { try { Document
 * filtro = new Document("_id", usuario.getId()); Document actualizacion = new
 * Document("$set", new Document("estado", "eliminado"));
 *
 * usuariosCollection.updateOne(filtro, actualizacion);
 * System.out.println("Usuario eliminado correctamente."); } catch (Exception e)
 * { System.err.println("Error al eliminar usuario: " + e.getMessage()); } }
 *
 * @Override public Usuario obtenerporID(Usuario usuario) { try { //
 * usuario.getId() devuelve el ObjectId del usuario que voy a buscar Document
 * filtro = new Document("_id", usuario.getId());
 *
 * Usuario usuarioEncontrado = usuariosCollection.find(filtro).first(); if
 * (usuarioEncontrado != null) { return usuarioEncontrado; } else {
 * System.out.println("Usuario no encontrado."); return null; } } catch
 * (Exception e) { System.err.println("Error al obtener usuario por ID: " +
 * e.getMessage()); return null; }
 *
 * }
 *
 * @Override public Usuario obtenerPorContrasenaYCorreo(String contrasena,
 * String correo) {
 *
 * mongoClient = MongoClients.create("mongodb://localhost:27017"); database =
 * mongoClient.getDatabase("Usuarios"); collection =
 * database.getCollection("Usuario");
 *
 * try { // Crear un filtro para buscar por nombre de usuario y correo
 * electrónico Document filtro = new Document(); filtro.append("contrasena",
 * contrasena); filtro.append("email", correo);
 *
 * Document result = collection.find(filtro).first(); // Usuario
 * usuarioEncontrado = usuariosCollection.find(filtro).first(); Usuario
 * usuarioEncontrado = new Usuario();
 *
 * //para la fecha String fechaNacimientoCadena =
 * result.getString("fechaNacimiento");
 *
 * SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); Date
 * fechaNacimiento = null;
 *
 * try { fechaNacimiento = formato.parse(fechaNacimientoCadena); } catch
 * (ParseException e) { e.printStackTrace(); }
 *
 * usuarioEncontrado.setNombre(result.getString("nombre"));
 * usuarioEncontrado.setEmail(result.getString("email"));
 * usuarioEncontrado.setContrasena(result.getString("contrasena"));
 * usuarioEncontrado.setFechaNacimiento(fechaNacimiento);
 * usuarioEncontrado.setEstado(result.getString("estado"));
 *
 * System.out.println(contrasena + correo); if (result != null) { return
 * usuarioEncontrado; } else { System.out.println("Usuario no encontrado.");
 * return null; } } catch (Exception e) { System.err.println("Error al obtener
 * usuario por contraseña y correo: " + e.getMessage()); return null; } }
 *
 */
