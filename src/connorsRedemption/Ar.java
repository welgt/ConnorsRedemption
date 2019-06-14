package connorsRedemption;

import java.awt.Image;
import java.awt.geom.AffineTransform;

public class Ar extends Item {
	
	private double qtdAr;

	public Ar(String nome, Image[] skinItem, int posX, int posY) {
		super(nome, skinItem, posX, posY);
		// TODO Stub de construtor gerado automaticamente
	}

	public void setQtdAr (double qtdAr) {
		this.qtdAr = qtdAr;
	}
	
	public double getQtdAr () {
		return this.qtdAr;
	}

}

