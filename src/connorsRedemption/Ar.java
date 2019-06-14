package connorsRedemption;

public class Ar extends Item {
	
	private double qtdAr;
	
	public Ar(String nome, int posX, int posY) {
		super(nome, posX, posY);
		
	}


	public void setQtdAr (double qtdAr) {
		this.qtdAr = qtdAr;
	}
	
	public double getQtdAr () {
		System.out.println();
		return this.qtdAr;
		
	}

}

