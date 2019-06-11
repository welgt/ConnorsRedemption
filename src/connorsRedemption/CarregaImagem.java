package connorsRedemption;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CarregaImagem {
	public BufferedImage[] connor;
	
	public CarregaImagem() {
		this.connor = connorImage();
		
	}
	
	private BufferedImage[] connorImage() {
		File arquivo = new File("res\\images\\connor.png");
		
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
	
}
