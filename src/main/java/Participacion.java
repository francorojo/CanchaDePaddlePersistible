import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Participacion implements Serializable{

	@Id
	@ManyToOne
	Jugadores jugador; //PK FK

	@Id
	@ManyToOne
	Partidos partido; //PK FK

	@ManyToOne
	Paletas paleta; //FK
}