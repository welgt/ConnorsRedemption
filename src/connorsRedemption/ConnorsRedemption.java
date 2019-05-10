package connorsRedemption;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConnorsRedemption extends Game implements KeyListener {
	
	private int velX;
	private int velY;
	private Personagem jogador;
	
	public ConnorsRedemption() {
		this.getJanelaPrincipal().addKeyListener(this);
	}
	
	public void onCarregar() {
		this.velX = 1;
		this.velY = 1;
		this.jogador = new Jogador("Connor");
		
	}
	
	public void onDescarregar() {
		
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
		
		//g.setColor(Color.WHITE);
		//g.drawOval(this.x, this.y, 10, 10);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.transform(this.jogador.getRotacao());
		g.drawImage(this.jogador.getImagem(), this.jogador.getPosX(), this.jogador.getPosY(), null);
		
	}
	
	public void keyTyped(KeyEvent e) {
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				jogador.andarCima();;
				break;
			case KeyEvent.VK_DOWN:
				jogador.andarBaixo();;
				break;
			case KeyEvent.VK_LEFT:
				jogador.andarEsquerda();;
				break;
			case KeyEvent.VK_RIGHT:
				jogador.andarDireita();;
				break;
			case KeyEvent.VK_ESCAPE:
				this.finalizar();
				break;
		}

	}
	
	public void keyReleased(KeyEvent e) {
	}
	

}
