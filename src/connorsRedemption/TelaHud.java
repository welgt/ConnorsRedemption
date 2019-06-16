package connorsRedemption;

import java.awt.Image;
import java.awt.geom.AffineTransform;

public class TelaHud extends Tela{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//public Image visorMapa;
	public Image visorVida;
	public Image visorSangue;
	public int rot;
	private double posXvisor;
	private double posYvisor;
	
	//public Image miniMapa;
	
	
	public TelaHud(/*Image visorMapa,*/ Image visorVida,
				   Image visorSangue/*, Image miniMapa*/) {
		
		//this.visorMapa = visorMapa;
		this.visorVida = visorVida;
		this.visorSangue = visorSangue;
		//this.miniMapa = miniMapa;
		this.rot = 0;
		this.posXvisor = 0;
		this.posYvisor = 0;
		
	}
	
	
	public double getPosYvisor() {
		return this.posYvisor;
	}


	public void setPosYvisor(double posYvisor) {
		this.posYvisor = posYvisor;
	}


	public double getPosXvisor() {
		return this.posXvisor;
	}


	public void setPosXvisor(double posXvisor) {
		this.posXvisor = posXvisor;
	}


	public Image getVisorVida() {
		return this.visorVida;
	}

	public void setVisorVida(Image visorVida) {
		this.visorVida = visorVida;
	}

	public Image getVisorSangue() {
		return this.visorSangue;
	}

	public void setVisorSangue(Image visorSangue) {
		this.visorSangue = visorSangue;
	}
/*
	public Image getVisorMapa() {
		return visorMapa;
	}

	public void setVisorMapa(Image visorMapa) {
		this.visorMapa = visorMapa;
	}
	
		public Image getMiniMapa() {
		return miniMapa;
	}

	public void setMiniMapa(Image miniMapa) {
		this.miniMapa = miniMapa;
	}
*/
	
	public AffineTransform getRotacao() {
		AffineTransform at = AffineTransform.getTranslateInstance(this.posXvisor, this.posYvisor);
		at.rotate(Math.toRadians(this.rot));
		return at;
	}

}
