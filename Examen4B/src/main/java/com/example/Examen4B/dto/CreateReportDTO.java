package com.example.Examen4B.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateReportDTO {
    @NotBlank(message="El nombre es obligatorio")
    @Size(min=3,max=20,message="El nombre debe estar entre 3 y 20 carcateres")
    private String nombre;


    @NotBlank(message="La descripcion es obligatoria")
    @Size(min=10,max=50,message="La descripcion debe estar entre 10 y 50 carcateres")
    private String descripcion;

    @NotBlank(message="La fecha es obligatoria")
    @Size(min=8,max=10,message="La fecha debe estar entre 8 y 10 carcateres")
    private String fecha;

    public CreateReportDTO() {}

    public CreateReportDTO(String nombre, String descripcion, String fecha) {
        this.nombre = nombre;
        this.descripcion=descripcion;
        this.fecha=fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
