package com.tareas.model;

import java.util.Date;

public class Tarea {
	private int Id;
    private String Nombre;
    private String Descripcion;
    private Date FechaInicio;
    
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Date getFechainicio() {
		return FechaInicio;
	}
	public void setFechainicio(Date fechaInicio) {
		FechaInicio = fechaInicio;
	}
}
