package cl.generation.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.web.models.Pais;
import cl.generation.web.services.PaisServiceImpl;

@RestController
@RequestMapping("/pais")
//el RequestMappping es la ruta que se implementa luego
public class PaisRestController {
//interfaz de programación de aplicaciones, está esperando a que
//hagamos la consulta para salir del rest
	//-->Ahora por los Services
	
	@Autowired
	private PaisServiceImpl paisServiceImpl;
	
	@RequestMapping("/guardar")
	public Pais guardarPais(@RequestBody Pais pais) {
		
		return paisServiceImpl.guardarPais(pais);
	//es  <pais> y no string pq en el serviceimpl dice q es tipo pais
//en el postman se implementan de muchas formas datos, el Requestbody es un método para 
//guardar información
	}
}
