package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoFineTest {
	
	List<String> righeDaLeggere;
	
	@Before
	public void setUp() throws Exception {
		righeDaLeggere = new ArrayList<>();
	}
	
	@After 
	public void tearDown() throws Exception {
	}

	@Test
	public void testPartitaConComandoFine() {
		righeDaLeggere.add("fine");
		
		IOSimulator io = Fixture.creaSimulazionePartitaGiocaFacile(righeDaLeggere);
		
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}

}
