package connorsRedemption;

public class TelaScore extends Tela{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int pontuacaoFinal;
	public int qtdVidaFinal;
	public int qtdInimigosDerrotados;
	
	public TelaScore() {
		this.pontuacaoFinal = 0;
		this.qtdVidaFinal = 0;
		this.qtdInimigosDerrotados = 0;
	}

	public int getPontuacaoFinal() {
		return pontuacaoFinal;
	}

	public void setPontuacaoFinal(int pontuacaoFinal) {
		this.pontuacaoFinal = pontuacaoFinal;
	}

	public int getQtdVidaFinal() {
		return qtdVidaFinal;
	}

	public void setQtdVidaFinal(int qtdVidaFinal) {
		this.qtdVidaFinal = qtdVidaFinal;
	}

	public int getQtdInimigosDerrotados() {
		return qtdInimigosDerrotados;
	}

	public void setQtdInimigosDerrotados(int qtdInimigosDerrotados) {
		this.qtdInimigosDerrotados = qtdInimigosDerrotados;
	}
	
	
}
