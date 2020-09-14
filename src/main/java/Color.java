import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Color {
	@Id
	@GeneratedValue
	Integer cod_color; //PK

	String descripcion;
	
	public void agregarDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}

