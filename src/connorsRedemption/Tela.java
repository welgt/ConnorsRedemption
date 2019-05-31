package connorsRedemption;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tela extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int altura;
	private final int largura;
	
	public static int auxAltura;  // criei para acessar esses valores sem ter que instaciar novo objeto.
	public static int auxLargura; // criei para acessar esses valores sem ter que instaciar novo objeto.
	                              // dessa forma o jogo podera ser redimensionado e nao afetara a logica futuramente 
	                     // por exemplo, estou destruindo a bala quando ela sai da tela(nao visivel para o jogador)
	
	
	public Tela() {
		super();
		this.altura = 800;
		this.largura = 600;
		
		this.auxAltura = altura;   // criei para acessar esses valores sem ter que instaciar novo objeto.
		this.auxLargura = largura; // criei para acessar esses valores sem ter que instaciar novo objeto.
								   // dessa forma o jogo podera ser redimensionado e nao afetara a logica futuramente
		                 // por exemplo, estou destruindo a bala quando ela sai da tela(nao visivel para o jogador)
		
		JFrame frame = new JFrame("Connor's Redemption");

        frame.setSize(this.altura, this.largura);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);//desabilita maximizar janela
        frame.add(this); // adiciona o JPanel na janela
        frame.setVisible(true);
        setFocusable(true); // permite o JPanel receber o os eventos

        this.setBackground( Color.WHITE ); // muda cor de fundo do JPanel
	}
	
	public int getAltura() {
		return this.altura;
	}
	
	public int getLargura() {
		return this.largura;
	}
	
	@Override
    public void paint(Graphics g){
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);
        
        CarregaImagem img = new CarregaImagem();
        
        g.drawImage(img.connor, 0, 0, 120, 120, 0, 0, 120, 120, null);
        
    }
	
}
