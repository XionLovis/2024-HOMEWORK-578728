package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.*;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class FabbricaDiComandiFisarmonicaTest {
	
	private FabbricaDiComandiFisarmonica fabbrica;
	private IO io;
	private Comando comando;
	
	@Before 
	public void setUp() throws Exception {
		io = new IOConsole();
		fabbrica = new FabbricaDiComandiFisarmonica(io);
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testComandoNonValido() {
		comando = new ComandoNonValido();
		
		assertEquals(comando.getNome(), fabbrica.costruisciComando("marico").getNome());
	}
	
	@Test
	public void testComandoConParametro() {
		comando = new ComandoVai();
		comando.setParametro("nord");
		Comando current = fabbrica.costruisciComando("vai nord");
		
		assertEquals(comando.getNome(), current.getNome());
		assertEquals(comando.getParametro(), current.getParametro());
	}
	
	@Test
	public void testComandoSenzaParametro() {
		comando = new ComandoFine();
		
		assertEquals(comando.getNome(), fabbrica.costruisciComando("fine").getNome());
	}

}
