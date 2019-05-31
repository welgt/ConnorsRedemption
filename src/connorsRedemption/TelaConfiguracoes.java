package connorsRedemption;

public class TelaConfiguracoes extends Tela{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int controle;
	private boolean MusicaLigada;
	private float volumeMusica;
	private boolean somLigado;
	private float volumeSom;
	
	public TelaConfiguracoes() {
		this.controle = 1;
		this.MusicaLigada = true;
		this.volumeMusica = 50f;
		this.somLigado = true;
		this.volumeSom = 50;
	}

	public int getControle() {
		return controle;
	}

	public void setControle(int controle) {
		this.controle = controle;
	}

	public boolean isMusicaLigada() {
		return MusicaLigada;
	}

	public void setMusicaLigada(boolean musicaLigada) {
		MusicaLigada = musicaLigada;
	}

	public float getVolumeMusica() {
		return volumeMusica;
	}

	public void setVolumeMusica(float volumeMusica) {
		this.volumeMusica = volumeMusica;
	}

	public boolean isSomLigado() {
		return somLigado;
	}

	public void setSomLigado(boolean somLigado) {
		this.somLigado = somLigado;
	}

	public float getVolumeSom() {
		return volumeSom;
	}

	public void setVolumeSom(float volumeSom) {
		this.volumeSom = volumeSom;
	}
	
}
