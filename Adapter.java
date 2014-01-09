interface MediaPlayer {
	void play(String audioType, Stirng fileName);
}

interface AdvancedMediaPlayer {
	void playVlc(String fileName);
	void playCD(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer {
	void playVlc(Stirng fileName) {
		System.out.println("Playing Vlc " + fileName);
	}

	void playCD(String fileName) {
	}
}

class CDPlayer implements AdvancedMediaPlayer {
	void playVlc(String fileName) {
	}

	void playCD(String fileName) {
		System.out.println("Playing CD " + fileName);
	}
}

class MediaAdapter implements MediaPlayer {
	AdvancedMediaPlayer player;

	void setPlayer(String audioType) {
		if (audioType.equalsIgnoreCase("Vlc")) {
			player = new VlcPlayer();
		}
		else if (audioType.equalsIgnoreCase("CD")) {
			player = new CDPlayer();
		}
	}

	void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("Vlc")) {
			player.playVlc(fileName);
		}
		else if (audioType.equalsIgnoreCase("CD")) {
			player.playCD(fileName);
		}
	}
}

class AudioPlayer implements MediaPlayer {
	MediaAdapter adapter;

	void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Playing MP3 " + fileName);
		}
		else if (audioType.equalsIgnoreCase("Vlc") || audioType.equalsIgnoreCase("CD")) {
			adapter = new MediaAdapter();
			adapter.play(audioType, fileName);
		}
		else {
			System.out.println("Not supported!");
		}
	}
}

class Test {
	public static void main(String[] args) {
		AudioPlayer ap = new AudioPlayer();
		ap.play("mp3", "1");
		ap.play("mp4", "2");
		ap.play("vlc", "3");
		ap.play("cd", "4");
	}
}

