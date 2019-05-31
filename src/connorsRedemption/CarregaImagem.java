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
				img[0] = imagem.getSubimage(0,0,120,140);
				img[1] = imagem.getSubimage(120,0,120,140);
				
				img[2] = imagem.getSubimage(0,135,120,140);
				img[3] = imagem.getSubimage(120,145,120,130);
				
				img[4] = imagem.getSubimage(0,270,120,140);
				img[5] = imagem.getSubimage(120,270,120,140);
				
				img[6] = imagem.getSubimage(0,405,120,140);
				img[7] = imagem.getSubimage(120,405,120,140);
				
			   	return img;
			} catch (IOException e) {
				throw new IllegalArgumentException("Não foi possível carregar o arquivo " + arquivo, e);
			}
	}
	
}
