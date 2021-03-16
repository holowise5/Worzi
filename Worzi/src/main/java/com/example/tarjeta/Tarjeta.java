package com.example.tarjeta;


// import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.lista.Lista;

@Entity
public class Tarjeta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;
    private String fechaFin;
    private String color;
    private String descripcion;

    // Constructores
    public Tarjeta() {
    }
    
	public Tarjeta(String nombre, String fecha, String color, String descripcion) {
		super();
		this.nombre = nombre;
		this.fechaFin = fecha;
		this.color = color;
		this.descripcion = descripcion;
	}
	public Tarjeta(String nombre, String fecha, String descripcion) {
		super();
		this.nombre = nombre;
		this.fechaFin = fecha;
		this.color = "Blanco";
		this.descripcion = descripcion;
	}
	public Tarjeta(String nombre, String fecha) {
		super();
		this.nombre = nombre;
		this.fechaFin = fecha;
		this.color = "Blanco";
		this.descripcion = "";
	}
	public Tarjeta(String nombre) {
		super();
		this.nombre = nombre;
		this.fechaFin = "";
		this.color = "Blanco";
		this.descripcion = "";
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fecha) {
		this.fechaFin = fecha;
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
