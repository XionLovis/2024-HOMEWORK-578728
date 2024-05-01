package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	// Costruttori
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10];
		this.numeroAttrezzi = 0;
	}

	//Aggiunge un attrezzo
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) {
			return false;
		}
		if (this.numeroAttrezzi == 10) {
			return false;
		}

		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;

		return true;
	}

	// Ritorna il peso massimo
	public int getPesoMax() {
		return pesoMax;
	}

	// Ritorna l'attrezzo
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;

		for (int i = 0; i < this.numeroAttrezzi; i++) {
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a = attrezzi[i];
			}
		}

		return a;
	}

	// Ritorna il peso totale
	public int getPeso() {
		int peso = 0;

		for (int i = 0; i < this.numeroAttrezzi; i++) {
			peso += this.attrezzi[i].getPeso();
		}

		return peso;
	}

	//Ritorna il peso rimanente 
	public boolean getPesoRimanente(Attrezzo a) {
		if (a != null && this.getPesoMax() - this.getPeso() >= a.getPeso()) {
			return true;
		}
		
		return false;
	}
	
	// Ritorna se è vuoto
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	// Ritorna se c'è un attrezzo o meno
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	// Cancella un attrezzo
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;

		if (nomeAttrezzo != null) {
			for (int i = 0; i < this.numeroAttrezzi; i++) {
				Attrezzo att = this.attrezzi[i];

				if (att != null && att.getNome().equals(nomeAttrezzo)) {
					a = att;
					this.attrezzi[i] = null;
					this.numeroAttrezzi--;
					break;
				}
			}
		}
		return a;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {

			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			for (int i = 0; i < this.numeroAttrezzi; i++) {
				s.append(attrezzi[i].toString() + " ");
			}
		} else
			s.append("Borsa vuota");
		return s.toString();
	}
}
