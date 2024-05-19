package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.*;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {
	
	private Partita partita;
	private Attrezzo attrezzo;
	private IO io;
	private Comando comando;
	Labirinto labirinto;
	
	@Before
	public void setUp() throws Exception {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("motosega", 15)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.getLabirinto();
		partita = new Partita(labirinto);
		attrezzo = new Attrezzo("sigaretta", 1);
		comando = new ComandoPosa();
		io = new IOConsole();
		comando.setIo(io);
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAttrezzoPosato() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("sigaretta");
		comando.esegui(partita);
		
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("sigaretta"));
	}
	
	@Test
	public void testAttrezzoPosatoNull() {
		comando.setParametro("martello");
		comando.esegui(partita);
		
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
	}
	
	public void creatoreTroppiAttrezzi() {
		
		for (int i = 0; i < 10; i++) {
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("oggetto" + i, 1));
		}
	}
	
	@Test
	public void testTroppiAttrezzi() {
		this.creatoreTroppiAttrezzi();
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("motosega");
		comando.esegui(partita);
		
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("motosega"));
	}

}
