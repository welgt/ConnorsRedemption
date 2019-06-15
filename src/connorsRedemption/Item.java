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
	private boolean darVida;
	// private AudioClip audioItem;


	public Item(String nome, Image skinItem,double posX, double posY) {
		this.skinItem = skinItem;
		this.nome = nome;
		this.posX = posX;
		this.posY = posY;
		this.raioColisao = 100; // tera que ajustar fazendo testes provavelmente.
		this.darVida = false;
		
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
	
	public void trasladar(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
		AffineTransform trans = AffineTransform.getTranslateInstance(posX,posY);
	}

	public boolean colidiu(Item coracao, Personagem connor) {

		if (coracao != null) {
			
			
			
			Rectangle r1 = new Rectangle((int) connor.getPosX(), (int) connor.getPosY(), 20, 20);
			Rectangle r2 = new Rectangle((int) coracao.getPosX(), (int) coracao.getPosY(), 55, 55);
			if (r1.intersects(r2)) {
				this.darVida = true;
				return true;
				
			}
		}
		return false;

	}
	
	
	public void darVida(Personagem connor) {
		
		if(darVida) {
			connor.ganhaVida(+1);
		}
	}

}

