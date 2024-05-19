package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.*;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

	private Partita partita;
	private Attrezzo attrezzo;
	private Attrezzo attrezzoPesante;
	private Comando comando;
	private IO io;
	Labirinto labirinto;
	
	@Before 
	public void setUp() throws Exception {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("chiave", 1)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.getLabirinto();
		partita = new Partita(labirinto);
		attrezzo = new Attrezzo("palla", 2);
		attrezzoPesante = new Attrezzo("roccia", 11);
		comando = new ComandoPrendi();
		io = new IOConsole();
		comando.setIo(io);
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	public boolean attrezzoPresente(String attrezzo) {
		
		if (partita.getStanzaCorrente().getAttrezzo(attrezzo) == null) {
			return false;
		}
		
		return true;
	}
	
	@Test
	public void testAttrezzoPreso() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("chiave");
		comando.esegui(partita);
		
		assertFalse(attrezzoPresente("chiave"));
	}
	
	@Test
	public void testAttrezzoNonPresente() {
		comando.setParametro("chiave");
		comando.esegui(partita);
		
		assertFalse(attrezzoPresente("chiave"));
	}
	
	@Test
	public void testAttrezzoPesante() {
		partita.getStanzaCorrente().addAttrezzo(attrezzoPesante);
		comando.setParametro("roccia");
		comando.esegui(partita);
		
		assertTrue(attrezzoPresente("roccia"));
	}

}
