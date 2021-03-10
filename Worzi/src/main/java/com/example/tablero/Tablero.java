package com.example.tablero;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tablero {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	private String nombre;
	private boolean simple;
	private String fondo;
	private String descripcion;
	 
	public Tablero(long id, String nombre, boolean simple, String fondo, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.simple = simple;
		this.fondo = fondo;
		this.descripcion = descripcion;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isSimple() {
		return simple;
	}
	public void setSimple(boolean simple) {
		this.simple = simple;
	}
	public String getFondo() {
		return fondo;
	}
	public void setFondo(String fondo) {
		this.fondo = fondo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	 
	 
}
