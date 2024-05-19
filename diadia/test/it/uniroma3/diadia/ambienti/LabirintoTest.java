package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	
	Labirinto labirinto;
	Stanza biblioteca;
	Stanza DS1;
	
	@Before
	public void setUp() {
		labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		biblioteca = new Stanza("Biblioteca");
		DS1 = new Stanza("DS1");
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	public void testSetStanzaCorrente() {
		labirinto.setStanzaCorrente(DS1);
		assertEquals(DS1, labirinto.getStanzaCorrente());
	}
	
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", labirinto.getStanzaCorrente().getNome());
	}

}
