import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;

public class Music {
	
	public static void play() throws Exception {
		
		//String path = "C:\\Users\\Jim\\Java Work\\Game of Life 2\\bin\\GOL-Music.wav";
		//String path = "/audio/GOL-Music.wav";
		URL path = Music.class.getResource("/audio/GOL-Music.wav");
		//URL musicURL = Game.class.getResource("/res/audio/GOL-Music.wav");
		//InputStream is = Class.class.getResourceAsStream("/resources/GOL-Music.wav");
		//String path = "\\resources\\GOL-Music.wav";
		
		/*
		InputStream is = Class.class.getResourceAsStream("/resources/GOL-Music.wav");        
	    InputStreamReader isr = new InputStreamReader(is);
	    BufferedReader br = new BufferedReader(isr);
	    StringBuilder sb = new StringBuilder();
	    String line;
	    while((line = br.readLine()) != null) {
	        sb.append(line).append("\n");
	    }
	    System.out.println(sb.toString());
	    */
		
		//File soundFile = new File(path);
		//File soundFile = new File();
		Clip music = AudioSystem.getClip();
		AudioInputStream ais = AudioSystem.getAudioInputStream(path);
		music.open(ais);
		music.loop(Clip.LOOP_CONTINUOUSLY);
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				
			}
		});
		
	}
	
}