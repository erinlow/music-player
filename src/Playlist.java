import java.util.LinkedList;

// options: create new playlist, add songs to playlist, remove songs to playist,
// play songs, go forward, go back
public class Playlist {
	private String name;
	private LinkedList<Song> songs;
	
	public Playlist() {
		
	}
	public Playlist(String name) {
		this.name = name;
		this.songs = new LinkedList<Song>();
	}

	public String getName() {
		return name;
	}

	public LinkedList<Song> getSongs() {
		return songs;
	}
	
	public void addSongToPlaylist(Song song) {
		songs.add(song);
	}
}
