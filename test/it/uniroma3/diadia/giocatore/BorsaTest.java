package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	@Test
	public void testAddAtrezzo() {
		Borsa borsa = new Borsa(15);
		Attrezzo lightAttrezzo = new Attrezzo("Penna", 1);
		Attrezzo heavyAttrezzo = new Attrezzo("Libro", 10);

		assertTrue(borsa.addAttrezzo(lightAttrezzo));
		assertTrue(borsa.addAttrezzo(heavyAttrezzo));
		assertFalse(borsa.addAttrezzo(new Attrezzo("Zaino", 20)));
	}

	// Test per il metodo getPeso

	@Test
	public void testGetPeso() {
		Borsa borsa = new Borsa(15);
		Attrezzo lightAttrezzo = new Attrezzo("Penna", 1);
		Attrezzo heavyAttrezzo = new Attrezzo("Libro", 10);

		borsa.addAttrezzo(heavyAttrezzo);
		borsa.addAttrezzo(lightAttrezzo);
		assertEquals(11, borsa.getPeso());
	}

	// Test per il metodo removeAttrezzo

	@Test
	public void testRemoveAttrezzo() {
		Borsa borsa = new Borsa(15);
		Attrezzo lightAttrezzo = new Attrezzo("Penna", 1);
		Attrezzo heavyAttrezzo = new Attrezzo("Libro", 10);

		borsa.addAttrezzo(heavyAttrezzo);
		borsa.addAttrezzo(lightAttrezzo);

		assertNotNull(borsa.removeAttrezzo("Penna")); // Rimuove l'attrezzo leggero
		assertNull(borsa.removeAttrezzo("Zaino")); // L'attrezzo non è presente nella borsa
	}

	// Test per il metodo getAttrezzo

	@Test
	public void testGetAttrezzo_BorsaVuota() {
		Borsa borsa = new Borsa();

		assertNull(borsa.getAttrezzo("Chiave"));
	}

	@Test
	public void testGetAttrezzo_Presente() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("Chiave", 2);

		borsa.addAttrezzo(attrezzo);
		assertEquals(attrezzo, borsa.getAttrezzo("Chiave"));

	}

	@Test
	public void testGetAttrezzo_NonPresente() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("Penna", 1);

		borsa.addAttrezzo(attrezzo);
		assertNull(borsa.getAttrezzo("Chiave"));
	}

	// Test per il metodo addAttrezzo

	@Test
	public void testAddAttrezzo_LimitePeso() {
		Borsa borsa = new Borsa(1);
		Attrezzo attrezzo = new Attrezzo("Martello", 2);

		assertFalse(borsa.addAttrezzo(attrezzo));
	}

	@Test
	public void testAddAttrezzo_LimiteAttrezzi() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("Pesante", 10);

		// Riempie la borsa fino al limite di attrezzi
		for (int i = 0; i < 10; i++) {
			borsa.addAttrezzo(attrezzo);
		}

		assertFalse(borsa.addAttrezzo(attrezzo));
	}

	@Test
	public void testAddAttrezzo_BorsaVuota() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("Libro", 2);
		
		assertTrue(borsa.addAttrezzo(attrezzo));
	}
}
