
public class Song {
	private String title;
	private String artist;
	private String album;
	
	public Song() {}
	
	public Song(String title, String artist, String album) {
		this.title = title;
		this.artist = artist;
		this.album = album;
	}
	
	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getAlbum() {
		return album;
	}

	private Song createNewSong(String title, String artist, String album) {
		return new Song(title, artist, album);
	}

	@Override
	public String toString() {
		return "'"+ this.title + "'";
	}

}
