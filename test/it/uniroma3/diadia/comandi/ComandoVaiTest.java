package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoVaiTest {
	
	private Stanza stanza1;
	private Stanza stanza2;
	private Comando vai;
	private Partita partita;
	
	@Before
	public void setUp() throws Exception {
		stanza1 = new Stanza("aula 1");
		stanza2 = new Stanza("aula 2");
		vai = new ComandoVai();
		partita = new Partita();
		vai.setIo(new IOConsole());
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVaiNull() {
		partita.getLabirinto().setStanzaCorrente(stanza1);
		vai.esegui(partita);
		assertEquals(stanza1, partita.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneEsistente() {
		partita.getLabirinto().setStanzaCorrente(stanza1);
		stanza1.impostaStanzaAdiacente("sud-ovest", stanza2);
		vai.setParametro("sud-ovest");
		vai.esegui(partita);
		assertEquals(stanza2, partita.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneInesistente() {
		partita.getLabirinto().setStanzaCorrente(stanza1);
		stanza1.impostaStanzaAdiacente("sud-ovest", stanza2);
		vai.setParametro("in fondo a sinistra");
		vai.esegui(partita);
		assertNotEquals(stanza2, partita.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testPartitaConComandoVai() {
		String[] righeDaLeggereStrings = {"vai nord", "fine"};
		IOSimulator io = Fixture.creaSimulazionePartitaEGioca(righeDaLeggereStrings);
		
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Biblioteca", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Hai vinto!", io.nextMessaggio());
	}
}
