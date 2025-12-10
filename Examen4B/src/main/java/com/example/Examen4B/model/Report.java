package com.example.Examen4B.model;

public class Report {
    private Long id;
    private String nombre;
    private String descripcion;
    private String fecha;

    public Report(){
    }

    public Report(Long id,String nombre, String descripcion, String fecha) {
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.fecha=fecha;
    }

    public Long getId() {
        return id;
    }
    public void setID(Long id){
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha=fecha;
    }

}
