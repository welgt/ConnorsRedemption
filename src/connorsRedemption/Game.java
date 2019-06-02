package connorsRedemption;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

abstract public class Game implements WindowListener{
	
	private JFrame janelaPrincipal;
	private boolean jogoAtivo;
	private BufferStrategy bufferStrategy;
	
	public Game() {
		this.janelaPrincipal = new JFrame("Connors Redemption");
		this.janelaPrincipal.setSize(800,600);
		this.janelaPrincipal.addWindowListener(this);
		this.jogoAtivo = false;
	}
	
	public void finalizar() {
		this.jogoAtivo = false;
	}
	
	public void executar() {
		this.jogoAtivo = true;
		
		this.carregar();
		
		while(this.jogoAtivo) {
			this.atualizar();
			this.desenhar();
			
		}
		
		this.descarregar();
	}
	
	public void carregar() {
		this.janelaPrincipal.setIgnoreRepaint(true);
		this.janelaPrincipal.setLocationRelativeTo(null);
		this.janelaPrincipal.setVisible(true);
		this.janelaPrincipal.createBufferStrategy(2);
		this.bufferStrategy = this.janelaPrincipal.getBufferStrategy();
		
		this.onCarregar();
	}
	
	public void descarregar() {
		this.onDescarregar();
		
		this.bufferStrategy.dispose();
		this.janelaPrincipal.dispose();
	}
	
	public void atualizar() {
		onAtualizar();
		Thread.yield();
	}
	
	public void desenhar() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.janelaPrincipal.getWidth(), this.janelaPrincipal.getHeight());
		
		this.onDesenhar(g);
		
		g.dispose();
		
		this.bufferStrategy.show();
	}
	
	public int getWidth() {
		return janelaPrincipal.getWidth();
	}
	
	public int getHeight() {
		return janelaPrincipal.getHeight();
	}
	
	public JFrame getJanelaPrincipal() {
		return this.janelaPrincipal;
	}
	
	abstract public void onCarregar();
	
	abstract public void onDescarregar();
	
	abstract public void onAtualizar();
	
	abstract public void onDesenhar(Graphics2D g);

	public void windowClosing(WindowEvent e) {
		this.finalizar();
	}
	
	public void windowOpened(WindowEvent e) {
		
	}
	
	public void windowClosed(WindowEvent e) {
		
	}
	
	public void windowIconified(WindowEvent e) {
		
	}
	
	public void windowDeiconified(WindowEvent e) {
		
	}
	
	public void windowActivated(WindowEvent e) {
		
	}
	
	public void windowDeactivated(WindowEvent e) {
		
	}

}
