package connorsRedemption;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

abstract public class Personagem {
	
	private final String nome;
	
	private Arma[] arma;
	private double posX;
	private double posY;
	private double velocidade;
	private int vida;
	private float sangue;
	
	public Personagem(String nome) {
		this.arma = new Arma[2];
		this.nome = nome;
		this.posX = 0.0;
		this.posY = 0.0;
		this.velocidade = 0.0;
		this.vida = 3;
		this.sangue = 0;
	}
	
	public double getPosX() {
		return this.posX;
		
	}
	
	public void setPosX(double x) {
		this.posX = x;
		
	}
	
	public double getPosY() {
		return this.posY;
		
	}
	
	public void setPosY(double y) {
		this.posY = y;
		
	}
	
	public double getVelocidade() {
		return this.velocidade;
	}
	
	public void setVelocidade(double v) {
		this.velocidade = v;
	}
	
	
	public int getVida() {
		return this.vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public float getSangue() {
		return this.sangue;
	}

	public void setSangue(float sangue) {
		this.sangue = sangue;
	}
	
	public boolean colidiuInimigo(Personagem connor, Personagem inimigo) {

		if (connor != null && inimigo != null) {
			Rectangle r1 = new Rectangle((int) connor.getPosX(), (int) connor.getPosY(), 16, 16);
			Rectangle r2 = new Rectangle((int) inimigo.getPosX(), (int) inimigo.getPosY(), 16, 16);
			if (r1.intersects(r2)) {

				return true;
				
			}
		}
		return false;

	}
	
	abstract public void andarCima();
	
	abstract public void andarBaixo();
	
	abstract public void andarEsquerda();
	
	abstract public void andarDireita();
	
	abstract public Bala atirar();
	
	abstract public void ganhaVida(int v);
	
	abstract public void perdeVida();
	
	abstract public void ganhaSangue(float s);
	
	abstract public void perdeSangue(float s);
	
	abstract public AffineTransform getRotacao();
	
	abstract public Image getImagem();

	
}
