package connorsRedemption;

import java.awt.Image;

public class TelaGameOver extends Tela{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Image animacaoIntro;
	public String msg;
	
	public TelaGameOver(Image animacaoIntro) {
		this.animacaoIntro = animacaoIntro;
		this.msg = "";
	}
}
