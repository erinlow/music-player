import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

// options: create new playlist, add songs to playlist, remove songs to playist,
// play songs, go forward, go back
public class Playlist {
	private String name;
	private LinkedList<Song> songs;
	
	public Playlist() {}
	
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
	
	public void play() {
		Scanner keyboard = new Scanner(System.in);
		ListIterator<Song> songIterator = songs.listIterator();
		if(songs.size() == 0) {
			System.out.println("There are no songs in this playlist.");
		}
		else {
			System.out.println("Now Playing: "+ songIterator.next());
		}
		
		boolean quit = false;
		boolean forward = true;
		printMenu();
		while(!quit) {
			int action = keyboard.nextInt();
			keyboard.nextLine();
			
			switch(action) {
			case 0:
				System.out.println("Exiting playlist...");
				quit = true;
				break;
			case 1: // Forward
				if(!forward) {
					if(songIterator.hasNext()) {
						songIterator.next();
					}
					forward = true;
				}
				if(songIterator.hasNext()) {
					System.out.println("Now playing "+ songIterator.next());
				}
				else {
					System.out.println("End of the playlist");
					forward = false;
				}
				break;
			case 2: // Backward
				if(forward) {
					if(songIterator.hasPrevious()) {
						songIterator.previous();
					}
					forward = false;
				}
				if(songIterator.hasPrevious()) {
					System.out.println("Now playing "+ songIterator.previous());
				}
				else {
					System.out.println("Beginning of the playlist");
					forward = true;
				}
				break;
			case 3: // Replay current song
				forward = replaySong(forward, songIterator);
				break;
			case 4: // Display songs in the playlist
				printSongs();
				break;
			case 5: // Display available options
				printMenu();
				break;
			}
		}
	}
	
	private boolean replaySong(boolean forward, ListIterator<Song> songIterator) {
		if(forward) {
			if(songIterator.hasPrevious()) {
				System.out.println("Replaying: " + songIterator.previous());
				forward = false;
			}
			else {
				System.out.println("We are at the beginning of the playlist");
			}
		}
		else {
			if(songIterator.hasNext()) {
				System.out.println("Replaying: " + songIterator.next());
				forward = true;
			}
			else {
				System.out.println("We are at the end of the playlist");
			}
		}
		return forward;
	}
 	private void printSongs() {
		Iterator<Song> songIterator = songs.iterator();
		System.out.println("===============================");
		while(songIterator.hasNext()) {
			System.out.println(songIterator.next());
		}
		System.out.println("===============================");
	}
 	private void printMenu() {
		System.out.println("\nPress:\n"+
				"0 - Exit playlist\n"+
				"1 - Skip\n"+
				"2 - Backward\n"+
				"3 - Replay current song\n" +
				"4 - Display list of available songs\n" +
				"5 - Print menu");
	}
}
