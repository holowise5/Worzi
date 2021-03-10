package com.example.usuario;

import com.example.pedido.Pedido;
import com.example.resena.Resena;
import com.example.tablero.Tablero;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique = true)
	private String nombreUsuario;

	@Column(unique = true)
	private String email;

	private String contrasenya;

	private boolean Admin;
	private ArrayList<Tablero> tablero = new ArrayList<>();

	protected Usuario() {
	}

	public Usuario(String nombreUsuario, String email, String contrasenya) {
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.contrasenya = contrasenya;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	

}
