package connorsRedemption;

import java.awt.Image;
import java.awt.geom.AffineTransform;

public class Bala {

	private Image[] skin;
	private int posImg;
	private int rot;
	private int dano;
	private double velocidade;
	private double posX;
	private double posY;
	private char direcao;
	private int cont;

	public Bala(Image[] skin, int rot, char direcao, int dano, double posX, double posY) {
		this.skin = skin;
		this.dano = dano;
		this.posX = posX;
		this.posY = posY;
		this.posImg = 0;
		this.rot = rot;
		this.direcao = direcao;
		this.cont = 0;
	}

	public char getDirecao() {
		return this.direcao;
	}

	public int getCont() {
		return this.cont;
	}

	public void setCont(int x) {
		this.cont = x;
	}

	public void setPosImgBala(int x) {
		this.posImg = x;
	}

	public boolean colidiuTela() {
		if (this.posX >= 750 || this.posX <= 10) {
			return true;
		}
		if (this.posY >= 550 || this.posY <= 30) {
			return true;
		}
		return false;
	}

	public void setDanoBala(int dano) {

		this.dano = dano;
	}

	public int getDanoBala() {
		return this.dano;
	}

	
	public void  setVelocidade(Bala bala, double velocidadeX, double velocidadeY) {
		bala.setPosX(this.getPosX()+ velocidadeX);
		bala.setPosY(this.getPosY()+ velocidadeY);
		
	}


	public double getPosX() {
		return this.posX;
	}
	
	public void setPosX(double posX) {
		this.posX = posX;
	}
	
	public double getPosY () {
		return this.posY;
	}

	
	public void setPosY(double posY) {
		this.posY = posY;
	}

	public double getVelocidade() {
		return this.velocidade;
	}
	
	public Bala disparar(boolean horizontal) {
		if (horizontal) {
			this.posX = this.posX * this.velocidade;
		} else {
			this.posY = this.posY * this.velocidade;
		}
		return this;
	}

	public void setPosicaoInicialBala(double x, double y) {
		this.posX = x;
		this.posY = y;
	}

	public Image getImgBala() {
		return this.skin[this.posImg];
	}

	public AffineTransform getRotacao() {
		AffineTransform at = AffineTransform.getTranslateInstance(this.getPosX(), this.getPosY());
		at.rotate(Math.toRadians(this.rot), skin[this.posImg].getWidth(null) / 2,
				skin[this.posImg].getHeight(null) / 2);
		return at;

	}

}
