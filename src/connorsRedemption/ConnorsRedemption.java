package connorsRedemption;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConnorsRedemption extends Game implements KeyListener {
	
	private CarregaImagem imagens;
	private Jogador connor;
	private Bala bala;
	private Inimigo inimigo;
	//private Fase fase1;
	//private CarregaSom som;
	private Vida coracao;
	
	public ConnorsRedemption() {
		this.getJanelaPrincipal().addKeyListener(this);
		this.connor = null;
		this.bala = null;
		this.inimigo = null;
		//this.fase1 = null;
		this.coracao = null;
	}
	
	public void onCarregar() {
		this.imagens = new CarregaImagem();
		this.connor = new Jogador("Connor", imagens.getImgConnor(), imagens.getImgTiro());
		this.inimigo = new Inimigo("Inimigo1", imagens.getImgInimigo());
		//this.fase1 = new Fase(imagens.getImgMapa());
		//this.som = new CarregaSom();
		//som.loop();
		this.coracao = new Vida("coracao", imagens.getImgCoracao(), 0,0);
		this.onStart();
	}
	
	public void onDescarregar() {
		//som.stop();
		
	}
	
	// toda logica que não deve ser atualizada.
	public void onStart() {
    	
		this.coracao.trasladar(Math.random()*(getHeight()-150), Math.random()*(getWidth()-50));
		
	}
	
	public void onAtualizar() {
		

		this.inimigo.setCont(this.inimigo.getCont() + 1);
		boolean colisao = this.inimigo.colidiuBala(bala);
		
		if(colisao) {
			this.inimigo = new Inimigo("Inimigo1", imagens.getImgInimigo());
		}
		if(this.inimigo.getCont() % 400 == 0) {
			this.inimigo.andarEsquerda();
			this.inimigo.setCont(0);
		}
		
		if(this.bala != null) {
			if(!this.bala.colidiuTela() && !colisao) {
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
				this.bala.setCont(this.bala.getCont() + 1);
				this.bala = null;
			}
		}
		
		ativaCoracao();

		
	
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
		g.drawImage(this.coracao.getImgItem(), this.coracao.getRotacao(), null);
		
		
	}
	
	public void keyTyped(KeyEvent e) {
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				this.connor.andarCima();
				break;
			case KeyEvent.VK_DOWN:
				this.connor.andarBaixo();
				break;
			case KeyEvent.VK_LEFT:
				this.connor.andarEsquerda();
				break;
			case KeyEvent.VK_RIGHT:
				this.connor.andarDireita();
				break;
			case KeyEvent.VK_SPACE:
				this.bala = connor.atirar();
				break;
			case KeyEvent.VK_ESCAPE:
				this.finalizar();
				break;
		}

	}
	
	public void keyReleased(KeyEvent e) {
	}
	
	
	
	
	
	
	
	// funcoes separadas da logica de cada objeto para manter organizado
	public void ativaCoracao() {
		
        if(coracao.colidiu(coracao, connor)) {
        	double randowA = Math.random()*(getHeight()-150);
        	double randowL = Math.random()*(getWidth()-50);
        	//this.coracao = new Vida("coracao", imagens.getImgCoracao(), randowL,randowA);
        	this.coracao.trasladar(randowL, randowA);
        	coracao.darVida(connor);
        	System.out.println(connor.getVida());
        }
	}
	

}