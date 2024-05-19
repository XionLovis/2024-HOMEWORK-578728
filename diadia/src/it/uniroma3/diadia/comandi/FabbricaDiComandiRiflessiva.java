package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {

	@Override
	public Comando costruisciComando(String istruzione) throws Exception {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null; // es. vai sud
		String parametro = null; // es. sud
		Comando comando = null;

		if (scannerDiParole.hasNext()) {
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando
		}
		if (scannerDiParole.hasNext()) {
			parametro = scannerDiParole.next(); // seconda parola: eventuale parametro
		}

		try {
			StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
			nomeClasse.append(Character.toUpperCase(nomeComando.charAt(0)));
			// es. nomeClasse: "it.uniroma3.diadia.comandi.ComandoVai"
			nomeClasse.append(nomeComando.substring(1));
			// es. nomeClasse: "it.uniroma3.diadia.comandi.ComandoVai"
			comando = (Comando) Class.forName(nomeClasse.toString()).newInstance();
			comando.setParametro(parametro);
		} catch (Exception e) {
			comando = new ComandoNonValido();
			//this.io.mostraMessaggio("Comando inesistente");
		}

		return comando;
	}

}
