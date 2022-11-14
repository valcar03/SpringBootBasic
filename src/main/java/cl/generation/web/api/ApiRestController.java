package cl.generation.web.api;

import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiRestController {

	// http://localhost:9080/api/hola
	@RequestMapping("/hola")
	public String hola() {
		return "hola api";
	}

// para ruta dinámica
	// http://localhost:9080/api/edad/19
	@RequestMapping("/edad/{edad}")
	public String rutaDinamica(@PathVariable("edad") int edad) {
		return "capturando edad:" + edad;
	}

	// http://localhost:9080/api/nombre/luisa
	@RequestMapping("/nombre/{nombre}")
	public String capturarNombre(@PathVariable("nombre") String nombre) {
		return "El nombre capturado es: " + nombre;
	}
	
	// http://localhost:9080/api/14/noviembre/2022
	@RequestMapping("/{dia}/{mes}/{año}")
	public String rutaDinamica(@PathVariable("dia") int dia, @PathVariable("mes") String mes, @PathVariable("año") int año) {
		return "capturando fecha: "+dia + " " + mes+ " " + año;
	}

}
