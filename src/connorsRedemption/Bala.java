package connorsRedemption;

import java.awt.Image;
import java.awt.geom.AffineTransform;

public class Bala {
	
	private Image[] skinBala;
	private int posImgBala;
	private int rotTiro;
	private int danoBala;
	private double velocidadeBala;
	private double posX;
	private double posY;
	private char direcao;
	
	public Bala (Image[] skinBala, int rotTiro, char direcao, int danoBala, double posX, double posY) {
		this.skinBala = skinBala;
		this.danoBala = danoBala;
		this.posX = posX;
		this.posY = posY;
		this.velocidadeBala = 1.0;
		this.posImgBala = 0;
		this.rotTiro = rotTiro;
		this.direcao = direcao;
	}
	
	public char getDirecao() {
		return this.direcao;
	}
	
	public void setPosImgBala(int x) {
		this.posImgBala = x;
	}
	
	public boolean colidiuTela() {
		if(this.posX >= 750 || this.posX <= 10) {
			return true;
		}
		if(this.posY >= 550 || this.posY <= 30) {
			return true;
		}
		return false;
	}
	
	public void setDanoBala (int danoBala) {
	    
		this.danoBala = danoBala;
	}
	
	public int getDanoBala () {
		return this.danoBala;
	}
	
	public void setVelocidadeBalaX(double velocidadeBalaX) {
		this.velocidadeBala = this.posX * velocidadeBalaX; // incrementa pixel em loop Game (confirmar)
		  // ajustar velocidade conforme poder de processamento de cada maquina
	}
	
	public void setVelocidadeBalaY(double velocidadeBalaY) {
		this.velocidadeBala = this.posY * velocidadeBalaY; // incrementa pixel em loop Game (confirmar)
		  // ajustar velocidade conforme poder de processamento de cada maquina
	}
	
	public double getPosXbala() {
		return this.posX;
	}
	
	public double getPosYbala() {
		return this.posY;
	}
	
	public double getVelocidadeBala() {
		return this.velocidadeBala;
	}
	
	public Bala disparar(boolean horizontal) {
		if (horizontal) {
			this.posX = this.posX * this.velocidadeBala;
		}else {
			this.posY = this.posY * this.velocidadeBala;
		}
		return this;
	}
	
	public void setPosicaoInicialBala (double x, double y) {
		this.posX = x;
		this.posY = y;
	}
	
	public Image getImgBala() {
		return this.skinBala[this.posImgBala];
	}
	
	public AffineTransform getRotacao() {
		AffineTransform at = AffineTransform.getTranslateInstance(this.getPosXbala(), this.getPosYbala());
		at.rotate(Math.toRadians(this.rotTiro), skinBala[this.posImgBala].getWidth(null)/2, skinBala[this.posImgBala].getHeight(null)/2);
		return at;
		
	}
	 

}
