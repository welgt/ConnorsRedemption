package connorsRedemption;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CarregaImagem {
	public BufferedImage connor;
	
	public CarregaImagem() {
		this.connor = connorImage();
		
	}
	
	private BufferedImage connorImage() {
		File arquivo = new File("C:\\Users\\celso.alineri\\Documents\\dev\\workspace\\ConnorsRedemption\\res\\images\\connor.png");
		
		try {
				BufferedImage img = ImageIO.read(arquivo);
				//BufferedImage imagens[][] = new BufferedImage[4][2];
				
				//Recorta a imagem
				img = img.getSubimage(0,0,120,120);
			   	return img;
			} catch (IOException e) {
				throw new IllegalArgumentException("Não foi possível carregar o arquivo " + arquivo, e);
			}
	}
	
}
