package connorsRedemption;

import java.awt.Image;

public class Item {
	
	private String nome;
	private Image skin;
	private float posItemX;
	private float posItemY;
	private int raioColisao;

	public Item (String nome,Image skin, float posX, float posY) {
		this.nome = nome;
		this.skin = skin;
		this.posItemX = posX;
		this.posItemY = posY;
		this.raioColisao = 10; // tera que ajustar fazendo testes provavelmente.
	}
	
	public boolean detectarColisao(String nomeObjeto, float posXobjeto, float posYobjeto) {
		
		if(this.posItemX == posXobjeto - (this.raioColisao/2) || this.posItemY == posYobjeto - (this.raioColisao/2)){
			
			return true;
		}
		return false;
	}
}
