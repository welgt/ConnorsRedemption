package connorsRedemption;

import java.awt.Image;

public class Item {
	
	private String nome;
	private Image skin;
	private float posX;
	private float posY;

	public Item (String nome,Image skin, float posX, float posY) {
		this.nome = nome;
		this.skin = skin;
		this.posX = posX;
		this.posY = posY;
		
	}
	
	public boolean detectarColisao(String nomeObjeto, float posXobjeto, float posYobjeto) {
		if(this.posX == posXobjeto && this.posY == posYobjeto){
			
		}
		return true;
	}
}
