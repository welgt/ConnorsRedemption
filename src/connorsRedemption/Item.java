<<<<<<< HEAD
package connorsRedemption;

import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Item {

	private String nome;
	private ImageIcon imagemItem;
	private JLabel item = new JLabel(imagemItem);
	private int posX;
	private int posY;
	private int raioColisao;

	private int larguraImg;
	private int alturaImg;
	private int rot;
	// private AudioClip audioItem;

	public Item(String nome, int posItemX, int posItemY) {
		this.nome = nome;
		this.posX = posItemX;
		this.posY = posItemY;
		this.larguraImg = 200;
		this.alturaImg = 200;
		this.raioColisao = 10; // tera que ajustar fazendo testes provavelmente.
		this.rot = 0;
	}

	public void setImagem(String CaminhoImg) {

		this.imagemItem = new ImageIcon(getClass().getResource(CaminhoImg));
		item.setBounds(getPosItemX(), getPosItemY(), getLarguraImg(), getAlturaImg());
		// item.setBounds(this.posItemX = posX, this.posItemY = posY, getLarguraImg(),
		// getAlturaImg());
	}

	public int getAlturaImg() {
		return this.alturaImg;
	}

	public void setAlturaImg(int altura) {
		this.alturaImg = altura;
	}

	public int getLarguraImg() {
		return this.larguraImg;
	}

	public void setLarguraImg(int largura) {
		this.larguraImg = largura;
	}

	public int getPosItemX() {
		return this.posX;
	}

	public void setPosItemX(int posicaoX) {
		this.posY = posicaoX;
	}

	public int getPosItemY() {
		return this.posY;
	}

	public void setPosItemY(int posicaoY) {
		this.posY = posicaoY;
	}

	public AffineTransform getRotacao() {
		AffineTransform at = AffineTransform.getTranslateInstance(getPosItemX(), getPosItemY());
		at.rotate(Math.toRadians(this.rot), 0, 0);
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

=======
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
>>>>>>> 6919f0c56ad1eb364ba5eb491e99985d83f4fe30
