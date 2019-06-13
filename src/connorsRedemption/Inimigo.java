package connorsRedemption;

import java.awt.Image;
import java.awt.geom.AffineTransform;

public class Inimigo extends Personagem{
	private final Image[] img;
	private int rot;
	private int posImg;
	
	public Inimigo(String nome, Image[] img) {
		super(nome);
		this.setPosX(50.0);
		this.setPosY(50.0);
		this.img = img;
		this.rot = 0;
		this.posImg = 0;
		this.setVelocidade(0.5);
		this.setVida(3);
		this.setSangue(100);
		
	}
	
	@Override
	public void andarCima() {
		this.rot = 180;
		this.posImg = (this.posImg + 1) % 3;
		this.setPosY(this.getPosY() - (this.getVelocidade()*0.1));
		
	}
	
	@Override
	public void andarBaixo() {
		this.rot = 0;
		this.posImg = (this.posImg + 1) % 3;
		this.setPosY(this.getPosY() + (this.getVelocidade()*0.1));
		
	}
	
	@Override
	public void andarEsquerda() {
		this.rot = 90;
		this.posImg = (this.posImg + 1) % 3;
		this.setPosX(this.getPosX() - (this.getVelocidade()*0.1));
		
	}
	
	@Override
	public void andarDireita() {
		this.rot = 270;
		this.posImg = (this.posImg + 1) % 3;
		this.setPosX(this.getPosX() + (this.getVelocidade()*0.1));
		
	}
	
	@Override
	public Bala atirar() {
		return null;
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
	public Image getImagem() {
		return img[this.posImg];
		
	}
	
	@Override
	public AffineTransform getRotacao() {
		AffineTransform at = AffineTransform.getTranslateInstance(this.getPosX(), this.getPosY());
		at.rotate(Math.toRadians(this.rot), img[this.posImg].getWidth(null)/2, img[this.posImg].getHeight(null)/2);
		return at;
		
	}
	

}
