package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoVaiTest {
	
	private Stanza stanza1;
	private Stanza stanza2;
	private Comando comando;
	private Partita partita1;
	private Partita partita2;
	
	List<String> righeDaLeggere1;
	List<String> righeDaLeggere2;
	
	Labirinto labirinto1;
	Labirinto labirinto2;
	private IO io;
	
	@Before
	public void setUp() throws Exception {
		io = new IOConsole();
		stanza1 = new Stanza("Aula N11");
		stanza2 = new Stanza("Aula N10");
		comando = new ComandoVai();
		
		labirinto1 = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("chiave", 1)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.getLabirinto();
		
		partita1 = new Partita(labirinto1);
		comando.setIo(io);
		righeDaLeggere1 = new ArrayList<>();
		righeDaLeggere2 = new ArrayList<>();
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVaiDirezioneEsistente() {
		partita1.setStanzaCorrente(stanza1);
		stanza1.impostaStanzaAdiacente("sud-ovest", stanza2);
		comando.setParametro("sud-ovest");
		comando.esegui(partita1);
		
		assertEquals(stanza2, partita1.getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneInesistente() {
		partita1.setStanzaCorrente(stanza1);
		stanza1.impostaStanzaAdiacente("sud-ovest", stanza2);
		comando.setParametro("in culonia");
		comando.esegui(partita1);
		
		assertNotEquals(stanza2, partita1.getStanzaCorrente());
	}
	
	@Test
	public void testPartitaConComandoVai() {
		righeDaLeggere1.add("vai nord");
		
		IOSimulator io = Fixture.creaSimulazionePartitaGiocaFacile(righeDaLeggere1);
		
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Biblioteca", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Hai vinto!", io.nextMessaggio());
	}

	@Test
	public void testPartitaConComandoVaiOvest() {
		righeDaLeggere2.add("vai ovest");
		righeDaLeggere2.add("fine");
		
		IOSimulator io = Fixture.creaSimulazionePartitaGiocaHard(righeDaLeggere2);
		
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Aula N10", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}
	
	@Test
	public void testPartitaConComandoVaiOvestEst() {
		righeDaLeggere2.add("vai ovest");
		righeDaLeggere2.add("vai est");
		righeDaLeggere2.add("fine");
		
		IOSimulator io = Fixture.creaSimulazionePartitaGiocaHard(righeDaLeggere2);
		
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Aula N10", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Atrio", io.nextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}
	
}
