package connorsRedemption;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Arma {

	private String nome;
	private ImageIcon imagemArma;
	private JLabel arma = new JLabel(imagemArma);
	// private double qtdDano; // a classe Bala passou a contror isso.
	private int posArmX;
	private int posArmY;
	private int qtdMunicao;
	private int qtdCartucho;
	private int auxQtdMunicao;

	// private AudioClip rajadaArma; // som ao coletar o item(ainda vou estudar como
	// se faz isso
	// so estou colocando pra nao me esquecer!)

	// private AudioClip carregarArma; // som ao coletar o item(ainda vou estudar
	// como se faz isso
	// so estou colocando pra nao me esquecer!)

	public Arma(String CaminhoImg, String nome, int qtdMunicao, int qtdCartucho /* , double qtdDano */) {

		this.imagemArma = new ImageIcon(getClass().getResource(CaminhoImg));
		this.nome = nome;
		this.qtdMunicao = qtdMunicao;
		this.auxQtdMunicao = qtdMunicao;
		this.qtdCartucho = qtdCartucho;

	}

	public void setPosArma(int posX, int posY, int larguraImg, int alturaImg) {
		arma.setBounds(this.posArmX = posX, this.posArmY = posY, larguraImg, alturaImg);

	}

	public ImageIcon getImage() {
		return this.imagemArma;

	}

	public void somTiro(boolean tocar) {
		JButton escuta = new JButton();
		escuta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tocar) {
					play();
				}
			}
		});

	}

	public void play() {
		URL som = getClass().getResource("tiro1.wav");
		AudioClip audio = Applet.newAudioClip(som);
		audio.play();
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
		if (getQtdMunicao() > 0) {
			// ativar audioClip rajadaArma
			this.qtdMunicao--;

		}
	}

	public void atirar2(boolean gatilho) {
		if (gatilho && getQtdMunicao() > 0) {
			Bala bala = new Bala(null, 10); // imagem(por hora nula) e qtd dano da bala
			System.out.println("DEBUG : ATIROU");
			somTiro(true);
			System.out.println("liga som do tiro.");
			bala.setPosicaoInicialBala(getPosArmX(), getPosArmY());
			somTiro(false);
			System.out.println("desliga som do tiro.");
			bala.setVelocidadeBalaX(0.1f); // ajudar posteriormente velocidade
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
			this.qtdCartucho = 0; // por prevencao, para nao ficar negativando o cartucho.

		}
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

	public static void testaSangue() {

		Sangue itemSangue = new Sangue("Sangue", null, Tela.auxLargura / 2, Tela.auxAltura / 2);
		itemSangue.detectarColisao("Connors", 1.0f, 1.0f);
	}

	public static void logicaArma1() {

		Arma metralhadora = new Arma("Arma1.png", "metralhadora", 30, 4); // futuramente tambem pretendo entrar com o
																			// sprite
		// como parametro

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
		Arma metralhadora = new Arma("Arma1.png", "metralhadora", 30, 4); // futuramente tambem pretendo entrar com o
																			// sprite

		metralhadora.setPosArma(15, 10, 300, 300);
		System.out.println(metralhadora.getPosArmX() + "  " + metralhadora.getPosArmY());
		boolean atirar = true; // ao aperta uma tecla fica true;
		while (true) { // representa "loop principal"
			if (atirar) {
				if (metralhadora.getQtdCartucho() == 0 && metralhadora.getQtdMunicao()==0) {
					atirar = false;
					System.out.println("\nAcabou os cartuchos.");
				}
				metralhadora.atirar2(atirar);
				if (metralhadora.getQtdMunicao() == 0) {
					metralhadora.carregarArma();
				}

			}
			// atirar = false; // ao soltar uma tecla fica false;

		}
	}

}