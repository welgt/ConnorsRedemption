<<<<<<< HEAD
package connorsRedemption;

import java.applet.AudioClip;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Arma {

	private String nome;
	private ImageIcon imagemArma;
	private JLabel arma = new JLabel(imagemArma);
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

	public void setImagem(String CaminhoImg, int posX, int posY, int larguraImg, int alturaImg) {
		this.imagemArma = new ImageIcon(getClass().getResource(CaminhoImg));
		arma.setBounds(this.posArmX = posX, this.posArmY = posY, larguraImg, alturaImg);
	}

	public ImageIcon getImage() {
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
		if (gatilho && getQtdMunicao() > 0) {
			Bala bala = new Bala(null, 10); // imagem(por hora nula) e qtd dano da bala
		
			System.out.println("DEBUG : ATIROU");
		
			
			bala.setPosicaoInicialBala(getPosArmX(), getPosArmY());
		

			bala.setVelocidadeBalaX(0.1f); // ajudar posteriormente velocidade
			this.qtdMunicao--;

			if (bala.getPosXbala() < Tela.auxLargura || bala.getPosYbala() < Tela.auxAltura) {
				bala = null;

			}

			
		}
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
	
	
	
	
	
	
	
	
	
	
	
	

	// APENAS PARA DEBUGAR, DEPOIS SERA DELETADO.
	public static void main(String[] args) {

		System.out.println("logica arma 1");
		logicaArma1(); // testando opcao metodo da bala atirar1()
		System.out.println("\n\n");
		System.out.println("logica arma 2");
		logicaArma2(); // testando opcao metodo da bala atirar2()

	}

	// funcoes

	public static void logicaArma1() {

		Arma metralhadora = new Arma("Arma1.png", 30, 4); 

		System.out.println(metralhadora.getQtdMunicao());

		System.out.println("Vou atirar!");
		System.out.println("Quantidade de Cartucho: " + metralhadora.getQtdCartucho());

		while (true) {

			metralhadora.atirar1();
			if (metralhadora.getQtdCartucho() > 0) {
				System.out.println("Tiro: " + metralhadora.getQtdMunicao());
			} else {
				break;
			}
			if (metralhadora.getQtdMunicao() <= 1) {
				System.out.println("Tenho que recarregar");
				metralhadora.carregarArma();
				System.out.println("Quantidade de Cartucho: " + metralhadora.getQtdCartucho());
			}
		}
		System.out.println();
		System.out.println("Status quantidade de bala atual: " + metralhadora.getQtdMunicao());
		System.out.println("Status quantidade de Cartucho atual: " + metralhadora.getQtdCartucho());

	}

	public static void logicaArma2() {
		Arma metralhadora = new Arma("Arma1.png", 30, 4); // futuramente tambem pretendo entrar com o
															// sprite

		System.out.println(metralhadora.getPosArmX() + "  " + metralhadora.getPosArmY());
		boolean atirar = true; // ao aperta uma tecla fica true;
		while (true) { // representa "loop principal"
			if (atirar) {
				if (metralhadora.getQtdCartucho() == 0 && metralhadora.getQtdMunicao() == 0) {
					atirar = false;
					System.out.println("\nAcabou os cartuchos.");
				}
				metralhadora.atirar2(atirar);
				if (metralhadora.getQtdMunicao() == 0) {
					metralhadora.carregarArma();
				}

			}
			// atirar = false; // ao soltar uma tecla para de atirar;

		}
	}

}
=======
package connorsRedemption;

import java.applet.AudioClip;
import java.awt.Image;

public class Arma {

	private String nome;
	private Image skin; // por hora -acho- que eh essa variavel que trabalharemos as imagens
	private Image projetil;
	// private double qtdDano; // a classe Bala passou a contror isso.
	private float posArmX;
	private float posArmY;
	private int qtdMunicao;
	private int qtdCartucho;
	private int auxQtdMunicao;

	// private AudioClip rajadaArma; // som ao coletar o item(ainda vou estudar como
	// se faz isso
	// so estou colocando pra nao me esquecer!)

	// private AudioClip carregarArma; // som ao coletar o item(ainda vou estudar
	// como se faz isso
	// so estou colocando pra nao me esquecer!)

	public Arma(String nome, int qtdMunicao, int qtdCartucho /* , double qtdDano */) {
		this.nome = nome;
		this.qtdMunicao = qtdMunicao;
		this.auxQtdMunicao = qtdMunicao;
		this.qtdCartucho = qtdCartucho;
		// this.qtdDano = qtdDano;

	}

	public void setProjetil(Image projetil) {
		this.projetil = projetil;
	}

	/*
	 * public double getQtdDano(float qtdDano) { return this.qtdDano; }
	 */

	public void setPosXY(float posX, float posY) {
		this.posArmX = posX;
		this.posArmY = posY;
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

	public void atirar1() {
		if (getQtdMunicao() > 0) { // || getQtdCartucho() > 0)
			// ativar audioClip rajadaArma
			this.qtdMunicao--;

		}
	}

	public void atirar2(boolean gatilho) {
		// if (getQtdMunicao() > 0) { // || getQtdCartucho() > 0)
		if (gatilho && getQtdMunicao() > 0) {
			Bala bala = new Bala(null, 10); // imagem(por hora nula) e qtd dano da bala
			bala.setPosicaoInicialBala(getPosArmX(), getPosArmY());

			bala.setVelocidadeBalaX(0.1f); // ajudar posteriormente velocidade
			// ativar audioClip rajadaArma
			System.out.println("DEBUG : ATIROU");
			this.qtdMunicao--;

			if (bala.getPosXbala() < Tela.auxLargura || bala.getPosYbala() < Tela.auxAltura) {
				bala = null;

			}

			// }
		}
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
			// throw new RuntimeException("Acabou qtd recarga (cartucho)");
			System.out.println("Acabou qtd recarga (cartucho)"); // para debugar
			this.qtdCartucho = 0; // por prevencao, para nao ficar negativando o cartucho.
			

		}
	}

}
>>>>>>> 6919f0c56ad1eb364ba5eb491e99985d83f4fe30
