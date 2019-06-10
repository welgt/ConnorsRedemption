package connorsRedemption;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Jogador extends Personagem{
	
	private final BufferedImage image;
	private double rotacao;
	
	public Jogador(String nome) {
		super(nome);
		this.image = connorImage();
		this.rotacao = 0.0;
		this.setVelocidade(2);
		this.setVida(3);
		this.setSangue(100);
		
	}
	
	@Override
	public AffineTransform getRotacao() {
		AffineTransform at = new AffineTransform();
        at.concatenate(AffineTransform.getScaleInstance(1, -1));
        at.concatenate(AffineTransform.getTranslateInstance(0, -image.getHeight()));
        return at;
	}
	
	@Override
	public void andarCima() {
		this.rotacao = 0.0;
		this.setPosY(this.getPosY() - 10);
		
	}
	
	@Override
	public void andarBaixo() {
		this.rotacao = Math.toRadians(180.0);
		this.setPosY(this.getPosY() + 10);
		
	}
	
	@Override
	public void andarEsquerda() {
		this.setPosX(this.getPosX() - 10);
		
	}
	
	@Override
	public void andarDireita() {
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
		return image.getSubimage(0, 0, 120, 120);
		
	}
	
	private BufferedImage connorImage() {
		File arquivo = new File("C:\\Users\\celso.alineri\\Documents\\dev\\workspace\\ConnorsRedemption\\res\\images\\connor.png");
		//File arquivo = new File("connor.png");
		
		try {
				BufferedImage img = ImageIO.read(arquivo);
				
				//Recorta a imagem
				//img = img.getSubimage(0,0,120,120);
			   	return img;
			} catch (IOException e) {
				throw new IllegalArgumentException("Não foi possível carregar o arquivo " + arquivo, e);
			}
	}
	

}
