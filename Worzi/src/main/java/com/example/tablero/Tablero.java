package com.example.tablero;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.lista.Lista;

@Entity
public class Tablero {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	private String nombre;
	private boolean simple;
	private String fondo;
	private String descripcion;
	
	private ArrayList<Lista> tablero = new ArrayList<>();
	 
	public Tablero(long id, String nombre, boolean simple, String fondo, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.simple = simple;
		this.fondo = fondo;
		this.descripcion = descripcion;
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

	public ArrayList<Lista> getTablero() {
		return tablero;
	}

	public void setTablero(ArrayList<Lista> tablero) {
		this.tablero = tablero;
	}
	
	
}
