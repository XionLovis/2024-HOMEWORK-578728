package it.uniroma3.diadia.giocatore;
public class Giocatore {

	static final private int CFU_INIZIALI = 20;
	
	private int cfu;
	private Borsa borsa;
	
	//Costruttore
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	//Getter e Setter dei cfu
	
	public int getCfu() {
		return this.cfu;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	//Getter e Setter di borsa
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	
}
