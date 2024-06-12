package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

public class AbstractComandoTest {
	
	ConcreteComando cc;
	Partita partita;
	
	@Before
	public void setUp() throws Exception {
		cc = new ConcreteComando();
		partita = new Partita(Labirinto.newBuilder("labirinto.txt").getLabirinto());
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testConcreteComandoGetNome() {
		assertNotEquals("AbstractComando", cc.getNome());
		assertEquals("ConcreteComando", cc.getNome());
	}
	
	@Test
	public void testConcreteComandoEsegui() {
		cc.esegui(partita);
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testConcreteComandoGetIo() {
		cc.setIo(new IOConsole(new Scanner(System.in)));
		assertNotNull(cc.getIo());
	}
	
	@Test
	public void testConcreteComandoParametro() {
		cc.setParametro("tarantola");
		assertNotNull(cc.getParametro());
	}

}
