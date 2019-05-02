package connorsRedemption;

import java.awt.Color;
import java.awt.Graphics2D;

public class ConnorsRedemption extends Game{
	
	private int x;
	private int y;
	private int velX;
	private int velY;
	
	public void onCarregar() {
		this.x = 0;
		this.y = 0;
		this.velX = 1;
		this.velY = 1;
		
	}
	
	public void onDescarregar() {
		
	}
	
	public void onAtualizar() {
		this.x += this.velX;
		this.y += this.velY;
		
		if(this.x < 0 || this.x > this.getWidth()) {
			this.velX *= -1;
		}
		if(this.y < 0 || this.y > this.getHeight()) {
			this.velY *= -1;
		}
	}
	
	public void onDesenhar(Graphics2D g) {
		
		g.setColor(Color.WHITE);
		g.drawOval(this.x, this.y, 10, 10);
	}

}
