package connorsRedemption;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Jogo implements KeyListener{
	private boolean jogoAtivo;
	private final Tela tela;
	
	public Jogo() {
		this.jogoAtivo = true;
		tela = new Tela();
		
	}
	
	public boolean isJogoAtivo() {
		return jogoAtivo;
	}

	public void setJogoAtivo(boolean jogoAtivo) {
		this.jogoAtivo = jogoAtivo;
	}

	public void processaLogica() {
		
	}
	
	public void processaGrafico() {
		
		
	}
	
	@Override
	 public void keyTyped(KeyEvent e) {


	 }
	 @Override
	 public void keyPressed(KeyEvent e) {
	 System.out.println("Pressionei a tecla:"+e.getKeyChar());

	 }
	 @Override
	 public void keyReleased(KeyEvent e) {
	 System.out.println("Liberei a tecla:"+e.getKeyChar());
	 }

}
