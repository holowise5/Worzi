package com.example.lista;

import com.example.pedido.Pedido;
import com.example.resena.Resena;
import com.example.tablero.Tablero;

import Tarjeta.Tarjeta;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String nombreUsuario;

    @Column(unique = true)
    private String email;


    private String contrasenya;
    
    private boolean Admin;
    private ArrayList<Tarjeta> lista = new ArrayList<>();
    


    protected Lista() {
    }

    public Lista(String nombreUsuario, String email, String contrasenya) {
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

   

    /*
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void anyadirPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void eliminarPeido(Pedido pedido) {
        this.pedidos.remove(pedido);
    }
*/
  
}
