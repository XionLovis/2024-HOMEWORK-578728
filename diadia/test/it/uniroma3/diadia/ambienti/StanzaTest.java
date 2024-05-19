package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	Stanza stanza1;
	Stanza stanza2;
	Attrezzo martello;

	@Before
	public void setUp() throws Exception {
		stanza1 = new Stanza("prima");
		stanza2 = new Stanza("seconda");
		martello = new Attrezzo("martello", 23);
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetStanzaAdiacente() {
		assertNull(stanza1.getStanzaAdiacente("est"));
	}
	
	@Test
	public void testImpostaStanzaAdiacente() {
		stanza1.impostaStanzaAdiacente("est", stanza2);
		assertEquals(stanza2, stanza1.getStanzaAdiacente("est"));
	}
	
	@Test
	public void testAddAttrezzo() {
		assertTrue(stanza1.addAttrezzo(martello));
	}

}
