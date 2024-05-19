package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.*;

public class GiocatoreTest {
	
	Giocatore giocatore = new Giocatore();
	
	@Test
	public void testGetCfuDeafult() {
		assertEquals(20, giocatore.getCfu());
	}
	
	@Test
	public void testSetCfu() {
		giocatore.setCfu(3);
		
		assertEquals(3, giocatore.getCfu());
	}
	
	@Test
	public void testGetBorsaDefaul() {
		assertNotNull(giocatore.getBorsa());
	}

}
