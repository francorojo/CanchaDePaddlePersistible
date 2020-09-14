import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

public class ContextTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

	@Test
	public void contextUp() {
		assertNotNull(entityManager());

	}

	@Test
	public void contextUpWithTransaction() throws Exception {
		withTransaction(() -> {});
	}

	@Test
	public void pruebaPersistirUnJugador(){ //Vamos a persistir a un jugador a la base de datos, pero antes creemos a los objetos necesarios
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		
		//Primero creo a un color y a un constructor, asi luego la paleta puede referenciar a los mismos
		
		Color rojo = new Color();
		rojo.agregarDescripcion("Rojo Pasion");
		entityManager.persist(rojo);
		
		Constructor bob = new Constructor();
		bob.agregarNombre("Bob - El Constructor");
		bob.agregarDomicilio(1010);
		entityManager.persist(bob);
		
		//Ahora puedo crear la paleta
		
		Paletas paleta = new Paletas();
		paleta.agregarNombre("Paleta de fuego");
		paleta.agregarGrosor(100);
		paleta.agregarColor(rojo);
		paleta.agregarConstructor(bob);
		entityManager.persist(paleta);
		
		//Y ahora si al jugador
		
		Jugadores mad = new Jugadores();
		mad.setNombre("Nico");
	    mad.setApellido("Bonaparte");
		mad.setDomicilio("Francia");
		mad.setNacimiento(1998);
		mad.setPaleta(paleta);
		entityManager.persist(mad);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
		
		//Ahora deberian estar los objetos persistidos en la base de datos y el test en verde
	}
}
