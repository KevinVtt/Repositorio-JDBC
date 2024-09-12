package org.kvittor.java.jdbc.repositorio;

import org.kvittor.java.jdbc.modelo.Categoria;
import org.kvittor.java.jdbc.modelo.Productos;
import org.kvittor.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Productos> {

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getConnection();
    }

    @Override
    public List<Productos> listar() {
        List<Productos> listProductos = new ArrayList<>();
        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT p.*, c.nombre as categoria FROM productos as p inner join categoria as c on (p.categoria_id = c.id)")){

            while (rs.next()){
                listProductos.add(crearProducto(rs));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listProductos;
    }

    @Override
    public Productos porId(Long id) {
        Productos p = null;
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT p.*, p.nombre as categoria FROM productos as p inner join categoria as c on (p.categoria_id = c.id) WHERE p.id = ?")){

            stmt.setLong(1,id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    p = crearProducto(rs);
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    @Override
    public void guardar(Productos productos) {
        String sql = null;
        if (productos.getId() != null && productos.getId() > 0 ) {
            sql = "UPDATE productos SET nombre=?, precio=?, categoria_id=? WHERE id=?";
        }else{
            sql = "INSERT INTO productos(nombre,precio, categoria_id,fecha_registro) VALUES (?,?,?,?)";
        }
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1,productos.getNombre());
            stmt.setFloat(2,productos.getPrecio());
            stmt.setLong(3,productos.getCategoria().getId());
            if (productos.getId() != null && productos.getId() > 0) {
                stmt.setLong(4,productos.getId());
            }else{
                stmt.setDate(4,new Date(productos.getFechaRegistro().getTime()));

            }
            stmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void eliminar(Long id) {
        String sql = "DELETE FROM productos WHERE id= ?";
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1,id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Productos crearProducto(ResultSet rs) throws SQLException {
        Productos p = new Productos();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getFloat("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        Categoria c = new Categoria();
        c.setId(rs.getLong("categoria_id"));
        c.setNombre(rs.getString("categoria"));
        p.setCategoria(c);
        return p;
    }

}
