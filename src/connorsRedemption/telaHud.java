package connorsRedemption;

import java.awt.Image;

public class telaHud extends Tela{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Image visorMapa;
	public Image visorVida;
	public Image visorSangue;
	public Image miniMapa;
	
	public telaHud(Image visorMapa, Image visorVida,
				   Image visorSangue, Image miniMapa) {
		this.visorMapa = visorMapa;
		this.visorVida = visorVida;
		this.visorSangue = visorSangue;
		this.miniMapa = miniMapa;
	}

	public Image getVisorMapa() {
		return visorMapa;
	}

	public void setVisorMapa(Image visorMapa) {
		this.visorMapa = visorMapa;
	}

	public Image getVisorVida() {
		return visorVida;
	}

	public void setVisorVida(Image visorVida) {
		this.visorVida = visorVida;
	}

	public Image getVisorSangue() {
		return visorSangue;
	}

	public void setVisorSangue(Image visorSangue) {
		this.visorSangue = visorSangue;
	}

	public Image getMiniMapa() {
		return miniMapa;
	}

	public void setMiniMapa(Image miniMapa) {
		this.miniMapa = miniMapa;
	}

}
