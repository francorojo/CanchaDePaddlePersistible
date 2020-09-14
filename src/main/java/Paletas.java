import javax.persistence.*;

@Entity
public class Paletas {
	@Id
	@GeneratedValue
	Integer cod_paleta; //PK
	String nombre;
	Integer grosor;

	//@Transient
	@OneToOne
	Color color; //FK

	//@Transient
	@ManyToOne
	Constructor constructor; //FK
	
	public void agregarNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarGrosor(Integer grosor) {
		this.grosor = grosor;
	}
	
	public void agregarColor(Color color) {
		this.color = color;
	}
	public void agregarConstructor(Constructor constructor) {
		this.constructor = constructor;
	}
	
}
