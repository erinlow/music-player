import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static ArrayList<Playlist> playlists = new ArrayList<Playlist>();
	private static MusicLibrary library = new MusicLibrary();
	private static Playlist playlist = new Playlist();
	private static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		printIntro();
		printMenu();
		boolean quit = false;
		while(!quit) {
			System.out.print("\nWhat would you like to do? ");
			int input = keyboard.nextInt();
			keyboard.nextLine();
			switch(input) {
			case 1: 
				addPlaylist();
				break;
			case 2:
				displayPlaylists();
				break;
			case 3:
				addSong();
				break;
			case 4:
				playPlaylist();
				break;
			case 5:
				quit = true;
				break;
			}
		}
		shutDown();
	}
	
	// Method to add a selected Song object to a selected Playlist object - if both exist
	private static void addSong() {
		if(playlists.isEmpty()) {
			System.out.println("You have no playlists to modify.");
		}
		else {
			System.out.print("Which song would you like to add? ");
			String name = keyboard.nextLine();
			Song checkSong = library.queryLibrary(name);
			if(checkSong == null) {
				System.out.println("That song does not exist");
			}
			else {
				System.out.print("Which playlist would you like to add "+name+
				" to? ");
				// TODO Check to see if song already exists in the playlist
				String playlistName = keyboard.nextLine();
				Playlist checkPlaylist = queryPlaylist(playlistName);
				if(checkPlaylist == null) {
					System.out.println("Playlist does not exist");
				}
				else {
					checkPlaylist.addSongToPlaylist(checkSong);
				}
			}	
		}	
	}

	// TODO playPlaylist method
	private static void playPlaylist() {
		if(playlists.isEmpty()) {
			System.out.println("You have no playlists to play");
		}
		System.out.print("Which playlist would you like to play? ");
		String name = keyboard.nextLine();
		Playlist checkPlaylist = queryPlaylist(name);
		if(checkPlaylist == null) {
			System.out.println("Playlist does not exist");
		}
		else {
			checkPlaylist.play();
		}
	}
	
	// Method to display all the Playlist objects in the ArrayList<Playlist>
	private static void displayPlaylists() {
		if(playlists.isEmpty()) {
			System.out.println("You have no playlists.");
		}
		else {
			if(playlists.size() == 1) {
				System.out.println("Here is your playlist:\n");
			}
			else {
				System.out.println("Here are your playlists:\n");	
			}
			for(Playlist playlist : playlists) {
				System.out.println(playlist.getName());
			}
		}
	}

	// Method to add a Playlist object to the ArrayList<Playlist>
	private static void addPlaylist() {
		if(playlists.size() == 1) {
			System.out.println("\nYou have "+playlists.size()+ " playlist.");
		}
		else {
			System.out.println("\nYou have "+ playlists.size() + " playlists.");
		}
		System.out.print("Enter the new playlist name: ");
		String name = keyboard.nextLine();
		Playlist playlist = new Playlist(name);
		playlists.add(playlist);
		
	}
	
	// Method to return the playlist in the ArrayList<Playlist> if the playlist exists
	private static Playlist queryPlaylist(String name) {
		for(Playlist playlist : playlists) {
			if(playlist.getName().equals(name)) {
				return playlist;
			}
		}
		return null;
	}

	// Method to "start" the iPod and print the songs in library
	private static void printIntro() {
		System.out.println("Starting iPod...\n");
		
		library.importFiles();
		System.out.println("These are the current songs in your library: \n");
		for(Song song : library.getSongList()) {
			System.out.println(song.toString());
		}
	}

	// Method to print menu
	private static void printMenu() {
		System.out.println("\nPress:\n"+
				"1 - Add a new playlist\n"+
				"2 - Show playlists\n"+
				"3 - Add a song to a playlist\n"+
				"4 - Play a playlist\n"+
				"5 - Turn off iPod");
	}
	
	// Method to shut down the iPod
	private static void shutDown() {
		System.out.println("Shutting down...");
	}
}
