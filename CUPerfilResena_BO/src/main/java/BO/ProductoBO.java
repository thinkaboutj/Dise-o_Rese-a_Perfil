/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package BO;

import DAO.ProductoDAO;
import Entity.Producto;
import java.util.Arrays;
import java.util.List;
import org.bson.types.ObjectId;

public class ProductoBO {

    private final ProductoDAO productoDAO;

    public ProductoBO() {
        this.productoDAO = new ProductoDAO();
    }

    public void insertarProducto(Producto producto) {
        productoDAO.insertarProducto(producto);
    }

    public Producto obtenerPorNombre(String nombre) {
        return productoDAO.obtenerPorNombre(nombre);
    }

    public List<Producto> obtenerTodosLosProductos() {
        return productoDAO.obtenerTodosLosProductos();
    }

    public void agregarResena(ObjectId idProducto, String resena) {
        productoDAO.agregarResena(idProducto, resena);
    }

    public void inicializarProductos() {
        List<Producto> productos = Arrays.asList(
                new Producto("Peluche Pochacco", 10.0, "Peluche pochacco bonito", 50),
                new Producto("Paraguas", 15.0, "Paraguas super protector contra rayos UV", 30),
                new Producto("Tennis", 20.0, "Tennis de calidad comodos", 20)
);

        // Agregar los productos al DAO
        for (Producto producto : productos) {
            productoDAO.insertarProducto(producto);
        }

        System.out.println("Productos inicializados correctamente.");
    }

}
