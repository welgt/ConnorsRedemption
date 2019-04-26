package connorsRedemption;

import java.awt.Image;

public class Arma {

	private String nome;
	private Image skin; // por hora acho que eh essa variavel que trabalharemos as imagens
	private Image projetil;
	private double qtdDano;
	private double posX;
	private double posY;
	private int qtdMunicao;
	private int qtdCartucho;
	private int auxQtdMunicao;

	public Arma(String nome, int qtdMunicao, int qtdCartucho, double qtdDano) {
		this.nome = nome;
		this.qtdMunicao = qtdMunicao;
		this.auxQtdMunicao = qtdMunicao;
		this.qtdCartucho = qtdCartucho;
		this.qtdDano = qtdDano;

	}

	public void setProjetil(Image projetil) {
		this.projetil = projetil;
	}

	public double getQtdDano(float qtdDano) {
		return this.qtdDano;
	}


	public void setPosXY(float posX, float posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public double getPosX() {
		return this.posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return this.posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getQtdMunicao() {
		return this.qtdMunicao;
	}

	public int getQtdCartucho() {
		return this.qtdCartucho;
	}

	public void atirar() {
		if (getQtdMunicao() > 0 ) { //|| getQtdCartucho() > 0)
			this.qtdMunicao--;
		}
	}

	public void carregar() {

		if (this.getQtdCartucho() >= 1) {
			this.qtdCartucho --;
			this.qtdMunicao = this.auxQtdMunicao; // nao deixa estourar a quantidade de bala. e adapta-se em qualquer valor
			                                      // no parametro "qtdMunicao"do construtor.
			System.out.println("Recarreguei : " + getQtdMunicao()); // para debugar
			
		}

		if (this.qtdCartucho <= 0) { // quando acabar teremos que adicionar a coleta de item de recarga de cartucho.
			// throw new RuntimeException("Acabou qtd recarga (cartucho)");
			System.out.println("Acabou qtd recarga (cartucho)"); // para debugar
			this.qtdCartucho = 0; // por prevencao, para nao ficar negativando o cartucho.
		}
	}

	// APENAS PARA DEBUGAR, DEPOIS SERA DELETADO.
	public static void main(String[] args) {

		
		Arma metralhadora = new Arma ("metralhadora",30,4,55.5); // futuramente tambem pretendo entrar com o sprite como parametro
		System.out.println(metralhadora.getQtdMunicao());

		System.out.println("Vou atirar!");
		System.out.println("Quantidade de Cartucho: " + metralhadora.getQtdCartucho());

		while (metralhadora.getQtdMunicao() > 0) { 
			
			metralhadora.atirar();
			if(metralhadora.getQtdCartucho()>0) {
			System.out.println("Tiro: " + metralhadora.getQtdMunicao());
			}else {
				break;
			}
			if (metralhadora.getQtdMunicao() <= 1) {
				System.out.println("Tenho que recarregar");
				metralhadora.carregar();
				System.out.println("Quantidade de Cartucho: " + metralhadora.getQtdCartucho());
			}
		}
		System.out.println();
		System.out.println("Status quantidade de bala atual: " + metralhadora.getQtdMunicao());
		System.out.println("Status quantidade de Cartucho atual: " + metralhadora.getQtdCartucho());

	}

}
