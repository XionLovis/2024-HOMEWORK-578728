package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	
	Labirinto labirinto;
	Partita partita;
	Stanza stanza;
	
	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();

		partita = new Partita(labirinto);
		stanza = new Stanza("Stanza");
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", partita.getLabirinto().getStanzaVincente().getNome());
	}
	
	@Test
	public void testSetStanzaCorrente() {
		partita.getLabirinto().setStanzaCorrente(stanza);
		assertEquals(stanza, partita.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testIsFinita() {
		assertFalse(partita.isFinita());
	}

}
