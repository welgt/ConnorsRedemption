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
		File arquivo = new File("C:\\Users\\celso.alineri\\Documents\\dev\\workspace\\ConnorsRedemption\\images\\connor.png");
		
		try {
				BufferedImage imagem = ImageIO.read(arquivo);
			   	return imagem;
			} catch (IOException e) {
				throw new IllegalArgumentException("Não foi possível carregar o arquivo " + arquivo, e);
			}
	}
	
}
