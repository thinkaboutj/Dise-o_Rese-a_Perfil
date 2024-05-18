/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package DAO;

import ConexionBD.ConexionBD;
import Entity.Producto;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.List;

public class ProductoDAO {

    private final MongoCollection<Producto> productosCollection;

    public ProductoDAO() {
        this.productosCollection = ConexionBD.getDatabase().getCollection("Producto", Producto.class);
    }

    public void insertarProducto(Producto producto) {
        try {
            productosCollection.insertOne(producto);
            System.out.println("Producto insertado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al insertar producto: " + e.getMessage());
        }
    }

    public Producto obtenerPorNombre(String nombre) {
        try {
            Document filtro = new Document("nombre", nombre);

            Producto productoEncontrado = productosCollection.find(filtro).first();
            if (productoEncontrado != null) {
                return productoEncontrado;
            } else {
                System.out.println("Producto no encontrado.");
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error al obtener producto por nombre: " + e.getMessage());
            return null;
        }
    }

    public List<Producto> obtenerTodosLosProductos() {
        try {
            return productosCollection.find().into(new ArrayList<>());
        } catch (Exception e) {
            System.err.println("Error al obtener todos los productos: " + e.getMessage());
            return null;
        }
    }

    public void agregarResena(ObjectId idProducto, String resena) {
        try {
            Document filtro = new Document("_id", idProducto);
            Document actualizacion = new Document("$push", new Document("resenas", resena));

            productosCollection.updateOne(filtro, actualizacion);
            System.out.println("Reseña agregada correctamente.");
        } catch (Exception e) {
            System.err.println("Error al agregar reseña: " + e.getMessage());
        }
    }

    // Otros métodos de gestión de productos según tus necesidades
}
