package connorsRedemption;

public class TelaHistoria extends Tela{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensagem;
	private boolean btPular;
	
	public TelaHistoria() {
		this.mensagem = "";
		this.btPular = false;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean isBtPular() {
		return btPular;
	}

	public void setBtPular(boolean btPular) {
		this.btPular = btPular;
	}

}
