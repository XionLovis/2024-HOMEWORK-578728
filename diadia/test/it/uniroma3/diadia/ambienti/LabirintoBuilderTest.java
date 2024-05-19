package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {
	
	LabirintoBuilder labirinto;
	
	@Before
	public void setUp() throws Exception {
		labirinto = new LabirintoBuilder();
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetLabirinto() {
		assertNotNull(labirinto.getLabirinto());
		assertEquals(Labirinto.class, labirinto.getLabirinto().getClass());
	}
	
	@Test
	public void testAddStanza() {
		labirinto.addStanza("stanza");
		Stanza expected = new Stanza("stanza");
		
		assertEquals(expected, labirinto.getNome2stanza().get("stanza"));
	}
	
	@Test
	public void testAddAttrezzoSenzaUltimaStanzaAggiunta() {
		assertEquals(LabirintoBuilder.class, labirinto.addAttrezzo("cacciavite", 3).getClass());
	}

	@Test
	public void testAddAttrezzoConUltimaStanzaAggiunta(){
		labirinto.addStanzaIniziale("stanzetta").addAttrezzo("cacciavite", 3);
		Attrezzo expected = new Attrezzo("cacciavite", 3);
		
		assertEquals(expected, labirinto.getLabirinto().getStanzaCorrente().getAttrezzo("cacciavite"));		
	}
	
	@Test
	public void testAddAttrezzoConStanza() {
		labirinto.addStanza("stanza");
		labirinto.addAttrezzo("cacciavite", 3);
		
		assertTrue(labirinto.getNome2stanza().get("stanza").hasAttrezzo("cacciavite"));
	}
	
}
