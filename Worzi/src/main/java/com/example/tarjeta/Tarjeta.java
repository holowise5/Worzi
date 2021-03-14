package com.example.tarjeta;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarjeta {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String nombre;

   
    private String fecha;

    private String color;
    
    private String descripcion;

	public Tarjeta(String nombre, String fecha, String color, String descripcion) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.color = color;
		this.descripcion = descripcion;
	}
	public Tarjeta(String nombre, String fecha, String descripcion) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
	
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaVencimiento() {
		return fecha;
	}

	public void setFechaVencimiento(String fecha) {
		this.fecha = fecha;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
}
