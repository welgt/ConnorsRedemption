package connorsRedemption;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConnorsRedemption extends Game implements KeyListener {
	
	private CarregaImagem imagens;
	private Jogador connor;
	private Bala bala;
	private Personagem inimigo;
	//private Fase fase1;
	private int cont;
	//private CarregaSom som;
	
	public ConnorsRedemption() {
		this.getJanelaPrincipal().addKeyListener(this);
		this.connor = null;
		this.bala = null;
		this.inimigo = null;
		//this.fase1 = null;
		this.cont = 1;
	}
	
	public void onCarregar() {
		this.imagens = new CarregaImagem();
		this.connor = new Jogador("Connor", imagens.getImgConnor(), imagens.getImgTiro());
		this.inimigo = new Inimigo("Inimigo1", imagens.getImgInimigo());
		//this.fase1 = new Fase(imagens.getImgMapa());
		//this.som = new CarregaSom();
		//som.loop();
		this.inimigo.setPosX(500.0);
		this.inimigo.setPosY(500.0);
	}
	
	public void onDescarregar() {
		//som.stop();
		
	}
	
	public void onAtualizar() {

		this.inimigo.andarEsquerda();
		if(this.bala != null) {
			if(!this.bala.colidiuTela()) {
				if(this.bala.getDirecao() == 'd') {
					this.bala.setPosicaoInicialBala(this.bala.getPosXbala()+0.05, this.bala.getPosYbala());
				}
				if(this.bala.getDirecao() == 'b') {
					this.bala.setPosicaoInicialBala(this.bala.getPosXbala(), this.bala.getPosYbala()+0.05);
				}
				if(this.bala.getDirecao() == 'e') {
					this.bala.setPosicaoInicialBala(this.bala.getPosXbala()-0.05, this.bala.getPosYbala());
				}
				if(this.bala.getDirecao() == 'c') {
					this.bala.setPosicaoInicialBala(this.bala.getPosXbala(), this.bala.getPosYbala()-0.05);
				}
			}else{
				
				this.bala.setPosImgBala(3);
				if(this.cont % 300 == 0) {
					this.bala = null;
					this.cont = 1;
				}
				this.cont++;
			}
		}
	}
	
	public void onDesenhar(Graphics2D g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//g.drawImage(this.fase1.getSubFaseImg(), this.fase1.getRotacao(), null);
		g.drawImage(this.connor.getImagem(), this.connor.getRotacao(), null);
		if(this.bala != null) {
			g.drawImage(this.bala.getImgBala(), this.bala.getRotacao(), null);
		}
		g.drawImage(this.inimigo.getImagem(), this.inimigo.getRotacao(), null);
		
	}
	
	public void keyTyped(KeyEvent e) {
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				connor.andarCima();
				break;
			case KeyEvent.VK_DOWN:
				connor.andarBaixo();
				break;
			case KeyEvent.VK_LEFT:
				connor.andarEsquerda();
				break;
			case KeyEvent.VK_RIGHT:
				connor.andarDireita();
				break;
			case KeyEvent.VK_SPACE:
				bala = connor.atirar();
				break;
			case KeyEvent.VK_ESCAPE:
				this.finalizar();
				break;
		}

	}
	
	public void keyReleased(KeyEvent e) {
	}
	

}