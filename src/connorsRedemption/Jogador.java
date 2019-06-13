package connorsRedemption;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

public class Jogador extends Personagem{
	
	private final Image[] imgConnor;
	private final Image[] imgTiro;
	private int rotConnor;
	private int posImgConnor;
	private char direcao;
	
	public Jogador(String nome, Image[] imgConnor, Image[] imgTiro) {
		super(nome);
		this.setPosX(50.0);
		this.setPosY(50.0);
		this.imgConnor = imgConnor;
		this.imgTiro = imgTiro;
		this.rotConnor = 0;
		this.posImgConnor = 0;
		this.setVelocidade(30.0);
		this.setVida(3);
		this.setSangue(100);
		this.direcao = 'b';
		
	}
	
	public char getDirecao() {
		return this.direcao;
	}
	
	@Override
	public void andarCima() {
		this.rotConnor = 180;
		this.direcao = 'c';
		this.posImgConnor = (this.posImgConnor + 1) % 8;
		this.setPosY(this.getPosY() - (this.getVelocidade()*0.1));
		
	}
	
	@Override
	public void andarBaixo() {
		this.rotConnor = 0;
		this.direcao = 'b';
		this.posImgConnor = (this.posImgConnor + 1) % 8;
		this.setPosY(this.getPosY() + (this.getVelocidade()*0.1));
		
	}
	
	@Override
	public void andarEsquerda() {
		this.rotConnor = 90;
		this.direcao = 'e';
		this.posImgConnor = (this.posImgConnor + 1) % 8;
		this.setPosX(this.getPosX() - (this.getVelocidade()*0.1));
		
	}
	
	@Override
	public void andarDireita() {
		this.rotConnor = 270;
		this.direcao = 'd';
		this.posImgConnor = (this.posImgConnor + 1) % 8;
		this.setPosX(this.getPosX() + (this.getVelocidade()*0.1));
		
	}
	
	@Override
	public Bala atirar() {
		if(this.direcao == 'd') {
			return new Bala(this.imgTiro, this.rotConnor, this.direcao, 5, this.getPosX()+30, this.getPosY()+30);
		}
		if(this.direcao == 'b') {
			return new Bala(this.imgTiro, this.rotConnor, this.direcao, 5, this.getPosX()+3, this.getPosY()+30);
		}
		if(this.direcao == 'e') {
			return new Bala(this.imgTiro, this.rotConnor, this.direcao, 5, this.getPosX(), this.getPosY());
		}
		if(this.direcao == 'c') {
			return new Bala(this.imgTiro, this.rotConnor, this.direcao, 5, this.getPosX()+30, this.getPosY());
		}
		return null;
		//return bala.disparar(this.horizontal);
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
		return imgConnor[this.posImgConnor];
		
	}
	
	@Override
	public AffineTransform getRotacao() {
		AffineTransform at = AffineTransform.getTranslateInstance(this.getPosX(), this.getPosY());
		at.rotate(Math.toRadians(this.rotConnor), imgConnor[this.posImgConnor].getWidth(null)/2, imgConnor[this.posImgConnor].getHeight(null)/2);
		return at;
		
	}
	

}
