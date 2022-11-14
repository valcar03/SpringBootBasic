package cl.generation.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// se usa el controlador en aquellos objetos que necesitan los 4 
//operaciones básicas de la programación

@Controller // la utilizamos para la comunicación interna de los componentes
@RequestMapping("/usuario")
public class UsuarioController {

	// http://localhost:9080/
	@RequestMapping("/")//capturamos las rutas
		public String getUsuario () {
		System.out.println("metodo de obtener usuario");
		return "index.jsp";
		}
	// http://localhost:9080/home
	@RequestMapping("/home")
	public String home () {
		System.out.println("en el metodo home");
		return "Home";
	}
		// http://localhost:9080/vale/carcamo
		@RequestMapping("/vale/carcamo")
	public String vcarcamo () {
		System.out.println("en el metodo nombre");
		return "vcarcamo";
	}
	
}
