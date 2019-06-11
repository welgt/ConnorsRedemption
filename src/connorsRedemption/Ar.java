package connorsRedemption;

public class Ar extends Item {
	
	private int qtdAr;
	
	public Ar(String nome, int posItemX, int posItemY) {
		super(nome, posItemX, posItemY);
		this.qtdAr = 3;
		
	}
	
	public void setQtdAr (int qtdAr) {
		this.qtdAr = qtdAr;
	}
	
	public double getQtdAr () {
		return this.qtdAr;
	}

}
