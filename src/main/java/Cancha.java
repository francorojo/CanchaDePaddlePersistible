import javax.persistence.*;

@Entity
public class Cancha {
	
	@Id
	@GeneratedValue
	Integer id_cancha; //PK

	String nombre;
	Boolean esta_iluminada;

	//@Transient
	@ManyToOne
	Color color; //FK
}

