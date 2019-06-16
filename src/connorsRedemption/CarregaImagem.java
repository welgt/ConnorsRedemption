package connorsRedemption;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class CarregaImagem {
	private Image[] connor;
	private Image[] tiro;
	private Image[] mapa;
	private Image[] inimigos;
	
	private Image CoracaoVida;
	
	// HUD
	private Image baseHud;
	private Image baseCoracao;
	private Image frenteCoracao;

	
	

	public CarregaImagem() {
		
		this.connor = connorImage();
		this.tiro = tiroImage();
		this.mapa = mapaImage();
		this.inimigos = inimigoImage();
		
		this.CoracaoVida = coracaoVida();
		this.baseCoracao = baseCoracao();
		this.baseHud = baseHud();
		this.frenteCoracao = frenteCoracao();
	

	}
	
	private Image[] connorImage() {
		File arquivo = new File("res\\imagens\\connor.png");
		
		try {
				BufferedImage imagem = ImageIO.read(arquivo);
				Image[] img = new Image[8];
				
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
	
	public Image[] getImgConnor() {
		return this.connor;
	}
	
	private Image[] tiroImage() {
		File arquivo = new File("res\\imagens\\connor.png");
		
		try {
				BufferedImage imagem = ImageIO.read(arquivo);
				Image[] img = new Image[4];
				
				//Recorta a imagem e coloca no vetor
				img[0] = imagem.getSubimage(0,100,20,20);
				img[1] = imagem.getSubimage(0,120,20,20);
				img[2] = imagem.getSubimage(20,120,20,20);
				img[3] = imagem.getSubimage(40,120,20,20);

			   	return img;
			} catch (IOException e) {
				throw new IllegalArgumentException("Nao foi possivel carregar o arquivo " + arquivo, e);
			}
	}
	
	public Image[] getImgTiro() {
		return this.tiro;
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
	
	private Image[] inimigoImage(){
		File arquivo = new File("res\\imagens\\char2.png");
		
		try {
			BufferedImage imagem = ImageIO.read(arquivo);
			Image[] img = new Image[3];
			
			//Recorta a imagem e coloca no vetor
			BufferedImage temp;
			temp = imagem.getSubimage(0,0,16,16);
			img[0] = temp.getScaledInstance(32, 32, temp.SCALE_SMOOTH);
			temp = imagem.getSubimage(16,0,16,16);
			img[1] = temp.getScaledInstance(32, 32, temp.SCALE_SMOOTH);
			temp = imagem.getSubimage(32,0,16,16);
			img[2] = temp.getScaledInstance(32, 32, temp.SCALE_SMOOTH);
			
		   	return img;
		} catch (IOException e) {
			throw new IllegalArgumentException("Nao foi possivel carregar o arquivo " + arquivo, e);
		}
		
	}
	
	public Image[] getImgInimigo() {
		return this.inimigos;
	}
	
	private Image coracaoVida() {

		File arquivo = new File("res\\imagens\\coracao.png");

		try {
			BufferedImage imagem = ImageIO.read(arquivo);
			this.CoracaoVida = imagem.getScaledInstance(15, 50, 2);

			return CoracaoVida;
		} catch (IOException e) {
			throw new IllegalArgumentException("Nao foi possivel carregar o arquivo " + arquivo, e);
		}
	}

	
	public Image getImgCoracao() {
		return this.CoracaoVida;
	}
	
	
	
	private Image baseCoracao() {

		File arquivo = new File("res\\imagens\\HUDvisorCoracaoBase.png");

		try {
			BufferedImage imagem = ImageIO.read(arquivo);
			this.baseCoracao = imagem.getScaledInstance(20, 20, 0);

			return baseCoracao;
		} catch (IOException e) {
			throw new IllegalArgumentException("Nao foi possivel carregar o arquivo " + arquivo, e);
		}
	}
	
	public Image getBaseCoracao() {
		return this.baseCoracao;
	}
	
	
	
	private Image frenteCoracao() {

		File arquivo = new File("res\\imagens\\HUDvisorCoracaoFrente.png");

		try {
			BufferedImage imagem = ImageIO.read(arquivo);
			this.frenteCoracao = imagem.getScaledInstance(20,20, 1);

			return frenteCoracao;
		} catch (IOException e) {
			throw new IllegalArgumentException("Nao foi possivel carregar o arquivo " + arquivo, e);
		}
	}
	
	public Image getfrenteCoracao() {
		return this.frenteCoracao;
	}
	
	
	
	private Image baseHud() {

		File arquivo = new File("res\\imagens\\baseHud.png");

		try {
			BufferedImage imagem = ImageIO.read(arquivo);
			this.baseHud = imagem.getScaledInstance(40,800, 1);

			return baseHud;
		} catch (IOException e) {
			throw new IllegalArgumentException("Nao foi possivel carregar o arquivo " + arquivo, e);
		}
	}
	
	public Image getBaseHud() {
		return this.baseHud;
	}
	
	


	
}
