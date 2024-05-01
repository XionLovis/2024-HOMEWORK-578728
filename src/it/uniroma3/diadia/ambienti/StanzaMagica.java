package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {
	
	private int contatoreAttrezziPosati;
	
	private int sogliaMagica;
	
	private static final int SOGLIA_MAGIA_DEFAULT = 1;
	
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGIA_DEFAULT);
	}
	
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	
	private Attrezzo modificAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		
		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
		
		return attrezzo;
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.contatoreAttrezziPosati > this.sogliaMagica) {
			attrezzo = this.modificAttrezzo(attrezzo);
		}
		
		this.contatoreAttrezziPosati++;
		
		return super.addAttrezzo(attrezzo);
	}
}
