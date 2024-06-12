package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_SALUTATA = "Ciao tesoro, ti darei un bacetto, ma sto cucinando dei dolci";
	private static final String MESSAGGIO_NON_SALUTATA = "Perché sei maleducato e brutto in culo, soffrirai di torsione testicolare!!";

	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		String messaggio;
		List<Stanza> stanzeAdiacenti = partita.getStanzaCorrente().getStanzeAdiacenti();
		
		Stanza maxAttrezzi = stanzeAdiacenti.get(0);
		Stanza minAttrezzi = stanzeAdiacenti.get(0);
		
		for (Stanza stanza : stanzeAdiacenti) {
			if (stanza != null) {
				if (stanza.getNumeroAttrezzi() > maxAttrezzi.getNumeroAttrezzi()) {
					maxAttrezzi = stanza;
				}
				
				if (stanza.getNumeroAttrezzi() < minAttrezzi.getNumeroAttrezzi()) {
					minAttrezzi = stanza;
				}
			}
		}
		
		if (this.haSalutato()) {
			partita.setStanzaCorrente(maxAttrezzi);
			messaggio = MESSAGGIO_SALUTATA;
		}
		else {
			partita.setStanzaCorrente(minAttrezzi);
			messaggio = MESSAGGIO_NON_SALUTATA;
		}
		
		return messaggio;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "HARRY POTTER AND THE AUDACITY OF THIS BITCH HAHAHAHAHA";
	}
	
}
