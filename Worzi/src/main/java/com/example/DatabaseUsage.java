package com.example;

import com.example.lista.Lista;
import com.example.lista.ListaRepository;
import com.example.tablero.Tablero;
import com.example.tablero.TableroRepository;
import com.example.tarjeta.Tarjeta;
import com.example.tarjeta.TarjetaRepository;
import com.example.usuario.Usuario;
import com.example.usuario.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseUsage implements CommandLineRunner {

	
	@Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TableroRepository tableroRepository;

    @Autowired
    private ListaRepository listaRepository;
    
    @Autowired
	private TarjetaRepository tarjetaRepository;

   

    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario("joseAngel", "jose@hola.com", "password");
        Usuario u2 = new Usuario("gonzalo", "gonzalo@hola.com", "password");
        Usuario u3 = new Usuario("Admin", "admin@hola.com", "password", true); // El true es para distinguirlo como admin.
       
        usuarioRepository.save(u1);
        usuarioRepository.save(u2);
        usuarioRepository.save(u3);

        // CREAR AQUI UN TABLERO PARA CADA USUARIO CON 1 LISTA DE VARIAS TARJETAS
        Tablero tU1 = new Tablero("Tablero lista compra Usuario1", true, "fondo.jpg", "Lista de la compra", u1); //Tablero simple=true
        Lista lU1 = new Lista("Lista compra Mercadona");
        Tarjeta t1 = new Tarjeta("Arroz");
        Tarjeta t2 = new Tarjeta("Pollo");
        Tarjeta t3 = new Tarjeta("Patatas");
        
        lU1.addTarjeta(t1);
        lU1.addTarjeta(t2);
        lU1.addTarjeta(t3);
        tU1.addLista(lU1);        
        u1.addTablero(tU1);
        
        tarjetaRepository.save(t1);
        tarjetaRepository.save(t2);
        tarjetaRepository.save(t3);
        listaRepository.save(lU1);
        tableroRepository.save(tU1);
        usuarioRepository.save(u1);
        
        
        Tablero tU2 = new Tablero("Tablero Usuario2", false, "fondo.jpg", "Deberes asignaturas", u1); //Tablero simple = false
        lU1 = new Lista("DGP");
        Lista lU2 = new Lista("DAD");
        t1 = new Tarjeta("Test tema 1");
        t2 = new Tarjeta("Resumen video Historias de Usuario");
        t3 = new Tarjeta("Sprint 1");
        
        lU2.addTarjeta(t2);
        lU2.addTarjeta(t3);
        lU1.addTarjeta(t1);
        tU2.addLista(lU1);   
        tU2.addLista(lU2); 
        u2.addTablero(tU2);
        
        tarjetaRepository.save(t1);
        tarjetaRepository.save(t2);
        tarjetaRepository.save(t3);
        
        listaRepository.save(lU1);
        listaRepository.save(lU2);
        tableroRepository.save(tU2);
        usuarioRepository.save(u2);      
          
    } 
}

       