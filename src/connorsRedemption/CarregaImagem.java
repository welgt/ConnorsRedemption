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
				
				System.out.println(imagem.getHeight());
				System.out.println(imagem.getWidth());
				
				
				//Recorta a imagem e coloca no vetor
				img[0] = imagem.getSubimage(0,0,120,150);
				img[1] = imagem.getSubimage(120,0,120,150);
				
				img[2] = imagem.getSubimage(0,120,120,150);
				img[3] = imagem.getSubimage(120,120,120,150);
				
				img[4] = imagem.getSubimage(0,240,120,150);
				img[5] = imagem.getSubimage(120,240,120,150);
				
				img[6] = imagem.getSubimage(0,360,120,150);
				img[7] = imagem.getSubimage(120,360,120,150);
				
			   	return img;
			} catch (IOException e) {
				throw new IllegalArgumentException("Não foi possível carregar o arquivo " + arquivo, e);
			}
	}
	
}
