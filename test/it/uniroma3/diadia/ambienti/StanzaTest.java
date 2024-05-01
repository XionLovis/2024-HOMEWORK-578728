package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	//Test per il metodo getAttrezzo

	@Test
	public void testGetAttrezzo_stanzaVuota() {
		Stanza vuota = new Stanza("vuota");
		assertNull(vuota.getAttrezzo("inesistente"));
	}

	@Test
	public void testGetAttrezzo_stanzaNonVuota_Presente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo", 0);
		stanza.addAttrezzo(attrezzo);
		assertNotNull(stanza.getAttrezzo("attrezzo"));
	}

	@Test
	public void testGetAttrezzo_stanzaNonVuota_Assente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo", 0);
		stanza.addAttrezzo(attrezzo);
		assertNull(stanza.getAttrezzo("nonPresente"));
	}

	// Test per il metodo getStanzaAdiacente

	@Test
	public void testGetStanzaAdiacente_StanzaCorretta() {
		Stanza stanza = new Stanza("Stanza");
		Stanza adiacenteCorretta = new Stanza("Adiacente corretta");

		stanza.impostaStanzaAdiacente("nord", adiacenteCorretta);
		assertEquals(adiacenteCorretta, stanza.getStanzaAdiacente("nord"));
	}

	@Test
	public void testGetStanzaAdiacente_Sbagliata() {
		// Test per una stanza con una stanza adiacente sbagliata
		Stanza stanza = new Stanza("Stanza");
		Stanza adiacenteCorretta = new Stanza("Adiacente Corretta");

		stanza.impostaStanzaAdiacente("nord", adiacenteCorretta);
		assertNull(stanza.getStanzaAdiacente("sud"));
	}

	@Test
	public void testGetStanzaAdiacente_Null() {
		// Test per una stanza senza stanze adiacenti
		Stanza stanza = new Stanza("Stanza");

		assertNull(stanza.getStanzaAdiacente("nord"));
	}

	// Test per il metodo addAttrezzo

	@Test
	public void testAddAttrezzo_SenzaAttrezzi() {
		// Test per una stanza senza attrezzi
		Stanza stanza = new Stanza("Stanza");

		assertTrue(stanza.addAttrezzo(new Attrezzo("Martello", 2)));
	}

	@Test
	public void testAddAttrezzo_ConAttrezzi() {
		// Test per una stanza con attrezzi
		Stanza stanza = new Stanza("Stanza");
		stanza.addAttrezzo(new Attrezzo("Martello", 2));

		assertTrue(stanza.addAttrezzo(new Attrezzo("Chiave", 1)));
	}

}
