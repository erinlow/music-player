import java.util.LinkedList;

// options: create new playlist
public class Playlist {
	private String name;
	private LinkedList<Song> songs;
	
	public Playlist(String name) {
		this.name = name;
		this.songs = new LinkedList<Song>();
	}

	
}
