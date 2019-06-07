package connorsRedemption;

import java.awt.Image;

public class TelaLoad extends Tela{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image animacaoIntro;
	private float barraLoad;
	private Image logoGame;
	
	public TelaLoad(Image animacao, Image logo) {
		this.animacaoIntro = animacao;
		this.barraLoad = 0;
		this.logoGame = logo;
	}

	public Image getAnimacaoIntro() {
		return animacaoIntro;
	}

	public void setAnimacaoIntro(Image animacaoIntro) {
		this.animacaoIntro = animacaoIntro;
	}

	public float getBarraLoad() {
		return barraLoad;
	}

	public void setBarraLoad(float barraLoad) {
		this.barraLoad = barraLoad;
	}

	public Image getLogoGame() {
		return logoGame;
	}

	public void setLogoGame(Image logoGame) {
		this.logoGame = logoGame;
	}
	
	

}
