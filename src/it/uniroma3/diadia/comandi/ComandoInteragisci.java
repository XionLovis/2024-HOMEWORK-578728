package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando {

	private IO io;
	private String messaggio;
	private static final String MESSAGGIO_CON_CHI = "Con chi dovrei interagire?...";
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		
		if (personaggio != null) {
			this.messaggio = personaggio.agisci(partita);
			io.mostraMessaggio(this.messaggio);
		}
		else {
			io.mostraMessaggio(MESSAGGIO_CON_CHI);
		}
	}
	
	public String getMessaggio() {
		return this.messaggio;
	}
	
	@Override
	public void setIo(IO io) {
		this.io = io;
	}

}
