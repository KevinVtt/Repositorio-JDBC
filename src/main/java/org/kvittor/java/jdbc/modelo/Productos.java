package org.kvittor.java.jdbc.modelo;

import java.util.Date;

public class Productos {
    private Long id;
    private String nombre;
    private Float precio;
    private Date fechaRegistro;
    private Categoria categoria;

    public Productos() {
    }

    public Productos(Long id, String nombre, Float precio, Date fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return id +
                " | " + nombre +
                " | " + precio +
                " | " + fechaRegistro +
                " | " + categoria;
    }
}
