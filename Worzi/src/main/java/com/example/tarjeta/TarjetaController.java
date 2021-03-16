package com.example.tarjeta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lista.Lista;
import com.example.lista.ListaRepository;




@Controller
public class TarjetaController {
int numeroLista = 1;

    @Autowired
    private ListaRepository listaRepository;
 
    @Autowired
    TarjetaRepository tarjetaRepository;
    
    
    
	  @GetMapping("/crearTarjeta")
	    public String userProfileView(Model model) {


	        return "GetTarjeta";
	    }
	  	 	
	    @PostMapping("/Tarjeta")
	    public String registrarse(Model model, @RequestParam String nombre,
	                              @RequestParam String fechaFin,@RequestParam String descripcion) {
	    	
	    	
	        model.addAttribute("nombre",nombre);
	        model.addAttribute("fecha", fechaFin);
	        model.addAttribute("descripcion", descripcion);
	        Lista lista = new Lista("Lista "+numeroLista);
	        Tarjeta t = new Tarjeta(nombre, fechaFin, descripcion);
	       
	       model.addAttribute("tarjeta", t);
	       lista.addTarjeta(t);
	       
	       List<Tarjeta> tar = tarjetaRepository.findByNombre(nombre);
	       model.addAttribute("tarjeta", tar);
	       
	       // model.addAttribute("lista", lista);
	      
	        return "main";
	    }
	    
		 
	
	    @GetMapping("/")
	    public String main(Model model) {
	    
	        return "pagSesion";
	    }
	    
	    
	    
    
    
}
