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
	
	public boolean addSong(Song song) {
		if(findSong(song.getTitle()) != null) {
			System.out.println("Song is already in the album.");
			return false;
		}
		else {
			System.out.println("Song was successfully added");
			songList.add(song);
			return true;
		}
	}
	
	private Song findSong(String title) {
		for(Song checkSong : this.songList) {
			if(title.equals(checkSong.getTitle())) {
				return checkSong;
			}
		}
		return null;
	}
	
}
