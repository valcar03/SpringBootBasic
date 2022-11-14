package cl.generation.web.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // convertir en entidad
@Table(name="Autos")

public class Auto {
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	private String marca;
	private String color;
	
	public Auto() {
		super();
		
	}

	public Auto(long id, String marca, String color) {
		super();
		this.id = id;
		this.marca = marca;
		this.color = color;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	
}
