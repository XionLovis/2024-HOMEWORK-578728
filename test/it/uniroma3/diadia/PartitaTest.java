package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class PartitaTest {

	@Test
	public void testVittoriaSenzaAttrezzi() {
		Partita partita = new Partita();

		assertFalse(partita.vinta());
	}
	
	//Test per il metodo getLabirinto

	@Test
	public void testGetLabirinto_NonNullo() {
		Partita partita = new Partita();
		Labirinto labirinto = partita.getLabirinto();
		
		assertNotNull(labirinto);
		assertNotNull(labirinto.getStanzaCorrente());
	}
	
	@Test
	public void testGetLabirinto_Personalizzato() {
		Partita partita = new Partita();
		Labirinto labirinto = new Labirinto();
		
		partita.setLabirinto(labirinto);
		assertSame(labirinto, partita.getLabirinto());
	}

	//Test per il metodo isFinita
	
	@Test
    public void testIsFinita_IniziataNonFinita() {
		Partita partita = new Partita();
		
        assertFalse(partita.isFinita());
    }
	
	@Test 
	public void testIsFinita_Vinta() {
		Partita partita = new Partita();
		Labirinto labirinto = new Labirinto();
		
		labirinto.setStanzaCorrente(labirinto.getStanzaVincente());
		partita.setLabirinto(labirinto);
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinita_SenzaCfu() {
		Partita partita = new Partita();
		Giocatore giocatore = new Giocatore();
		
		giocatore.setCfu(0);
		partita.setGiocatore(giocatore);
		assertTrue(partita.isFinita());
	}
	
	//Test per il metodo setFinita
	
	@Test
	public void testSetFinita_AppenaIniziata() {
		Partita partita = new Partita();
		
		partita.setFinita();
		assertTrue(partita.isFinita());
	}

}
