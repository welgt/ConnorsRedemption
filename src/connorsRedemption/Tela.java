package connorsRedemption;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tela extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int altura;
	private final int largura;
	
	public Tela() {
		this.altura = 800;
		this.largura = 600;
		
		JFrame frame = new JFrame("Connor's Redemption");

        frame.setSize(this.altura, this.largura);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);//desabilita maximizar janela
        frame.setVisible(true);
        frame.add(this); // adiciona o JPanel na janela
        setFocusable(true); // permite o JPanel receber o os eventos

        this.setBackground( Color.white ); // muda cor de fundo do JPanel
	}
	
	public int getAltura() {
		return this.altura;
	}
	
	public int getLargura() {
		return this.largura;
	}
	
}
