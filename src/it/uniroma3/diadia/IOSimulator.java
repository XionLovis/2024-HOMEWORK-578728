package it.uniroma3.diadia;

public class IOSimulator implements IO {

	private String[] righeLette;
	private int indiceRigheLette;
	
	private String[] messaggiProdotti;
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;
	
	//Getter e Setter messaggi prodotti
	
	public String[] getMessaggiProdotti() {
		return messaggiProdotti;
	}
	
	public void setMessaggiProdotti(String[] messaggiProdotti) {
		this.messaggiProdotti = messaggiProdotti;
	}
	
	public IOSimulator(String[] righeDaLeggere) {
		this.righeLette = righeDaLeggere;
		this.indiceRigheLette = 0;
		this.indiceMessaggiMostrati = 0;
		this.messaggiProdotti = new String[42*23];
	}
	
	public boolean hasNextMessaggio() {
		return this.indiceMessaggiMostrati < this.indiceMessaggiProdotti;
	}
	
	public String nextMessaggio() {
		String next = this.messaggiProdotti[this.indiceMessaggiMostrati];
		this.indiceMessaggiMostrati++;
		
		return next;
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiProdotti[indiceMessaggiProdotti] = messaggio;
		this.indiceMessaggiProdotti++;
	}

	@Override
	public String leggiRiga() {
		String riga = null;
		
		riga = this.righeLette[indiceRigheLette];
		this.indiceRigheLette++;
		
		return riga;
	}

}
