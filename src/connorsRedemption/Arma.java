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

			
			System.out.println("teste merge git");
		}
	}

}
