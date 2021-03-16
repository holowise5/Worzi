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
        Tablero tU1 = new Tablero("Tablero lista compra Usuario1", true, "fondo.jpg", "Lista de la compra", u1);
        Lista lU1 = new Lista("Lista compra Mercadona");
        Tarjeta t1 = new Tarjeta("Arroz");
        Tarjeta t2 = new Tarjeta("Pollo");
        Tarjeta t3 = new Tarjeta("Patatas");
        lU1.addTarjeta(t1);
        lU1.addTarjeta(t2);
        lU1.addTarjeta(t3);
        tU1.addLista(lU1);        
        u1.addTablero(tU1);
/*        
        usuarioRepository.save(u1);
        tableroRepository.save(tU1);
        listaRepository.save(lU1);
        tarjetaRepository.save(t1);
        tarjetaRepository.save(t2);
        tarjetaRepository.save(t3);
*/
/*
        Producto p1 = new Producto("Barras paralelas", "Crossfit", 40.5F, 5,
                "Barras paralelas",
                "https://contents.mediadecathlon.com/p1103588/k$5cc7c279f32cbbd44a5abc4ab065cd54/sq/Barras+paralelas+para+dips+cross+training+musculaci+n+training+station+100.jpg");

        Producto p2 = new Producto("Balón medicinal 3KG", "Mancuernas", 10.65F, 3,
                "Balon medicinal 3KG",
                "https://contents.mediadecathlon.com/p1175605/k$26172214da5a9910dd5ab780e42ed8a0/sq/BAL+N+MEDICINAL+3+kg+Di+metro+22+cm+AMARILLO.jpg");

        Producto p3 = new Producto("Chaleco de 5KG", "Mancuernas", 30.5F, 100,
                "Chaleco lastrado con pesas de 5KG",
                "https://contents.mediadecathlon.com/p1643571/k$3c00962c129eb3e87475fd6769961ebd/sq/Chaleco+lastrado+cross+training+musculaci+n+5+kg.jpg");
        
        Producto p4 = new Producto("Set de mancuernas", "Mancuernas", 40.0F, 50,
                "Set de mancuernas roscadas de 20KG",
                "https://contents.mediadecathlon.com/p1183101/k$28bf0f41482fecbf3eb6a50bb405059a/sq/Kit+mancuernas+musculaci+n+20+kg+de+rosca.jpg");
        
        Producto p5 = new Producto("Muñequera", "Material Crossfit", 5.0F, 5,
                "Muñequeras capaces de mantener rigidez en la muñeca para ejercicios de pino o barra",
                "https://contents.mediadecathlon.com/p1748366/k$2313dfd5c5758634ef14b43b1f2fa52b/sq/MU+EQUERAS+MUSCULACI+N+CROSSTRAINING+AZUL.jpg");
       
        

        
        productoRepository.save(p1);
        productoRepository.save(p2);
        productoRepository.save(p3);
        productoRepository.save(p4);
        productoRepository.save(p5);
       


     LocalDate localDate = java.time.LocalDate.now();
        Date date = java.sql.Date.valueOf(localDate);

        Resena r1 = new Resena(p1, u1, date, "Buen producto");
        Resena r2 = new Resena(p2, u2, date, "Buen producto");
        Resena r3 = new Resena(p1, u2, date, "Bueno, pero no mucho");
       
        resenaRepository.save(r1);
        resenaRepository.save(r2);
        resenaRepository.save(r3);
        

        List<Producto> l1 = new ArrayList<>();
        l1.add(p1);
        l1.add(p2);

        List<Producto> l2 = new ArrayList<>();
        l2.add(p3);
      

        List<Producto> l3 = new ArrayList<>();
        l3.add(p3);

        Pedido o1 = new Pedido(u1, date, l1);
        Pedido o2 = new Pedido(u2, date, l2);
        Pedido o3 = new Pedido(u1, date, l3);
        Pedido o4 = new Pedido(u2, date, l3);

        pedidoRepository.save(o1);
        pedidoRepository.save(o2);
        pedidoRepository.save(o3);
        pedidoRepository.save(o4);


        Promocion pr1 = new Promocion(30);
        pr1.setProducto(p3);

        promocionRepository.save(pr1);
*/ 
    } 
}

       