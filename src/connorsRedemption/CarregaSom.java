package connorsRedemption;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class CarregaSom implements java.applet.AudioClip{
	
	private AudioData audioDados;
	private AudioDataStream audioStream;
	private ContinuousAudioDataStream audioStreamContinuado;
	
	public CarregaSom() {
		this.audioDados = audioDados();
		this.audioStream = null;
		this.audioStreamContinuado = null;
		
	}
	
	private AudioData audioDados() {
		try {
			FileInputStream fis = new FileInputStream("C:\\workspace\\ConnorsRedemption\\res\\audio\\music\\Star_Commander1.wav");
			AudioStream audioStream = new AudioStream(fis);
			AudioData audioData = audioStream.getData();
			return audioData;
			
		} catch(Exception e){
			//throw new IllegalArgumentException("Não foi possível carregar o arquivo ", e);
			e.printStackTrace();
			throw new IllegalArgumentException("Não foi possível carregar o arquivo ", e);
		}
	}

	@Override
	public void loop() {
		this.audioStreamContinuado = new ContinuousAudioDataStream(this.audioDados);
	    AudioPlayer.player.start(this.audioStreamContinuado);
		
	}

	@Override
	public void play() {
		this.audioStream = new AudioDataStream(this.audioDados);
	    AudioPlayer.player.start(this.audioStream);
		
	}

	@Override
	public void stop() {
		if (this.audioStream != null) {
			AudioPlayer.player.stop(this.audioStream);
		}
	    if (this.audioStreamContinuado != null) {
	    	AudioPlayer.player.stop(this.audioStreamContinuado);
	    }
	}

}