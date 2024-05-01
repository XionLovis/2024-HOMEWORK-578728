package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	
	private StanzaBloccata stanzab;
	private Stanza stanza;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() throws Exception {
		stanzab = new StanzaBloccata("StanzaBloccata", "ovest", "grimaldello");
		stanza = new Stanza("Stanzetta");
		attrezzo = new Attrezzo("grimaldello", 1);
		stanzab.impostaStanzaAdiacente("ovest", stanza);
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(stanzab, stanzab.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		stanzab.addAttrezzo(attrezzo);
		assertEquals(stanza, stanzab.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testGetDescrizioneDirezioneBloccata() {
		String e = "Stanza bloccata nella direzione: ovest" + "\n Prendi il grimaldello e posalo nella stanza";
		assertEquals(e, stanzab.getDescrizione());
	}

}
