package connorsRedemption;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Item {

	private String nome;
    private Image[] skinItem;
	private int posX;
	private int posY;
	private int raioColisao;
	private int rotItem;
	// private AudioClip audioItem;
	private int posImgItem;

	public Item(String nome, Image[] skinItem,int posX, int posY) {
		this.skinItem = skinItem;
		this.nome = nome;
		this.posX = posX;
		this.posY = posY;
		this.raioColisao = 10; // tera que ajustar fazendo testes provavelmente.
		this.posImgItem = 0;
	}





	public int getPosX() {
		return this.posX;
	}

	public void setPosIX(int posicaoX) {
		this.posY = posicaoX;
	}

	public int getPosY() {
		return this.posY;
	}

	public void setPosY(int posicaoY) {
		this.posY = posicaoY;
	}
	
	public Image getImgItem() {
		return this.skinItem[this.posImgItem];
	}

	public AffineTransform getRotacao() {
		AffineTransform at = AffineTransform.getTranslateInstance(getPosX(), getPosY());
		at.rotate(Math.toRadians(this.rotItem));
		return at;
	}

	public boolean detectarColisao(String nomeObjeto, float posXobjeto, float posYobjeto) {

		if (this.posX == posXobjeto - (this.raioColisao / 2)
				|| this.posY == posYobjeto - (this.raioColisao / 2)) {
			// tocar audioClip audioItem
			return true;
		}
		return false;
	}
}

