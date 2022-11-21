package cl.generation.web.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity //esto es una anotación, indica que es una entidad
@Table(name="paises")
public class Pais {
	
	//Atributos
	
	@Id //esto es una primary key
	@GeneratedValue (strategy = GenerationType.IDENTITY) //y se incrementa
	private Long id;
	//la base de datos generalmente son muy grandes, así que se trabaja con long para evitar errores
	
	@NotNull
	private String nombre;
	
	private String continente;
	
	private String idioma;
	
	private String capital;
	
//	private Date createdAt;
	
//	private Date updatedAt;
	
	//constructor vacío
	//objetos sin atributos

	public Pais() {
		super();
	}
	
	// constructor lleno

	public Pais(Long id, @NotNull String nombre, String continente, String idioma, String capital) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.continente = continente;
		this.idioma = idioma;
		this.capital = capital;
	}

	//Getters Setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	//-->Repository
	// atributos de control 
	// agregar a la columna la fecha antes de insertar
		//@PrePersist
		//protected void onCreate() {
			//this.createdAt = new Date();
		//}

		//@PreUpdate
		//protected void onUpdate() {
		//	this.updatedAt = new Date();
		//}
	
	
	
	
}
