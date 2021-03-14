package com.example.tarjeta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lista.ListaRepository;
import com.example.usuario.Usuario;

import java.util.List;

@Controller
public class TarjetaController {

    @Autowired
    private ListaRepository tarjetaRepository;
    
 

    
	  @GetMapping("/crearTarjeta")
	    public String userProfileView(Model model) {


	        return "GetTarjeta";
	    }
	  	 	
	    @PostMapping("/Tarjeta")
	    public String registrarse(Model model, @RequestParam String nombre,
	                              @RequestParam String fecha,@RequestParam String descripcion) {

	    	
	        model.addAttribute("nombre",nombre);
	        model.addAttribute("fecha", fecha);
	        model.addAttribute("descripcion", descripcion);
//	       new Tarjeta(nombre, fecha, descripcion, lista);
	        
	        return "main";
	    }
	    
		 
	
	    @GetMapping("/")
	    public String main(Model model) {
	    
	        return "main";
	    }
	    
	    
	    
    
    
}
