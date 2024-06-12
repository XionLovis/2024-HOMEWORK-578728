package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	private StanzaBuia stanza;
	private Attrezzo attrezzoLuminoso;
	
	@Before
	public void setUp() throws Exception {
		stanza = new StanzaBuia("StanzaBuia", "lanterna");
		attrezzoLuminoso = new Attrezzo("lanterna", 3);
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDescrizioneConAttrezzo() {
		stanza.addAttrezzo(attrezzoLuminoso);
		assertEquals(stanza.toString(), stanza.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		String description = "qui c'è un buio pesto";
		assertEquals(description, stanza.getDescrizione());
	}

}
