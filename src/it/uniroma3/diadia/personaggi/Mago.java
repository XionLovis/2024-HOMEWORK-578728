package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_REGALO = "Tieni questo strumentopolo che ti servirà per dopo"
			+ "... O no, che ne so io?";
	private static final String MESSAGGIO_SCUSA = "Ma che te sembro, Maria Teresa di Calcutta?";
	private Attrezzo attrezzo;

	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		String messaggio;
		
		if (this.attrezzo != null) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			messaggio = MESSAGGIO_REGALO;
		}
		else {
			messaggio = MESSAGGIO_SCUSA;
		}
		
		return messaggio;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		StringBuilder answer = new StringBuilder("Grazie per avermi regalato ");
		answer.append(attrezzo.getNome() + ".");
		answer.append(" Ma è pesante, quindi lo lascio qui dopo aver cambiato qualche cosetta");
		
		Attrezzo attrezzoModificato = new Attrezzo(attrezzo.getNome(), attrezzo.getPeso()/2);
		partita.getStanzaCorrente().addAttrezzo(attrezzoModificato);
		
		return answer.toString();
	}

	
	
}
