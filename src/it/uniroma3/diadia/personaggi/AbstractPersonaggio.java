package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {
	
	private String nome;
	private String presentazione;
	private boolean haSalutato;
	
	//Costruttore
	public AbstractPersonaggio(String nome, String presentazione) {
		this.nome = nome;
		this.presentazione = presentazione;
		this.haSalutato = false;
	}
	
	//Getter e Setter
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPresentazione() {
		return this.presentazione;
	}
	
	public void setPresentazione(String presentazione) {
		this.presentazione = presentazione;
	}
	
	public boolean haSalutato() {
		return this.haSalutato;
	}
	
	public String saluta() {
		StringBuilder answer = new StringBuilder("Hello there!! Sono ");
		answer.append(this.getNome() + ".");
		
		if (!haSalutato) {
			answer.append(this.presentazione);
		}
		else {
			answer.append("General Kenobi, ma sei scemo? abbiamo appena parlato");
		}
		
		this.haSalutato = true;
		
		return answer.toString();
	}
	
	abstract public String agisci(Partita partita);
	
	@Override
	public String toString() {
		return this.getNome();
	}
	
	abstract public String riceviRegalo(Attrezzo attrezzo, Partita partita);
	
}
