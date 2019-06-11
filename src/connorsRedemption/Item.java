package connorsRedemption;

import java.applet.AudioClip;
import java.awt.Image;

public class Item {
	
	private int testeHeranca;
	private String nome;
	private Image skin;
	private float posItemX;
	private float posItemY;
	private int raioColisao;
	private AudioClip audioItem; // som ao coletar o item(ainda vou estudar como se faz isso
	                             // so estou colocando pra nao me esquecer!)
	

	public Item (String nome,Image skin, float posX, float posY) {
		this.nome = nome;
		this.skin = skin;
		this.posItemX = posX;
		this.posItemY = posY;
		this.raioColisao = 10; // tera que ajustar fazendo testes provavelmente.
	}
	
	public boolean detectarColisao(String nomeObjeto, float posXobjeto, float posYobjeto) {
		
		if(this.posItemX == posXobjeto - (this.raioColisao/2) || this.posItemY == posYobjeto - (this.raioColisao/2)){
			// tocar audioClip audioItem
			return true;
		}
		return false;
	}
}
