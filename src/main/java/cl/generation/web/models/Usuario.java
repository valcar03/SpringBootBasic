package cl.generation.web.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity // convertir en entidad
@Table(name="usuarios") //se va a relacionar con la tabla usuario de 
						//la base de datos

public class Usuario { //todos los objetos van con mayúscula
	
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	@NotNull 
	@Size(min=3, max= 15)
	private String nombre;
	@NotNull 
	private String correo;
	@NotNull 
 	private String password;
	@Transient //la siguiente columna no sea considerada en la creación
				// de la tabla
	private String password2;
	private String  nick;
	@Range(min= 40, max=300, message= "peso fuera de rango")
	private Float peso;
	@Column(updatable=false)
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Usuario() {
		super();
	}
	public Usuario(long id, String nombre, String correo, String password, String password2, String nick) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		this.password2 = password2;
		this.nick = nick;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	//atributos de control
	 @PrePersist //agregar a la columna la fecha antes de insertar
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	 @PreUpdate //actualizar el atributo de created
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	
	
}
