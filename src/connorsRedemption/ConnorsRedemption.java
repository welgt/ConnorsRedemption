package connorsRedemption;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ConnorsRedemption extends Game implements KeyListener {

	private CarregaImagem imagens;
	private Jogador connor;
	private Bala bala;
	private Inimigo inimigo;
	// private Fase fase1;
	// private CarregaSom som;
	private Vida coracao;
	// private Item HUDbaseCoracao;
	private Item baseHudEsq;
	private Item baseHudDir;
	private Item frenteCoracaoHud1;
	private Item frenteCoracaoHud2;
	private Item frenteCoracaoHud3;
	private Fase fase1;

	public ConnorsRedemption() {
		this.getJanelaPrincipal().addKeyListener(this);
		this.connor = null;
		this.bala = null;
		this.inimigo = null;
		// this.fase1 = null;

		this.coracao = null;
		// this.HUDbaseCoracao = null;
		this.baseHudEsq = null;
		this.baseHudDir = null;
		this.frenteCoracaoHud1 = null;
		this.frenteCoracaoHud2 = null;
		this.frenteCoracaoHud3 = null;
		this.fase1 = null;

	}

	public void onCarregar() {
		this.imagens = new CarregaImagem();
		this.connor = new Jogador("Connor", imagens.getImgConnor(), imagens.getImgTiro());
		this.inimigo = new Inimigo("Inimigo1", imagens.getImgInimigo());
		 this.fase1 = new Fase(imagens.getImgMapa());
		// this.som = new CarregaSom();
		// som.loop();

		this.coracao = new Vida("coracao", imagens.getImgCoracao(), 0, 0);
		this.baseHudEsq = new Item("baseHudEsq", imagens.getBaseHud(), 0, 0);
		this.baseHudDir = new Item("baseHudDir", imagens.getBaseHud(), 0, 0);
		this.frenteCoracaoHud1 = new Item("frenteCoracaoHud1", imagens.getfrenteCoracao(), 0, 0);
		this.frenteCoracaoHud2 = new Item("frenteCoracaoHud2", imagens.getfrenteCoracao(), 0, 0);
		this.frenteCoracaoHud3 = new Item("frenteCoracaoHud3", imagens.getfrenteCoracao(), 0, 0);

		this.onStart();
	}

	public void onDescarregar() {
		// som.stop();

	}

	// toda logica que não deve ser atualizada.
	public void onStart() {

		this.coracao.trasladar(Math.random() * (getHeight() - 150), Math.random() * (getWidth() - 50));

		this.baseHudEsq.trasladar(0, 0);
		this.baseHudDir.trasladar(getWidth() - 40, 0);
		this.frenteCoracaoHud1.trasladar(getWidth() - 760, getHeight() - 550);
		this.frenteCoracaoHud2.trasladar(getWidth() - 760, getHeight() - 530);
		this.frenteCoracaoHud3.trasladar(getWidth() - 760, getHeight() - 510);

	}

	public void onAtualizar() {

		colisaoConnorBalaTela();
		ativaCoracaoVida();
		connorPerdeVida();
	}

	public void onDesenhar(Graphics2D g) {

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		g.drawImage(this.fase1.getSubFaseImg(), this.fase1.getRotacao(), null);
		g.drawImage(this.connor.getImagem(), this.connor.getRotacao(), null);
		if (this.bala != null) {
			g.drawImage(this.bala.getImgBala(), this.bala.getRotacao(), null);
		}
		g.drawImage(this.inimigo.getImagem(), this.inimigo.getRotacao(), null);
		g.drawImage(this.coracao.getImgItem(), this.coracao.getRotacao(), null);

		desenhaHud(g);
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			this.connor.andarCima();
			break;
		case KeyEvent.VK_DOWN:
			this.connor.andarBaixo();
			break;
		case KeyEvent.VK_LEFT:
			this.connor.andarEsquerda();
			break;
		case KeyEvent.VK_RIGHT:
			this.connor.andarDireita();
			break;
		case KeyEvent.VK_SPACE:
			this.bala = connor.atirar();
			break;
		case KeyEvent.VK_ESCAPE:
			this.finalizar();
			break;
		}

	}

	public void keyReleased(KeyEvent e) {

	}

	// funcoes separadas da logica de cada objeto para manter organizado

	public void ativaCoracaoVida() {

		if (coracao.colidiuCoracao(coracao, connor)) {
			double randowA = Math.random() * (getHeight() - 150);
			double randowL = Math.random() * (getWidth() - 50);
			// this.coracao = new Vida("coracao", imagens.getImgCoracao(), randowL,randowA);
			this.coracao.trasladar(randowL, randowA);
			if (connor.getVida() <= 2) {

				if (connor.getVida() == 2) {
					this.frenteCoracaoHud1 = new Item("coracaoBase1", imagens.getfrenteCoracao(), getWidth() - 760,
							getHeight() - 550);
				}

				if (connor.getVida() == 1) {
					this.frenteCoracaoHud2 = new Item("coracaoBase2", imagens.getfrenteCoracao(), getWidth() - 760,
							getHeight() - 530);
				}

				if (connor.getVida() == 0) {
					this.frenteCoracaoHud3 = new Item("coracaoBase3", imagens.getfrenteCoracao(), getWidth() - 760,
							getHeight() - 510);

				}
				connor.ganhaVida(1);
			}
			// System.out.println(connor.getVida());
		}
	}

	public void connorPerdeVida() {

		if (connor.colidiuInimigo(inimigo, connor)) {

			if (connor.getVida() == 3) {
				this.frenteCoracaoHud1 = new Item("coracaoBase1", imagens.getBaseCoracao(), getWidth() - 760,
						getHeight() - 550);
			}

			if (connor.getVida() == 2) {
				this.frenteCoracaoHud2 = new Item("coracaoBase2", imagens.getBaseCoracao(), getWidth() - 760,
						getHeight() - 530);
			}

			if (connor.getVida() == 1) {
				this.frenteCoracaoHud3 = new Item("coracaoBase3", imagens.getBaseCoracao(), getWidth() - 760,
						getHeight() - 510);

			}
			connor.perdeVida();
			// System.out.println("perdeu vida "+connor.getVida());
			this.inimigo = new Inimigo("Inimigo1", imagens.getImgInimigo());

			if (connor.getVida() <= 0) {
				System.out.println("VOCE PERDEU!!!!      "
						+ "<<<Não consegu acessar o metodo finalizar() ou a variavel jogoAtivo>>");
			}
		}
	}

	public void desenhaHud(Graphics2D g) {

		g.drawImage(this.baseHudDir.getImgItem(), this.baseHudDir.getRotacao(), null);
		g.drawImage(this.baseHudEsq.getImgItem(), this.baseHudEsq.getRotacao(), null);

		g.drawImage(this.frenteCoracaoHud1.getImgItem(), this.frenteCoracaoHud1.getRotacao(), null);
		g.drawImage(this.frenteCoracaoHud2.getImgItem(), this.frenteCoracaoHud2.getRotacao(), null);
		g.drawImage(this.frenteCoracaoHud3.getImgItem(), this.frenteCoracaoHud3.getRotacao(), null);
	}

	public void colisaoConnorBalaTela() {
		this.inimigo.setCont(this.inimigo.getCont() + 1);
		boolean colisao = this.inimigo.colidiuBala(bala);

		if (colisao) {

			this.inimigo = new Inimigo("Inimigo1", imagens.getImgInimigo());
		}
		if (this.inimigo.getCont() % 400 == 0) {
			this.inimigo.andarEsquerda();
			this.inimigo.setCont(0);
		}

		if (this.bala != null) {
			if (!this.bala.colidiuTela() && !colisao) {
				if (this.bala.getDirecao() == 'd') {
					this.bala.setPosicaoInicialBala(this.bala.getPosXbala() + 0.05, this.bala.getPosYbala());
				}
				if (this.bala.getDirecao() == 'b') {
					this.bala.setPosicaoInicialBala(this.bala.getPosXbala(), this.bala.getPosYbala() + 0.05);
				}
				if (this.bala.getDirecao() == 'e') {
					this.bala.setPosicaoInicialBala(this.bala.getPosXbala() - 0.05, this.bala.getPosYbala());
				}
				if (this.bala.getDirecao() == 'c') {
					this.bala.setPosicaoInicialBala(this.bala.getPosXbala(), this.bala.getPosYbala() - 0.05);
				}
			} else {
				this.bala.setPosImgBala(3);
				this.bala.setCont(this.bala.getCont() + 1);
				this.bala = null;
			}
		}
	}
}