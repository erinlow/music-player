
public class Main {

	public static void main(String[] args) {

		MusicLibrary library = new MusicLibrary();
		
		library.importFiles();
		for(Song song : library.getSongList()) {
			System.out.println(song.toString());
		}
	}

}
