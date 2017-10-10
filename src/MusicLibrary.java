import java.io.*;
import java.util.*;

public class MusicLibrary {
	private Scanner scanner;
	private ArrayList<Song> songList;
	
	MusicLibrary() {
		this.songList = new ArrayList<Song>();
	}
	
	public ArrayList<Song> getSongList() {
		return songList;
	}
	
	public Song queryLibrary(String name) {
		for(Song song : songList) {
			if(song.getTitle().equals(name)) {
				return song;
			}
		}
		return null;
	}


	public void importFiles() {
		if(openFile()) {
			//success
			readFile(); // create new Songs
		}
		else {
			System.out.println("Could not find file");
		}
		
		closeFile();
	}
	
	private boolean openFile() {
		try {
			scanner = new Scanner(new File("songs"));
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}
	
	private void closeFile() {
		scanner.close();
	}
	
	private void readFile() {
		while(scanner.hasNextLine()) {
			String title = scanner.nextLine();
			String artist = scanner.nextLine();
			String album = scanner.nextLine();
			songList.add(new Song(title, artist, album));
		}	
	}
}
