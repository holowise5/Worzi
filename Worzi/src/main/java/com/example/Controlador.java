package com.example;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lista.Lista;
import com.example.lista.ListaRepository;
import com.example.tablero.Tablero;
import com.example.tablero.TableroRepository;
import com.example.tarjeta.Tarjeta;
import com.example.tarjeta.TarjetaRepository;
import com.example.usuario.Usuario;
import com.example.usuario.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

@Controller
public class Controlador {

	int numeroLista = 1;
	private long usuarioActual;
	ArrayList<Lista> listasGlobal = new ArrayList<Lista>();

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private TableroRepository tableroRepository;
	@Autowired
	private ListaRepository listaRepository;
	@Autowired
	TarjetaRepository tarjetaRepository;

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
	
	@PostMapping("/usuario/acceso")
	public String iniciarSesion(Model model, Usuario usuario, HttpSession sesion)
	{
		/*
		if(usuario.getNombreUsuario().equals("") || usuario.getContrasenya().equals("") || usuario.getEmail().equals(""))
		{
			datosIncorrectosIni = true;
			model.addAttribute("datosIncorrectosIni", datosIncorrectosIni);
			
			return "error";
		}
		*/
		Optional<Usuario> opt = usuarioRepository.findByNombreUsuarioAndContrasenyaAndEmail(usuario.getNombreUsuario(), usuario.getContrasenya(), usuario.getEmail());
		if(opt.isEmpty()) {
			return "usuarioNoExiste";
		}
		else {
			Usuario usu = opt.get();
			usuarioActual = usu.getId();
			model.addAttribute("usu", usu);
	//		sesion.setAttribute("usuarioActual", usu);
			return "main";
		}

	}

	@GetMapping("/perfil")
	public String userProfileView(Model model) {
		String username = "";
		
		Optional<Usuario> opt = usuarioRepository.findById(usuarioActual);
		if(opt.isPresent()) {
			Usuario user = opt.get();
			username = user.getNombreUsuario();
		}
		
		model.addAttribute("usuario", username);

		// prueba
		List<Usuario> usuarioActual = usuarioRepository.findAll();
		model.addAttribute("usuario", usuarioActual);

		return "miPerfil";
	}

	@PostMapping("/nuevoUsuario")
	public String registrarse(Model model, @RequestParam String nombreUsuario,
			@RequestParam String email, @RequestParam String contrasenya) {

		Usuario usuario = new Usuario(nombreUsuario, email, contrasenya);
		usuarioRepository.save(usuario);
		usuarioActual = usuario.getId();
		model.addAttribute("usu", usuario);
		model.addAttribute("nombreUsuario", usuario.getNombreUsuario());
			
		Tablero t = new Tablero("Tablero1", usuario);
		usuario.addTablero(t);
		tableroRepository.save(t);
		return "main";
	}

	@PostMapping("/crearLista")
	public String crearLista(Model model, @RequestParam String nombre) {
	
		Lista l = new Lista(nombre);
		listasGlobal.add(l);
		listaRepository.save(l);
		
		model.addAttribute("listasGlobal", listasGlobal);
		
		return "main";
	}
	
	@GetMapping("/crearTarjeta")
	public String verTarjeta(Model model) {
		return "GetTarjeta";
	}

	@PostMapping("/Tarjeta")
	public String addTarjeta(Model model, @RequestParam String nombre,
			@RequestParam(required=false) String fechaFin , @RequestParam(required=false) String descripcion) {

		model.addAttribute("nombre", nombre);
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
