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
    private int posicion; // Orden en la lista, se podrá cambiar
  
    @ManyToOne
    private Lista listaAsociada;

    // Constructores
	public Tarjeta(String nombre, String fecha, String color, String descripcion, Lista lista) {
		super();
		this.nombre = nombre;
		this.fechaFin = fecha;
		this.color = color;
		this.descripcion = descripcion;
		this.listaAsociada = lista;
		this.posicion = lista.size(); //Posicion en la lista, si estaba vacia, toma la posicion 0. Si tenía 2 elementos, toma la posicion 2.
	}
	public Tarjeta(String nombre, String fecha, String descripcion, Lista lista) {
		super();
		this.nombre = nombre;
		this.fechaFin = fecha;
		this.color = "Blanco";
		this.descripcion = descripcion;
		this.listaAsociada = lista;
		this.posicion = lista.size();
	}
	public Tarjeta(String nombre, String fecha, Lista lista) {
		super();
		this.nombre = nombre;
		this.fechaFin = fecha;
		this.color = "Blanco";
		this.descripcion = "";
		this.listaAsociada = lista;
		this.posicion = lista.size();
	}
	public Tarjeta(String nombre, Lista lista) {
		super();
		this.nombre = nombre;
		this.fechaFin = "";
		this.color = "Blanco";
		this.descripcion = "";
		this.listaAsociada = lista;
		this.posicion = lista.size();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaVencimiento() {
		return fechaFin;
	}

	public void setFechaVencimiento(String fecha) {
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
	
	public int getPosicion() {
		return this.posicion;
	}
	
	// HACER UN METODO QUE PERMITA CAMBIAR LA POSICION EN LA LISTA
	// COMPROBANDO QUE NO ES UNA POSICION INEXISTENTE: COMPROBAR TAMAÑO LISTA
	
	public Lista getListaAsociada() {
		return listaAsociada;
	}
	
	public void cambiarLista(Lista destino) {
		this.listaAsociada = destino;
	}
	
	
    
}
