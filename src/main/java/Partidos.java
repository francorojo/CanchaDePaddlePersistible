import java.util.ArrayList;

import javax.persistence.*;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import antlr.collections.List;

@Entity
public class Partidos {

	@Id @GeneratedValue
	Integer id_partido; //PK

	Integer inicio_partido;
	Integer fin_partido;


	//@Transient
	@ManyToOne
	Cancha id_cancha; //FK

	//@Transient
	@ManyToOne
	Color cod_color_cancha; //FK

    //@Transient
	@ManyToOne
	Jugadores id_jugador_responsable; //FK
}
