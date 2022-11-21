package cl.generation.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.generation.web.models.Pais;
import cl.generation.web.repositories.PaisRepository;

@Service
public class PaisServiceImpl implements PaisService {

	@Autowired //el Autowired sirve para inyectar
	private PaisRepository paisRepository;
	//acceso a los métodos de país Repository
	
	@Override //sobre escribir
	public Pais guardarPais(Pais pais) {
// guárdame el país y retórnamelo xfa
		return paisRepository.save(pais);
	}

}
