package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	Clip clip;
	URL soundURL[] = new URL[20];
	
	public Sound() {
		
		soundURL[0] = getClass().getResource("/sound/Forest.wav");
		soundURL[1] = getClass().getResource("/sound/blocked.wav");
		soundURL[2] = getClass().getResource("/sound/dooropen.wav");
		soundURL[3] = getClass().getResource("/sound/powerup.wav");
		soundURL[4] = getClass().getResource("/sound/coin.wav");
		soundURL[5] = getClass().getResource("/sound/receivedamage.wav");
		soundURL[6] = getClass().getResource("/sound/hitmonster.wav");
		soundURL[7] = getClass().getResource("/sound/title.wav");
		soundURL[8] = getClass().getResource("/sound/Coast.wav");
		soundURL[9] = getClass().getResource("/sound/speak.wav");
		soundURL[10] = getClass().getResource("/sound/gameover.wav");
		soundURL[11] = getClass().getResource("/sound/stairs.wav");
		soundURL[12] = getClass().getResource("/sound/Dungeon.wav");
		soundURL[13] = getClass().getResource("/sound/final.wav");
		soundURL[14] = getClass().getResource("/sound/finish.wav");
		soundURL[15] = getClass().getResource("/sound/burning.wav");
		soundURL[16] = getClass().getResource("/sound/endsong.wav");
		//swingsword sfx
	}
	
	public void setFile(int i) {
		
		try {
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			
		}
		catch(Exception e){
			
			
			
		}
		
	}
	
	public void play() {
		
		clip.start();
		
	}
	
	public void loop() {
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		
		clip.stop();
		
	}

}
