package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	
	private Partita partita;
	private Attrezzo attrezzo;
	private Attrezzo attrezzoPesante;
	private Attrezzo attrezzoNull;
	private Comando comando;
	private IO io;
	
	@Before
	public void setUp() throws Exception {
		partita = new Partita();
		attrezzo = new Attrezzo("martello", 2);
		attrezzoPesante = new Attrezzo("roccia", 11);
		attrezzoNull = null;
		comando = new ComandoPrendi();
		io = new IOConsole();
		comando.setIo(io);
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	public boolean attrezzoPresente(String s) {
		Attrezzo[] array = partita.getLabirinto().getStanzaCorrente().getAttrezzi();
		
		for (Attrezzo a : array) {
			if (a != null && s.equals(a.getNome())) {
				return true;
			}
		}
		
		return false;
	}

	@Test
	public void testAttrezzoPreso() {
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("martello"));
	}
	
	@Test
	public void testAttrezzoNonPresente() {
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("martello"));
	}
	
	@Test
	public void testAttrezzoPresente() {
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoPesante);
		comando.setParametro("roccia");
		comando.esegui(partita);
		assertTrue(attrezzoPresente("roccia"));
	}

}
