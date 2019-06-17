package connorsRedemption;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	private Image arma1;
	private Image arma2;
	private Image [] caixaItem;
	private Image [] caixaCaveira;
	private Image [] explosaoCaixaCaveira;


	public CarregaImagem() {
		
		this.connor = connorImage();
		this.tiro = tiroImage();
		this.mapa = mapaImage();
		this.inimigos = inimigoImage();
		
		this.baseHud = baseHud();
		this.CoracaoVida = coracaoVida();
		this.baseCoracao = baseCoracao();
		this.frenteCoracao = frenteCoracao();
		this.arma1 = arma1();
		this.arma2 = arma2();
		this.caixaItem = caixaItem();
		this.caixaCaveira  = caixaCaveira();
		this.explosaoCaixaCaveira = explosaoCaixaCaveira();
		
	

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
			this.CoracaoVida = imagem.getScaledInstance(15, 25, 2);

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
	
	public Image getFrenteCoracao() {
		return this.frenteCoracao;
	}
	
	
	private Image arma1() {

		File arquivo = new File("res\\imagens\\arma1.png");

		try {
			BufferedImage imagem = ImageIO.read(arquivo);
			this.arma1 = imagem.getScaledInstance(30,10, 1);
			
			return arma1;
		} catch (IOException e) {
			throw new IllegalArgumentException("Nao foi possivel carregar o arquivo " + arquivo, e);
		}
	}
	
	public Image getArma1() {
		return this.arma1;
	}
	
	
	private Image arma2() {

		File arquivo = new File("res\\imagens\\arma2.png");

		try {
			BufferedImage imagem = ImageIO.read(arquivo);
			this.arma2 = imagem.getScaledInstance(30,15, 1);

			return arma2;
		} catch (IOException e) {
			throw new IllegalArgumentException("Nao foi possivel carregar o arquivo " + arquivo, e);
		}
	}
	
	public Image getArma2() {
		return this.arma2;
	}
	
	
	
	
	private Image [] caixaItem() {

		File arquivo0 = new File("res\\imagens\\caixaItemTopDir.png");
		File arquivo1 = new File("res\\imagens\\caixaItemTopEsq.png");
		File arquivo2 = new File("res\\imagens\\caixaItemBaixoDir.png");
		File arquivo3 = new File("res\\imagens\\caixaItemBaixoEsq.png");
		
		

		try {
			BufferedImage imagem0 = ImageIO.read(arquivo0);
			BufferedImage imagem1 = ImageIO.read(arquivo1);
			BufferedImage imagem2 = ImageIO.read(arquivo2);
			BufferedImage imagem3 = ImageIO.read(arquivo3);

			Image[] img = new Image[4];
			
			img[0] = imagem0.getScaledInstance(40,40, 1);
			img[1] = imagem1.getScaledInstance(40,40, 1);
			img[2] = imagem2.getScaledInstance(40,40, 1);
			img[3] = imagem3.getScaledInstance(40,40, 1);

			return img;
		} catch (IOException e) {
			throw new IllegalArgumentException("Nao foi possivel carregar o arquivo " 
					+ arquivo0+"ou"+ arquivo1+"ou"+arquivo2 + arquivo3, e);
		}
	}
	
	public Image getcaixaItemTopDir() {
		return this.caixaItem[0];
	}
	
	public Image getcaixaItemTopEsq() {
		return this.caixaItem[1];
	}
	
	public Image getcaixaItemBaixoDir() {
		return this.caixaItem[2];
	}
	
	public Image getcaixaItemBaixoEsq() {
		return this.caixaItem[3];
	}
	
	

	
	private Image[] caixaCaveira() {

		File arquivo0 = new File("res\\imagens\\caixaCaveiraTopDir.png");
		File arquivo1 = new File("res\\imagens\\caixaCaveiraTopEsq.png");
		File arquivo2 = new File("res\\imagens\\caixaItemBaixoDir.png");
		File arquivo3 = new File("res\\imagens\\caixaItemBaixoEsq.png");

		try {
			BufferedImage imagem0 = ImageIO.read(arquivo0);
			BufferedImage imagem1 = ImageIO.read(arquivo1);
			BufferedImage imagem2 = ImageIO.read(arquivo2);
			BufferedImage imagem3 = ImageIO.read(arquivo3);

			Image[] img = new Image[4];

			img[0] = imagem0.getScaledInstance(20, 20, 1);
			img[1] = imagem1.getScaledInstance(20, 20, 1);
			img[2] = imagem2.getScaledInstance(20, 20, 1);
			img[3] = imagem3.getScaledInstance(20, 20, 1);

			return img;
		} catch (IOException e) {
			throw new IllegalArgumentException(
					"Nao foi possivel carregar o arquivo " + arquivo0 + "ou" + arquivo1 + "ou" + arquivo2 + arquivo3,
					e);
		}
	}

	public Image getcaixaCaveiraTopDir() {
		return this.caixaCaveira[0];
	}

	public Image getcaixaCaveiraTopEsq() {
		return this.caixaCaveira[1];
	}

	public Image getcaixaBaixoDir() {
		return this.caixaCaveira[2];
	}

	public Image getcaixaCaveiraBaixoDir() {
		return this.caixaCaveira[3];
	}
	
	
	
	
	
	
	
	
	
	private Image[] explosaoCaixaCaveira() {

		File arquivo0 = new File("res\\imagens\\explosaoCaveira1.png");
		File arquivo1 = new File("res\\imagens\\explosaoCaveira2.png");

		try {
			BufferedImage imagem0 = ImageIO.read(arquivo0);
			BufferedImage imagem1 = ImageIO.read(arquivo1);

			Image[] img = new Image[2];

			img[0] = imagem0.getScaledInstance(40, 40, 1);
			img[1] = imagem1.getScaledInstance(60, 60, 1);

			return img;
		} catch (IOException e) {
			throw new IllegalArgumentException(
					"Nao foi possivel carregar o arquivo " + arquivo0 + "ou" + arquivo1,
					e);
		}
	}

	public Image getExplosaoCaixaCaveira1() {
		return this.explosaoCaixaCaveira[0];
	}

	public Image getExplosaoCaixaCaveira2() {
		return this.explosaoCaixaCaveira[1];
	}

}