package connorsRedemption;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConnorsRedemption extends Game implements KeyListener {
	
	private int x;
	private int y;
	private int velX;
	private int velY;
	private CarregaImagem img;
	
	public ConnorsRedemption() {
		this.getJanelaPrincipal().addKeyListener(this);
	}
	
	public void onCarregar() {
		this.x = 0;
		this.y = 0;
		this.velX = 1;
		this.velY = 1;
		this.img = new CarregaImagem();
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
		g.drawImage(img.connor, this.x, this.y, null);
		
	}
	
	public void keyTyped(KeyEvent e) {
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				this.y -= 10;
				break;
			case KeyEvent.VK_DOWN:
				this.y += 10;
				break;
			case KeyEvent.VK_LEFT:
				this.x -= 10;
				break;
			case KeyEvent.VK_RIGHT:
				this.x += 10;
				break;
			case KeyEvent.VK_ESCAPE:
				this.finalizar();
				break;
		}

	}
	
	public void keyReleased(KeyEvent e) {
	}
	

}
