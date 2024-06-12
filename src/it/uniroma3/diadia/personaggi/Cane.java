package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_CANE = "Bau bau, attento con le mani, umano sporco";
	private static final String CIBO_PREFERITO = "osso";

	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		String messaggio = MESSAGGIO_CANE;
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
		
		return messaggio;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		StringBuilder answer = new StringBuilder("Bau, bau, grazie per darmi dato ");
		
		if (attrezzo.getNome().equals(CIBO_PREFERITO)) {
			answer.append("il mio cibo preferito.");
		}
		else {
			answer.append(attrezzo.getNome() + "ma non mi piace!");
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
		}
		
		return answer.toString();
	}

}
