package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class BorsaTest {
	
	Borsa borsa1;
	Borsa borsa2;
	Borsa borsa3;
	
	Attrezzo motosega;
	Attrezzo martello;
	Attrezzo scalpello;
	Attrezzo pcFisso;
	Attrezzo laptop;
	Attrezzo palla;
	Attrezzo spatola;
	
	@Before 
	public void setUp() throws Exception {
		borsa1 = new Borsa();
		borsa2 = new Borsa();
		borsa3 = new Borsa();
		
		motosega = new Attrezzo("motosega", 5);
		martello = new Attrezzo("martello", 3);
		scalpello = new Attrezzo("scalpello", 1);
		pcFisso = new Attrezzo("pc fisso", 13);
		laptop = new Attrezzo("laptop", 4);
		palla = new Attrezzo("palla", 2);
		spatola = new Attrezzo("spatola", 1);
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	public boolean controllaList(List<?> list1, List<?> list2) {
		if (list1.size() != list2.size()) {
			return false;
		}
		
		for (int i = 0; i < list1.size(); i++) {
			if (!list1.get(i).equals(list2.get(i))) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean controllaSet(Set<Attrezzo> set1, Set<Attrezzo> set2) {
		if (set1.size() != set2.size()) {
			return false;
		}
		
		Iterator<Attrezzo> iterator1 = set1.iterator();
		Iterator<Attrezzo> iterator2 = set2.iterator();
		
		while (iterator1.hasNext() && iterator2.hasNext()) {
			if (!iterator1.next().equals(iterator2.next())) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean controllaMap(Map<Integer, Set<Attrezzo>> map1, Map<Integer, Set<Attrezzo>> map2) {
		if (map1.size() != map2.size()) {
			return false;
		}
		
		Iterator<Integer> iterator1 = map1.keySet().iterator();
		Iterator<Integer> iterator2 = map2.keySet().iterator();
		
		while (iterator1.hasNext() && iterator2.hasNext()) {
			if (!this.controllaSet(map1.get(iterator1.next()), map2.get(iterator2.next()))) {
				return false;
			}
		}
		
		return true;
	}

	@Test
	public void testAddAttrezzoPesoMinoreDieci() {
		assertTrue(borsa1.addAttrezzo(scalpello));
	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDieci() {
		assertFalse(borsa1.addAttrezzo(pcFisso));
	}
	
	@Test
	public void testGetPeso() {
		borsa1.addAttrezzo(laptop);
		assertEquals(laptop, borsa1.getAttrezzo("laptop"));
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziPesoUguale() {
		borsa1.addAttrezzo(scalpello);
		borsa1.addAttrezzo(spatola);
		
		Set<Attrezzo> expected = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		expected.add(scalpello);
		expected.add(spatola);
		
		assertArrayEquals(expected.toArray(), borsa1.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoDivero() {
		borsa2.addAttrezzo(palla);
		borsa2.addAttrezzo(martello);
		
		Set<Attrezzo> expected = new TreeSet<>();
		expected.add(martello);
		expected.add(palla);
		
		System.out.println(borsa2.getSortedSetOrdinatoPerPeso().toString());
		assertArrayEquals(expected.toArray(), borsa2.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoStessoPeso() {
		borsa2.addAttrezzo(scalpello);
		borsa2.addAttrezzo(spatola);
		
		List<Attrezzo> expected = new ArrayList<>();
		expected.add(scalpello);
		expected.add(spatola);
		
		assertTrue(this.controllaList(expected, borsa2.getContenutoOrdinatoPerPeso()));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoDiverso() {
		borsa2.addAttrezzo(laptop);
		borsa2.addAttrezzo(palla);
		
		List<Attrezzo> expected = new ArrayList<>();
		expected.add(laptop);
		expected.add(palla);
		
		assertTrue(this.controllaList(expected, borsa2.getContenutoOrdinatoPerPeso()));
	}
	
	@Test
	public void testControllaSet() {
		Set<Attrezzo> expected = new TreeSet<>();
		expected.add(martello);
		expected.add(motosega);
		
		assertTrue(this.controllaSet(expected, expected));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNomePesoUguale() {
		borsa2.addAttrezzo(spatola);
		borsa2.addAttrezzo(scalpello);
		
		Set<Attrezzo> expected = new TreeSet<>();
		expected.add(spatola);
		expected.add(scalpello);
		
		assertTrue(this.controllaSet(expected, borsa2.getSortedSetOrdinatoPerPeso()));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNomePesoDiverso() {
		borsa2.addAttrezzo(laptop);
		borsa2.addAttrezzo(motosega);
		
		Set<Attrezzo> expected = new TreeSet<>();
		expected.add(laptop);
		expected.add(motosega);
		
		assertTrue(this.controllaSet(expected, borsa2.getSortedSetOrdinatoPerPeso()));
	}
	
	@Test
	public void testControllaMap() {
		Map<Integer, Set<Attrezzo>> expected = new TreeMap<>();
		Set<Attrezzo> set1 = new TreeSet<>();
		Set<Attrezzo> set2 = new TreeSet<>();
		
		set1.add(martello);
		set2.add(motosega);
		
		expected.put(2, set1);
		expected.put(3, set2);
		
		assertTrue(this.controllaMap(expected, expected));
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoDiversoSingleton() {
		borsa2.addAttrezzo(laptop);
		borsa2.addAttrezzo(motosega);
		
		Map<Integer, Set<Attrezzo>> expected = new TreeMap<>();
		Set<Attrezzo> set1 = new TreeSet<>();
		Set<Attrezzo> set2 = new TreeSet<>();
		
		set1.add(laptop);
		set2.add(motosega);
		
		expected.put(2, set1);
		expected.put(3, set2);
		
		System.out.println(expected);
		System.out.println(borsa2.getContenutoRaggruppatoPerPeso());
		
		assertTrue(this.controllaMap(expected, borsa2.getContenutoRaggruppatoPerPeso()));
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoDiversiGruppi() {
		borsa2.addAttrezzo(martello);
		borsa2.addAttrezzo(laptop);
		borsa2.addAttrezzo(palla);
		borsa2.addAttrezzo(motosega);
		
		Map<Integer, Set<Attrezzo>> expected = new TreeMap<>();
		Set<Attrezzo> set1 = new HashSet<>();
		Set<Attrezzo> set2 = new HashSet<>();
		
		set1.add(martello);
		set1.add(motosega);
		set2.add(laptop);
		set2.add(palla);
		
		expected.put(2, set1);
		expected.put(3, set2);
		
		System.out.println(expected);
		System.out.println(borsa2.getContenutoRaggruppatoPerPeso());
		
		assertTrue(this.controllaMap(expected, borsa2.getContenutoRaggruppatoPerPeso()));
	}

}
