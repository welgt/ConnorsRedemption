package connorsRedemption;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

public class Item {

	private final String nome;
    private Image skinItem;
	private double posX;
	private double posY;
	private int rotItem;
	private boolean perdeuVida;
	private double posRamdomLimite;
	private double ramdomX;
	private double ramdomY;
	

	// private AudioClip audioItem;


	public Item(String nome, Image skinItem,double posX, double posY) {
		this.skinItem = skinItem;
		this.nome = nome;
		this.posX = posX;
		this.posY = posY;
		this.perdeuVida = false;
		
	}





	public double getPosX() {
		return this.posX;
	}

	public void setPosX(double posX2) {
		this.posY = posX2;
	}

	public double getPosY() {
		return this.posY;
	}

	public void setPosY(double posY2) {
		this.posY = posY2;
	}
	
	public Image getImgItem() {
		return this.skinItem;
	}

	public AffineTransform getRotacao() {
		AffineTransform at = AffineTransform.getTranslateInstance(this.getPosX(), this.getPosY());
		at.rotate(Math.toRadians(this.rotItem));
		return at;
	}
/*	
	public AffineTransform setRotacao(double rotacao) {
		AffineTransform at = AffineTransform.getRotateInstance(this.getPosX(), this.getPosY());
		at.rotate(Math.toRadians(rotacao));
		
		
		at.rotate(45, 3 + 60/2, 3 + 15/2);
		return at;
	}
*/	

	
	public void trasladar(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
		AffineTransform trans = AffineTransform.getTranslateInstance(posX,posY);
	}

	public boolean colidiuCoracao(Item coracao, Personagem connor) {

		if (coracao != null) {
			Rectangle r1 = new Rectangle((int) connor.getPosX(), (int) connor.getPosY(), 55, 55);
			Rectangle r2 = new Rectangle((int) coracao.getPosX(), (int) coracao.getPosY(), 20, 30);
			if (r1.intersects(r2)) {
				return true;
				
			}
		}
		return false;

	}
	
	
	
	public boolean colidiuCaixaCaveira(Item caixa, Personagem connor) {

		if (caixa != null) {
			Rectangle r1 = new Rectangle((int) connor.getPosX(), (int) connor.getPosY(), 55, 55);
			Rectangle r2 = new Rectangle((int) caixa.getPosX(), (int) caixa.getPosY(), 25, 25);
			if (r1.intersects(r2)) {
				return true;
				
			}
		}
		return false;

	}
	
	
	
	public boolean colidiuCaixa(Item caixa, Bala bala) {

		if (caixa != null && bala != null) {
			Rectangle r1 = new Rectangle((int) caixa.getPosX(), (int) caixa.getPosY(), 45, 45);
			Rectangle r2 = new Rectangle((int) bala.getPosX(), (int) bala.getPosY(), 25, 25);
			if (r1.intersects(r2)) {
				return true;
				
			}
		}
		return false;
	}
	
	public static double setRamdomLimite(char eixo) {
				
		double minX = 800  - 700;
		double maxX = 800 - 100; 
		
		double minY = 600 - 500;
		double maxY = 600- 150;

		if (eixo == 'x') {
			double ramdomX = Math.floor(Math.random() * (maxX - minX + 1)) + minX;
			return ramdomX;
		}

		if (eixo == 'y') {
			double ramdomY = Math.floor(Math.random() * (maxY - minY + 1)) + minY;
			return ramdomY;
		}
		return (Double) null;
	}

}

