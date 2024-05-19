package it.uniroma3.diadia.fixture;

import java.util.List;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Fixture {

	public static IOSimulator creaSimulazionePartitaGiocaFacile(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("chiave", 1)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.getLabirinto();
		DiaDia play = new DiaDia(io, labirinto);
		play.gioca();
		
		return io;
	}
	
	public static IOSimulator creaSimulazionePartitaGiocaHard(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("chiave", 1)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.addStanza("Laboratorio Campus One")
				.addAdiacenza("Laboratorio Campus One", "Atrio", "ovest")
				.addAdiacenza("Atrio", "Laboratorio Campus One", "est")
				.addStanza("Aula N10")
				.addAdiacenza("Aula N10", "Atrio", "est")
				.addAdiacenza("Atrio", "Aula N10", "ovest")
				.getLabirinto();
		DiaDia play = new DiaDia(io, labirinto);
		play.gioca();
		
		return io;
	}
	
	public static IOSimulator creaSimulazioneParticaMonolocale(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto monolocale = Labirinto.newBuilder()
				.addStanzaIniziale("cucina")
				.addStanzaVincente("cucina")
				.getLabirinto();
		DiaDia play = new DiaDia(io, monolocale);
		play.gioca();
		
		return io;
	}
	
	public static IOSimulator creaSimulazionePartitaBilocale(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto bilocale = Labirinto.newBuilder()
				.addStanzaIniziale("cucina")
				.addStanzaVincente("salotto")
				.addAttrezzo("TV", 30)	//Fa riferimento all'ultima stanza aggiunta
				.addAdiacenza("cucina", "salotto", "sud")
				.addAdiacenza("salotto", "cucina", "nord")
				.getLabirinto();
		DiaDia play = new DiaDia(io, bilocale);
		play.gioca();
		
		return io;
	}
	
	public static IOSimulator creaSimulazionePartitaTrilocale(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto trilocale = Labirinto.newBuilder()
				.addStanzaIniziale("cucina")
				.addAttrezzo("spatola", 2)	//Fa riferimento all'ultima stanza aggiunta
				.addStanza("salotto")
				.addStanzaVincente("camera")
				.addAdiacenza("cucina", "salotto", "sud")
				.addAdiacenza("salotto", "cucina", "nord")
				.addAdiacenza("cucina", "camera", "ovest")
				.addAdiacenza("camera", "cucuina", "est")
				.getLabirinto();
		DiaDia play = new DiaDia(io, trilocale);
		play.gioca();
		
		return io;
	}
	
	public static Attrezzo creaAttrezzoEAggiungiAStanza(Stanza stanzaVuota, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		stanzaVuota.addAttrezzo(attrezzo);
		
		return attrezzo;
	}
}
