package connorsRedemption;

import java.awt.Image;

public class Bala {
	
	private Image skinBala;
	private int danoBala;
	private float velocidadeBala;
	private float posX;
	private float posY;
	
	public Bala (Image skinBala, int danoBala) {
		this.skinBala = skinBala;
		this.danoBala = danoBala;
	}
	
	
	public void setDanoBala (int danoBala) {
	    
		this.danoBala = danoBala;
	}
	
	public int getDanoBala () {
		return this.danoBala;
	}
	
	public void setVelocidadeBalaX(float velocidadeBalaX) {
		this.velocidadeBala = this.posX * velocidadeBalaX; // incrementa pixel em loop Game (confirmar)
		  // ajustar velocidade conforme poder de processamento de cada maquina
	}
	
	public void setVelocidadeBalaY(float velocidadeBalaY) {
		this.velocidadeBala = this.posY * velocidadeBalaY; // incrementa pixel em loop Game (confirmar)
		  // ajustar velocidade conforme poder de processamento de cada maquina
	}
	
	public float getPosXbala() {
		return this.posX;
	}
	
	public float getPosYbala() {
		return this.posY;
	}
	
	public float getVelocidadeBala() {
		return this.velocidadeBala;
	}
	
	public void setPosicaoInicialBala (float x, float y) {
		this.posX = x;
		this.posY = y;
	}
	 

}
