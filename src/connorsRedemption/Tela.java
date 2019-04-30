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
	
	public Tela() {
		super();
		this.altura = 800;
		this.largura = 600;
		
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
        /*
        // limpa a janela
        Dimension d = this.getSize();
        g.setColor(Color.BLUE);
        g.fillOval((int) floor(d.getWidth()/2)-50,(int) floor(d.getHeight()/2)-25,50,50);
        */
        
        //g.setColor(Color.BLACK);
        //g.fillRect(750, 550, 50, 50);
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);
        
        //g.setColor(Color.DARK_GRAY);
        //g.fillOval(150,200,200,40);
        
        //g.setColor(Color.RED);
        //g.fillOval(100,80,150,150);
        
        //g.setColor(Color.PINK);
        //g.fillOval(120,105,30,30);
        
        //g.setColor(Color.BLUE);
        //g.setFont(new Font("Arial Bold", Font.PLAIN, 36));
        //g.drawString("Projeto Integrador III", 30,450);
        
        CarregaImagem img = new CarregaImagem();
        
        g.drawImage(img.connor, 0, 0, 120, 120, 0, 0, 120, 120, null);
        
    }
	
}
