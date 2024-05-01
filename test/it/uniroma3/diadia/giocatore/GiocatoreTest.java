package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {

	@Test
	public void testGetBorsa() {
		Giocatore giocatore = new Giocatore();

		assertNotNull(giocatore.getBorsa());
	}
	
	@Test
	public void testSetCfu() {
		Giocatore giocatore = new Giocatore();
		Attrezzo lighAttrezzo = new Attrezzo("Penna", 1);
		Attrezzo heavyAttrezzo = new Attrezzo("Libro", 5);
		
		giocatore.setCfu(15);
		assertEquals(15, giocatore.getCfu());
	}
	
	@Test 
	public void testGetCfu() {
		Giocatore giocatore = new Giocatore();

		assertEquals(20, giocatore.getCfu());
	}

}
