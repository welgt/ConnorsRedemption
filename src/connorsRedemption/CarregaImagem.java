package connorsRedemption;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CarregaImagem {
	private BufferedImage[] connor;
	private Image[] mapa;
	private BufferedImage[] inimigos;
	
	public CarregaImagem() {
		this.connor = connorImage();
		this.mapa = mapaImage();
		this.inimigos = inimigoImage();
		
	}
	
	private BufferedImage[] connorImage() {
		File arquivo = new File("res\\imagens\\connor.png");
		
		try {
				BufferedImage imagem = ImageIO.read(arquivo);
				BufferedImage[] img = new BufferedImage[8];
				
				//Recorta a imagem e coloca no vetor
				img[0] = imagem.getSubimage(0,0,50,50);
				img[1] = imagem.getSubimage(50,0,50,50);
				
				img[2] = imagem.getSubimage(100,0,50,50);
				img[3] = imagem.getSubimage(150,0,50,50);
				
				img[4] = imagem.getSubimage(0,50,50,50);
				img[5] = imagem.getSubimage(50,50,50,50);
				
				img[6] = imagem.getSubimage(100,50,50,50);
				img[7] = imagem.getSubimage(150,50,50,50);
				
			   	return img;
			} catch (IOException e) {
				throw new IllegalArgumentException("Nao foi possivel carregar o arquivo " + arquivo, e);
			}
	}
	
	public BufferedImage[] getImgConnor() {
		return this.connor;
	}
	
	private Image[] mapaImage() {
		File arquivo = new File("res\\imagens\\map.png");
		
		try {
				BufferedImage imagem = ImageIO.read(arquivo);
				Image[] img = new Image[2];
				
				//Recorta a imagem e coloca no vetor
				BufferedImage temp;
				temp = imagem.getSubimage(0,0,imagem.getWidth(),imagem.getHeight()/2);
				img[0] = temp.getScaledInstance(780, 560, temp.SCALE_SMOOTH);
				temp = imagem.getSubimage(0,imagem.getHeight()/2,imagem.getWidth(),imagem.getHeight()/2);
				img[1] = temp.getScaledInstance(780, 560, temp.SCALE_SMOOTH);
						
			   	return img;
			} catch (IOException e) {
				throw new IllegalArgumentException("Nao foi possivel carregar o arquivo " + arquivo, e);
			}
	}
	
	public Image[] getImgMapa() {
		return this.mapa;
	}
	
	private BufferedImage[] inimigoImage(){
		File arquivo = new File("res\\imagens\\char2.png");
		
		try {
			BufferedImage imagem = ImageIO.read(arquivo);
			BufferedImage[] img = new BufferedImage[3];
			
			//Recorta a imagem e coloca no vetor
			img[0] = imagem.getSubimage(0,0,16,16);
			img[1] = imagem.getSubimage(16,0,16,16);
			img[2] = imagem.getSubimage(32,0,16,16);
			
		   	return img;
		} catch (IOException e) {
			throw new IllegalArgumentException("Nao foi possivel carregar o arquivo " + arquivo, e);
		}
		
	}
	
	public BufferedImage[] getImgInimigo() {
		return this.inimigos;
	}
	
}
