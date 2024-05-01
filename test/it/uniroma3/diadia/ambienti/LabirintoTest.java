package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {

	@Test
	public void testGetStanzaVincete() {
		Labirinto labirinto = new Labirinto();
		Stanza stanzaVincente = labirinto.getStanzaVincente();
		
		assertNotNull(stanzaVincente);
		assertEquals("Biblioteca", stanzaVincente.getNome());
	}
	
	@Test
	public void testGetStanzaCorrente() {
		Labirinto labirinto = new Labirinto();
		Stanza stanzaCorrente = labirinto.getStanzaCorrente();
		
		assertNotNull(stanzaCorrente);
		assertEquals("Atrio", stanzaCorrente.getNome());
	}
	
	@Test 
	public void testSetStanzaCorrente() {
		Labirinto labirinto = new Labirinto();
		Stanza stanzaCorrente = new Stanza("Nuova stanza");
		
		labirinto.setStanzaCorrente(stanzaCorrente);
		assertEquals(stanzaCorrente, labirinto.getStanzaCorrente());
	}

}
