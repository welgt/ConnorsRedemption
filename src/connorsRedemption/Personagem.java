package connorsRedemption;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

abstract public class Personagem {
	
	private final String nome;
	
	private Arma[] arma;
	private int posX;
	private int posY;
	private float velocidade;
	private int vida;
	private float sangue;
	
	public Personagem(String nome) {
		this.arma = new Arma[2];
		this.nome = nome;
		this.posX = 0;
		this.posY = 0;
		this.velocidade = 0;
		this.vida = 0;
		this.sangue = 0;
	}
	
	public int getPosX() {
		return this.posX;
		
	}
	
	public void setPosX(int x) {
		this.posX = x;
		
	}
	
	public int getPosY() {
		return this.posY;
		
	}
	
	public void setPosY(int y) {
		this.posY = y;
		
	}
	
	public float getVelocidade() {
		return this.velocidade;
	}
	
	public void setVelocidade(float v) {
		this.velocidade = v;
	}
	
	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public float getSangue() {
		return sangue;
	}

	public void setSangue(float sangue) {
		this.sangue = sangue;
	}
	
	abstract public void andarCima();
	
	abstract public void andarBaixo();
	
	abstract public void andarEsquerda();
	
	abstract public void andarDireita();
	
	abstract public void ganhaVida(int v);
	
	abstract public void perdeVida();
	
	abstract public void ganhaSangue(float s);
	
	abstract public void perdeSangue(float s);
	
	abstract public AffineTransform getRotacao();
	
	abstract public BufferedImage getImagem();
	
}
