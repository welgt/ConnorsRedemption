package connorsRedemption;

import java.awt.Image;

public class Ar extends Item {
	
	private double qtdAr;

	public Ar(String nome, Image skin, float posX, float posY) {
		super(nome, skin, posX, posY);
		this.qtdAr = 3.0;
	}
	
	public void setQtdAr (double qtdAr) {
		this.qtdAr = qtdAr;
	}
	
	public double getQtdAr () {
		return this.qtdAr;
	}

}
