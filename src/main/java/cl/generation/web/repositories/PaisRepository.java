package cl.generation.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.generation.web.models.Pais;


@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{
	//extends significa que va a herededar de JpaRepository, una interface ya creada, 
	//métodos útiles, conectarnos con la base de datos
	
	//-->ApiRestController

}
