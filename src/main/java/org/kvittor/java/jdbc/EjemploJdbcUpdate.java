package org.kvittor.java.jdbc;

import org.kvittor.java.jdbc.modelo.Productos;
import org.kvittor.java.jdbc.repositorio.ProductoRepositorioImpl;

import java.time.Instant;
import java.util.Date;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {
            ProductoRepositorioImpl prod = new ProductoRepositorioImpl();
            System.out.println("========== Listar ========== ");
            prod.listar().forEach(System.out::println);

            System.out.println("========== Obtener por id ========== ");
            System.out.println(prod.porId(1L));
//
//            System.out.println("========== Insertar nuevo producto ========== ");
//            Productos p = new Productos();
//            p.setId(6L);
//            p.setNombre("Teclado razer");
//            p.setPrecio(1500f);
//            prod.guardar(p);
//
//            prod.listar().forEach(System.out::println);
//            System.out.println("========== Eliminar producto ========== ");
//            prod.eliminar(2L);
//            prod.listar().forEach(System.out::println);
    }
}
