package connorsRedemption;

import java.applet.AudioClip;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Arma {

	private String nome;
	private Image imagemArma;

	private AudioClip audio;
	// private double qtdDano; // a classe Bala passou a contror isso.
	private int posArmX;
	private int posArmY;
	private int qtdMunicao;
	private int qtdCartucho;
	private int auxQtdMunicao;
	private int rot;

	public Arma(String nome, int qtdMunicao, int qtdCartucho) {
		this.nome = nome;
		this.qtdMunicao = qtdMunicao;
		this.auxQtdMunicao = qtdMunicao;
		this.qtdCartucho = qtdCartucho;
		this.rot = 0;

	}


	public Image getImage() {
		return this.imagemArma;

	}

	public float getPosArmX() {
		return this.posArmX;
	}

	public void setPosArmX(int posX) {
		this.posArmX = posX;
	}

	public float getPosArmY() {
		return this.posArmY;
	}

	public void setPosArmY(int posY) {
		this.posArmY = posY;
	}

	public int getQtdMunicao() {
		return this.qtdMunicao;
	}

	public int getQtdCartucho() {
		return this.qtdCartucho;
	}

/*
	public  void newAudioClip(String url) {
		URL musica = getClass().getResource("+url+");
		this.audio = Applet.newAudioClip(musica);
        //this.audio = new sun.applet.AppletAudioClip(musica);
      
    }
/*	
	public final static AudioClip newAudioClip(URL url) {
        return new sun.applet.AppletAudioClip(url);
    }
	
	public void setMusicaArma(String CaminhoAudio) {
		URL musica = getClass().getResource("+CaminhoAudio+");
		this.audio = Applet.newAudioClip(musica);

	}
	
*/	

	public void ligaMusicaArma() {
		this.audio.play();
		System.out.println("DEBUG: liga som do tiro.");
	}
	
	public void desligaMusicaArma() {
		this.audio.stop();
		System.out.println("DEBUG: Desliga som do tiro.");
	}


	public void atirar1() {
		if (getQtdMunicao() > 0) {
			// ativar audioClip rajadaArma
			this.qtdMunicao--;

		}
	}

	public void atirar2(boolean gatilho) {
		/*
		if (gatilho && getQtdMunicao() > 0) {
			//Bala bala = new Bala(skinBala, 0, 0, 0, 0, 0); // imagem(por hora nula) e qtd dano da bala
		
			System.out.println("DEBUG : ATIROU");
		
			
			bala.setPosicaoInicialBala(getPosArmX(), getPosArmY());
		

			//bala.setVelocidadeBalaX(0.1f); // ajudar posteriormente velocidade
			this.qtdMunicao--;

			if (bala.getPosXbala() < Tela.auxLargura || bala.getPosYbala() < Tela.auxAltura) {
				bala = null;

			}

			
		}
*/		
	}

	public void carregarArma() {

		if (this.getQtdCartucho() >= 1) {
			// ativar AudioClip carregarArma
			this.qtdCartucho--;
			this.qtdMunicao = this.auxQtdMunicao; // nao deixa estourar a quantidade de bala. e adapta-se em qualquer
													// valor
													// no parametro "qtdMunicao"do construtor.
			System.out.println("Recarreguei : " + getQtdMunicao()); // para debugar

		}

		if (this.qtdCartucho <= 0) { // quando acabar teremos que adicionar a coleta de item de recarga de cartucho.
			this.qtdCartucho = 0; // por prevencao, para nao ficar negativando o cartucho.

		}
	}

	public int setRotacao(int rot) {
		return this.rot = rot;
	}

	public AffineTransform getRotacao() {
		AffineTransform at = AffineTransform.getTranslateInstance(getPosArmX(), getPosArmY());
		at.rotate(Math.toRadians(this.rot), 0, 0);
		return at;
	}
	
}
