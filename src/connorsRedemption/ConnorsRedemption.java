package connorsRedemption;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConnorsRedemption extends Game implements KeyListener {
	
	private CarregaImagem imagens;
	private Jogador connor;
	private Fase fase1;
	//private CarregaSom som;
	
	public ConnorsRedemption() {
		this.getJanelaPrincipal().addKeyListener(this);
		this.connor = null;
		this.fase1 = null;
	}
	
	public void onCarregar() {
		this.imagens = new CarregaImagem();
		this.connor = new Jogador("Connor", imagens.getImgConnor());
		this.fase1 = new Fase(imagens.getImgMapa());
		//this.som = new CarregaSom();
		//som.loop();
	}
	
	public void onDescarregar() {
		//som.stop();
		
	}
	
	public void onAtualizar() {
		/*
		this.x += this.velX;
		this.y += this.velY;
		
		if(this.x < 0 || this.x > this.getWidth()) {
			this.velX *= -1;
		}
		if(this.y < 0 || this.y > this.getHeight()) {
			this.velY *= -1;
		}
		*/
	}
	
	public void onDesenhar(Graphics2D g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.drawImage(fase1.getSubFaseImg(), fase1.getRotacao(), null);
		g.drawImage(connor.getImagem(), connor.getRotacao(), null);
		
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
			case KeyEvent.VK_ESCAPE:
				this.finalizar();
				break;
		}

	}
	
	public void keyReleased(KeyEvent e) {
	}
	

}