package connorsRedemption;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Jogador extends Personagem{
	
	private final BufferedImage[] img;
	private int rot;
	private int posImg;
	
	public Jogador(String nome, BufferedImage[] img) {
		super(nome);
		this.img = img;
		this.rot = 0;
		this.posImg = 0;
		this.setVelocidade(2);
		this.setVida(3);
		this.setSangue(100);
		
	}
	
	@Override
	public void andarCima() {
		this.rot = 0;
		this.posImg = (this.posImg + 1) % 6;
		this.setPosY(this.getPosY() - 10);
		
	}
	
	@Override
	public void andarBaixo() {
		this.rot = 180;
		this.posImg = (this.posImg + 1) % 6;
		this.setPosY(this.getPosY() + 10);
		
	}
	
	@Override
	public void andarEsquerda() {
		this.rot = 270;
		this.posImg = (this.posImg + 1) % 6;
		this.setPosX(this.getPosX() - 10);
		
	}
	
	@Override
	public void andarDireita() {
		this.rot = 90;
		this.posImg = (this.posImg + 1) % 6;
		this.setPosX(this.getPosX() + 10);
		
	}

	@Override
	public void ganhaVida(int v) {
		this.setVida(this.getVida() + v);
		
	}

	@Override
	public void perdeVida() {
		this.setVida(this.getVida() - 1);
		
	}

	@Override
	public void ganhaSangue(float s) {
		this.setSangue(this.getSangue() + s);
		
	}

	@Override
	public void perdeSangue(float s) {
		this.setSangue(this.getSangue() - s);
		
	}
	
	@Override
	public BufferedImage getImagem() {
		return img[this.posImg];
		
	}
	
	@Override
	public AffineTransform getRotacao() {
		AffineTransform at = AffineTransform.getTranslateInstance(this.getPosX(), this.getPosY());
		at.rotate(Math.toRadians(this.rot), 77, 77);
		return at;
		
	}
	

}
