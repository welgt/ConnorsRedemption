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
	
	private Item arma1;
	private Item arma2;
	
	private Item caixaItemTopDir1;
	private Item caixaItemTopDir2;
	private Item caixaItemTopDir3;
	
	//HUD
	private Item baseHudEsq;
	private Item baseHudDir;
	private Item frenteCoracaoHud1;
	private Item frenteCoracaoHud2;
	private Item frenteCoracaoHud3;
	private Item armaHud1;
	private Item armaHud2;
	
	private double posXcaixaItem1 = Math.random() * (getWidth() - 50);
	private double posYcaixaItem1 = Math.random() * (getHeight() - 150);
	private double posXcaixaItem2 = Math.random() * (getWidth() - 50);
	private double posYcaixaItem2 = Math.random() * (getHeight() - 150);
	private double posXcaixaItem3 = Math.random() * (getWidth() - 50);
	private double posYcaixaItem3 = Math.random() * (getHeight() - 150);
	
	private boolean caixaDestruida1; // tentei usar a mesma boleana pra todas cxs mas deu muito b.o
	private boolean caixaDestruida2;
	private boolean caixaDestruida3;
	
	private Fase fase1;

	public ConnorsRedemption() {
		this.getJanelaPrincipal().addKeyListener(this);
		this.connor = null;
		this.bala = null;
		this.inimigo = null;
		// this.fase1 = null;

		this.coracao = null;
		this.arma1 = null;
		this.arma2 = null;
	
		this.baseHudEsq = null;
		this.baseHudDir = null;
		
		this.frenteCoracaoHud1 = null;
		this.frenteCoracaoHud2 = null;
		this.frenteCoracaoHud3 = null;
		
		this.armaHud1 = null;
		this.armaHud2 = null;
		
		this.caixaItemTopDir1 = null;
		this.caixaItemTopDir2 = null;
		this.caixaItemTopDir3 = null;
		
		this.caixaDestruida1 = false;
		this.caixaDestruida2 = false;
		this.caixaDestruida3 = false;
		
		this.fase1 = null;

	}

	public void onCarregar() {
		this.imagens = new CarregaImagem();
		this.connor = new Jogador("Connor", imagens.getImgConnor(), imagens.getImgTiro());
		this.inimigo = new Inimigo("Inimigo1", imagens.getImgInimigo());
		 this.fase1 = new Fase(imagens.getImgMapa());
		// this.som = new CarregaSom();
		// som.loop();

		this.baseHudEsq        = new Item("baseHudEsq", imagens.getBaseHud(), 0, 0);
		this.baseHudDir        = new Item("baseHudDir", imagens.getBaseHud(), 0, 0);
		this.coracao           = new Vida("coracao", imagens.getImgCoracao(), 0, 0);
		this.frenteCoracaoHud1 = new Item("frenteCoracaoHud1", imagens.getFrenteCoracao(), 0, 0);
		this.frenteCoracaoHud2 = new Item("frenteCoracaoHud2", imagens.getFrenteCoracao(), 0, 0);
		this.frenteCoracaoHud3 = new Item("frenteCoracaoHud3", imagens.getFrenteCoracao(), 0, 0);
		this.armaHud1          = new Item("armaHud1",imagens.getArma1(),0,0);
		this.armaHud2          = new Item("armaHud2",imagens.getArma2(),0,0);
		this.arma1             = new Item("arma1",imagens.getArma1(),0,0);
		this.arma2             = new Item("arma2",imagens.getArma2(),0,0);
		this.caixaItemTopDir1  = new Item("caixaItem1", imagens.getcaixaItemTopDir(),0,0);
		this.caixaItemTopDir2  = new Item("caixaItem2", imagens.getcaixaItemTopDir(),0,0);
		this.caixaItemTopDir3  = new Item("caixaItem3", imagens.getcaixaItemTopDir(),0,0);

		this.onStart();
	}

	public void onDescarregar() {
		// som.stop();

	}

	// toda logica que não deve ser atualizada.
	public void onStart() { 
		
		this.baseHudEsq.trasladar(0, 0);
		this.baseHudDir.trasladar(getWidth() - 40, 0);
		
		this.caixaItemTopDir1.  trasladar (this.posXcaixaItem1, this.posYcaixaItem1);
		this.caixaItemTopDir2.  trasladar (this.posXcaixaItem2, this.posYcaixaItem2);
		this.caixaItemTopDir3.  trasladar (this.posXcaixaItem3, this.posYcaixaItem3);
		
		this.coracao.trasladar(this.posXcaixaItem1 , this.posYcaixaItem1);
		this.arma1.  trasladar(this.posXcaixaItem2 , this.posYcaixaItem2);
		this.arma2.  trasladar(this.posXcaixaItem3 , this.posYcaixaItem3);
		
		this.frenteCoracaoHud1.trasladar(getWidth() - 785, getHeight() - 550);
		this.frenteCoracaoHud2.trasladar(getWidth() - 785, getHeight() - 530);
		this.frenteCoracaoHud3.trasladar(getWidth() - 785, getHeight() - 510);
		
	}

	public void onAtualizar() {

		
		colisaoConnorBalaTela();
		ativaCoracaoVida();
		connorPerdeVida();
		colisaoConnorArma();
		colisaoBalaCaixaItem();
		
	}

	public void onDesenhar(Graphics2D g) {

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		g.drawImage(this.fase1.getSubFaseImg(), this.fase1.getRotacao(), null);
		g.drawImage(this.connor.getImagem(), this.connor.getRotacao(), null);
		
		if (this.bala != null) {
			g.drawImage(this.bala.getImgBala(), this.bala.getRotacao(), null);
		}
		
		desenhaHud(g);
		g.drawImage(this.inimigo.getImagem(), this.inimigo.getRotacao(), null);
		g.drawImage(this.coracao.getImgItem(), this.coracao.getRotacao(), null);
		
		g.drawImage(this.arma1.getImgItem(),this.arma1.getRotacao(),null);
		g.drawImage(this.arma2.getImgItem(),this.arma2.getRotacao(),null);
		
		g.drawImage(this.caixaItemTopDir1.getImgItem(),this.caixaItemTopDir1.getRotacao(), null);
		g.drawImage(this.caixaItemTopDir2.getImgItem(),this.caixaItemTopDir2.getRotacao(), null);
		g.drawImage(this.caixaItemTopDir3.getImgItem(),this.caixaItemTopDir3.getRotacao(), null);	
		
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

		if (coracao.colidiuCoracao(coracao, connor) && caixaDestruida1) {
			
			//double NewPosXCaixaItem = Math.random() * (getWidth() - 50);
			//double NewPosYCaixaItem = Math.random() * (getHeight() - 150);
			this.caixaItemTopDir1 = new Item("caixaItemTopDir1", null,-100, -100);
			
			if (connor.getVida() <= 2) {
				this.coracao = new Vida("coracao", null, -200, -200);
			}
			
			if (connor.getVida() <= 2) {

				if (connor.getVida() == 2) {
					this.frenteCoracaoHud1 = new Item("coracaoBase1", imagens.getFrenteCoracao(), getWidth() - 785,
							getHeight() - 550);
				}

				if (connor.getVida() == 1) {
					this.frenteCoracaoHud2 = new Item("coracaoBase2", imagens.getFrenteCoracao(), getWidth() - 785,
							getHeight() - 530);
				}

				if (connor.getVida() == 0) {
					this.frenteCoracaoHud3 = new Item("coracaoBase3", imagens.getFrenteCoracao(), getWidth() - 785,
							getHeight() - 510);
					
				}
				connor.ganhaVida(1);
			}
		}
	}

	public void connorPerdeVida() {

		if (connor.colidiuInimigo(inimigo, connor)) {

			if (connor.getVida() == 3) {
				this.frenteCoracaoHud1 = new Item("coracaoBase1", imagens.getBaseCoracao(), getWidth() - 785,
						getHeight() - 550);
			}

			if (connor.getVida() == 2) {
				this.frenteCoracaoHud2 = new Item("coracaoBase2", imagens.getBaseCoracao(), getWidth() - 785,
						getHeight() - 530);
			}

			if (connor.getVida() == 1) {
				this.frenteCoracaoHud3 = new Item("coracaoBase3", imagens.getBaseCoracao(), getWidth() - 785,
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
		g.drawImage(this.armaHud1.getImgItem(),this.armaHud1.getRotacao(),null);
		g.drawImage(this.armaHud2.getImgItem(),this.armaHud2.getRotacao(),null);
		
	}
	
	
	public void colisaoConnorArma() {
		if(connor.colidiuArma(arma1, connor) && caixaDestruida2) {
			
			//double NewPosXCaixaItem = Math.random() * (getWidth() - 50);
			//double NewPosYCaixaItem = Math.random() * (getHeight() - 150);
			
			//this.caixaItemTopDir2.trasladar(NewPosXCaixaItem, NewPosYCaixaItem);
			//this.arma1.trasladar(NewPosXCaixaItem, NewPosYCaixaItem);
			this.caixaItemTopDir2 = new Item("caixaItemTopDir2", null, -300, -300);
			this.arma1 = new Item("arma1", null, -400, -400);
			
			this.armaHud1.trasladar(getWidth()-50, getHeight()-550);
		}
		
		if(connor.colidiuArma(arma2, connor) && caixaDestruida3) {

			//double NewPosXCaixaItem = Math.random() * (getWidth() - 50);
			//double NewPosYCaixaItem = Math.random() * (getHeight() - 150);
			
			this.caixaItemTopDir3 = new Item("caixaItemTopDir3", null, -400, -400);
			this.arma2 = new Item("arma2", null, -500, -500);
			
			this.armaHud2.trasladar(getWidth()-50, getHeight()-530);
			
		}
	}
	
	public void colisaoBalaCaixaItem() {
		if(caixaItemTopDir1.colidiuCaixa(this.caixaItemTopDir1, this.bala)) {
			this.caixaDestruida1 = true;
			this.caixaItemTopDir1 = new Item("caixaItemDir1", null, -500,-500);
		}
		
		if(caixaItemTopDir2.colidiuCaixa(this.caixaItemTopDir2, this.bala)) {
			this.caixaDestruida2 = true;
			this.caixaItemTopDir2 = new Item("caixaItemDir2", null, -600,-600);
		}
		
		if(caixaItemTopDir3.colidiuCaixa(this.caixaItemTopDir3, this.bala)) {
			this.caixaDestruida3 = true;
			this.caixaItemTopDir3 = new Item("caixaItemDir3", null, -700,-700);
		}
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