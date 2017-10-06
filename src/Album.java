import java.util.ArrayList;

public class Album {
	private String title;
	private String artist;
	private ArrayList<Song> songList;
	
	public Album(String title, String artist) {
		this.title = title;
		this.artist = artist;
		this.songList = new ArrayList<Song>();
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<Song> getSongList() {
		return songList;
	}
	
//	public boolean addSong(Song song) {
//		if(findSong(song.getTitle())) {
//			System.o
//		}
//	}
	
}
