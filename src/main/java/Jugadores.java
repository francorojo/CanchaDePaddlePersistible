import javax.persistence.*;

@Entity
public class Jugadores {
	@Id
	@GeneratedValue
	Integer id_jugador; //PK

	String nombre;
	String apellido;
	String domicilio;
	Integer nacimiento;

	//@Transient
	@OneToOne
	Paletas paleta; //FK
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido(String nombre) {
		this.apellido = nombre;
	}
	
	public void setDomicilio(String nombre) {
		this.domicilio = nombre;
	}
	
	public void setNacimiento(Integer dia) {
		this.nacimiento = dia;
	}
	
	public void setPaleta(Paletas paleta) { 
		this.paleta = paleta; 
	}
	
	public int getId() {
		return id_jugador;
	}
}
