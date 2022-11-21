package cl.generation.web.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;// bigint

	@NotNull
	@Size(min = 3, max = 15, message = "Error en el ingreso del nombre")
	private String nombre;

	@NotNull
	private String correo;
	@NotNull
	private String password;
	

	//relacion OneToOne
	@JsonIgnore
	@OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Auto auto;

	//relaciones OnotoMany
	@JsonIgnore
	@OneToMany (mappedBy = "usuario",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Direccion> direcciones;
	//Mapear se refiere a establecer el nombre de la ruta
	// CascadeType es opcional, sirve para, si tu eliminas un dato, se elimina toda la columna
	//el FetchType nos va a traer la información; Eager todos los datos y el lazy da lo justo y necesario 
	
	
	//Many to many --> dos 
	
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(
			name="roles_usuarios",//nombre de la tabla relacional
			joinColumns = @JoinColumn(name="usuario_id"),
			inverseJoinColumns = @JoinColumn(name="rol_id")
			)
		private List<Rol> roles;
	
	@Transient
	private String password2;

	private String nick;

	@Range(min = 40, max = 300, message = "Peso fuera de rango")
	private Float peso;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	

	public Usuario() {
		super();
	}

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

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	// atributos de control 
	// agregar a la columna la fecha antes de insertar
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}