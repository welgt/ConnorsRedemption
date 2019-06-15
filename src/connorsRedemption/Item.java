package connorsRedemption;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

public class Item {

	private final String nome;
    private Image skinItem;
	private double posX;
	private double posY;
	private int raioColisao;
	private int rotItem;
	// private AudioClip audioItem;


	public Item(String nome, Image skinItem,double posX, double posY) {
		this.skinItem = skinItem;
		this.nome = nome;
		this.posX = posX;
		this.posY = posY;
		this.raioColisao = 100; // tera que ajustar fazendo testes provavelmente.
		
	}





	public double getPosX() {
		return this.posX;
	}

	public void setPosX(int posicaoX) {
		this.posY = posicaoX;
	}

	public double getPosY() {
		return this.posY;
	}

	public void setPosY(int posicaoY) {
		this.posY = posicaoY;
	}
	
	public Image getImgItem() {
		return this.skinItem;
	}

	public AffineTransform getRotacao() {
		AffineTransform at = AffineTransform.getTranslateInstance(this.getPosX(), this.getPosY());
		at.rotate(Math.toRadians(this.rotItem),skinItem.getWidth(null)/2, skinItem.getHeight(null)/2);
		return at;
	}
	
	public void trasladar(double posX, double posY) {
		AffineTransform trans = AffineTransform.getTranslateInstance(this.posX = posX, this.posY = posY);
	}

	public boolean colidiu(Item coracao, Personagem connor) {

		if (coracao != null) {
			
			Rectangle r1 = new Rectangle((int) connor.getPosX(), (int) connor.getPosY(), 16, 16);
			Rectangle r2 = new Rectangle((int) coracao.getPosX(), (int) coracao.getPosY(), 15, 50);
			if (r1.intersects(r2)) {
				return true;
			}
		}
		return false;

	}

}

