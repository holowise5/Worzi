package com.example.usuario;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping("/registrarse")
	public String registrarse()
	{
		return "registrarse";
	}
	
	@GetMapping("/iniciarSesion")
	public String iniciarSesion()
	{
		return "iniciarSesion";
	}

    @GetMapping("/perfil")
    public String userProfileView(Model model) {

        List<Usuario> users = usuarioRepository.findAll();
        Usuario user = users.get(0);
        model.addAttribute("usuario", user);
        
        // prueba
        List<Usuario> usuarioActual = usuarioRepository.findAll();
        model.addAttribute("usuario", usuarioActual);
        
        return "miPerfil";
    }

    @PostMapping("/nuevoUsuario")
    public String registrarse(Model model, @RequestParam String nombreUsuario,
                              @RequestParam String email,@RequestParam String contrasenya) {

        Usuario usuario = new Usuario(nombreUsuario, email, contrasenya);
        usuarioRepository.save(usuario);
        model.addAttribute("nombreUsuario", usuario.getNombreUsuario());

        return "main";
    }
}
