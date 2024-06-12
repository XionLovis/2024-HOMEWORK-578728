package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	private Stanza stanza;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() throws Exception {
		stanzaBloccata = new StanzaBloccata("StanzaBloccata", Direzione.ovest, "grimaldello");
		stanza = new Stanza("Stanzetta");
		attrezzo = new Attrezzo("grimaldello", 1);
		stanzaBloccata.impostaStanzaAdiacente(Direzione.ovest, stanza);
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente(Direzione.ovest));
	}

	@Test
	public void testStanzaAdiacenteDirezioneSbloccata() {
		stanzaBloccata.addAttrezzo(attrezzo);
		assertEquals(stanza, stanzaBloccata.getStanzaAdiacente(Direzione.ovest));
	}
	
	@Test
	public void testGetDescrizioneDirezioneBloccata() {
		String description = "Stanza bloccata nella direzione: ovest" + "\nPrendi il grimaldello e posalo nella stanza";
		assertEquals(description, stanzaBloccata.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneDirezioneSbloccata() {
		stanzaBloccata.addAttrezzo(attrezzo);
		assertEquals(stanzaBloccata.toString(), stanzaBloccata.getDescrizione());
	}
	
	
}
