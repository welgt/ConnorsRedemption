<<<<<<< HEAD
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
=======
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
>>>>>>> 6919f0c56ad1eb364ba5eb491e99985d83f4fe30
