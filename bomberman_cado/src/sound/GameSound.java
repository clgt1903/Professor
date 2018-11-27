package sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.HashMap;

public class GameSound {
	public static GameSound instance;

	public static final String BGMMENU = "bgmmenu.wav";
	public static final String BGMIG = "bgmig.wav";
	public static final String ADDBOMB = "addbomb.wav";
	public static final String DEAD = "dead.wav";
	public static final String MONSTER_DIE = "monsterdie.wav";
	public static final String BOMBEXPLORE = "bombexplore.wav";
	public static final String ITEM = "item.wav";
	public static final String WIN = "yay.wav";
	public static final String LOSE = "lose.wav";
	private HashMap<String, AudioClip> audioMap;

	public GameSound() {
		audioMap = new HashMap<>();
		loadAllAudio();
	}

	public static GameSound getIstance() {
		if (instance == null) {
			instance = new GameSound();
		}

		return instance;
	}

	public void loadAllAudio() {
		putAudio(BGMMENU);
		;
		putAudio(BGMIG);
		putAudio(ADDBOMB);
		putAudio(MONSTER_DIE);
		putAudio(DEAD);
		putAudio(BOMBEXPLORE);
		putAudio(ITEM);
		putAudio(WIN);
		putAudio(LOSE);
	}

	public void stop() {
		getAudio(BGMMENU).stop();
		;
		getAudio(BGMIG).stop();
		getAudio(ADDBOMB).stop();
		getAudio(BOMBEXPLORE).stop();
		getAudio(WIN).stop();
		getAudio(LOSE).stop();
	}

	public void putAudio(String name) {
		AudioClip auClip = Applet.newAudioClip(GameSound.class.getResource(name));
		audioMap.put(name, auClip);
	}

	public AudioClip getAudio(String name) {
		return audioMap.get(name);
	}
}
