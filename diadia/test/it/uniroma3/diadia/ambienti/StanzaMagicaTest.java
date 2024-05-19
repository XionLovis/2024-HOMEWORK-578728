package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	
	private StanzaMagica stanza;
	private Attrezzo palla;
	private Attrezzo martello;
	private Attrezzo forchetta;
	
	@Before
	public void setUp() throws Exception {
		stanza = new StanzaMagica("stanza");
		palla = new Attrezzo("palla", 22);
		martello = new Attrezzo("martello", 40);
		forchetta = new Attrezzo("forchetta", 4);
	}
	
	@After 
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddAttrezzo() {
		assertTrue(stanza.addAttrezzo(forchetta));
	}
	
	@Test
	public void testModificaAttrezzo() {
		assertTrue(stanza.addAttrezzo(forchetta));
		assertTrue(stanza.addAttrezzo(martello));
		assertTrue(stanza.addAttrezzo(palla));
	}

}
