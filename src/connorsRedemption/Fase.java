package connorsRedemption;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Fase {
	
	private Image[] img;
	private int subFase;
	private double posX;
	private double posY;
	
	public Fase(Image[] img) {
		this.img = img;
		this.subFase = 0;
		this.posX = 10.0;
		this.posY = 30.0;
	}
	
	public Image getSubFaseImg() {
		return this.img[this.subFase];
	}
	
	public int getSubFaseNum() {
		return this.subFase;
	}

	public AffineTransform getRotacao() {
		AffineTransform at = AffineTransform.getTranslateInstance(this.posX, this.posY);
		at.rotate(Math.toRadians(0), img[this.subFase].getWidth(null)/2, img[this.subFase].getHeight(null)/2);
		return at;
		
	}
}
