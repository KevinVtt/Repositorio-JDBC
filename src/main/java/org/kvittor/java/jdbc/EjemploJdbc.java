package org.kvittor.java.jdbc;

import org.kvittor.java.jdbc.modelo.Categoria;
import org.kvittor.java.jdbc.modelo.Productos;
import org.kvittor.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.kvittor.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {
            ProductoRepositorioImpl prod = new ProductoRepositorioImpl();
            System.out.println("========== Listar ========== ");
            prod.listar().forEach(System.out::println);

            System.out.println("========== Obtener por id ========== ");
            System.out.println(prod.porId(1L));

            System.out.println("========== Insertar nuevo producto ========== ");
            Productos p = new Productos();
            p.setNombre("Teclado razer ultimate2");
            p.setPrecio(1500f);
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            p.setCategoria(categoria);
            p.setId(8L);
            //prod.guardar(p);
            prod.listar().forEach(System.out::println);
            System.out.println("Producto guardado con exito");
//            System.out.println("========== Eliminar producto ========== ");
//            prod.listar().forEach(System.out::println);
    }
}
