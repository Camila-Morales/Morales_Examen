package com.espe.roles.model;

import java.time.LocalDateTime;


public class Usuario {

    private Long id;

    private String nombre;

    private String correo;

    private LocalDateTime fechaCreacion;

    // Constructor, getters y setters

    public void prePersist() {
        fechaCreacion = LocalDateTime.now();
    }

    public Usuario() {}

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
