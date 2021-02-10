package playlist2;

import java.util.ArrayList;

public class Album {
	
	private String album_name; // Name of the album
	private ArrayList<Songs> song = new ArrayList<Songs>(); // list to store the songs in a particular album 
	
	public String getAlbum_name() {
		return album_name;
	}

	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}

	public void setSong(ArrayList<Songs> song) {
		this.song = song;
	}

	public ArrayList<Songs> getSong() {
		return song;
	}

	//  function to add the new song in the album
	public void addNewSong(Songs newsong){
		
		int check = 0;
		
		for(Songs song_ : song) {
			if(song_.getTitle().equalsIgnoreCase(newsong.getTitle())) {
				check = 1;
				break;
			}
		}
		
		if(check==0) {
			song.add(newsong);
			System.out.println(newsong.getTitle()+" "+newsong.getDuration()+" added successfully");
		}
		else
			System.out.println("Song is already present");
	}
	
	// function to print the album with the songs present in it
	public void printAlbumWithSongs(ArrayList<Album> album_list) {

		int serial1 = 0, serial2 = 0;
		for (Album album : album_list) {
			serial1++;
			System.out.println(serial1 + ". " + album.album_name);
			System.out.print("---------------------------------------- ");
			System.out.println();
			serial2 = 0;
			for (Songs song : album.song) {
				serial2++;
				System.out.println(serial2 + ". " + song.getTitle() + " " + song.getDuration());
			}
			System.out.println("*****************************************");
		}

	}
	
    // function to add the songs in the playlist
	public void addSongtoPlaylist(String title, Album album, ArrayList<Songs> playlist) {

		int check = 0;
		for (Songs song : playlist) {
			if (song.getTitle().equalsIgnoreCase(title)) {
				check = 1;
				break;
			}
		}

		if (check == 0) {
			for (Songs song_ : album.song) {
				if (song_.getTitle().equalsIgnoreCase(title)) {
					playlist.add(song_);
					System.out.println(song_.getTitle() + " " + song_.getDuration() + " added successfully to the playlist");
					break;
				}
			}

		} else {
			System.out.println("song is already present in the playlist");
		}
	}
	
	// function to print the playlist
	public void printPlaylist(ArrayList<Songs> playlist) {

		System.out.println("*********************Playlist*********************");

		int serial = 0;
		for (Songs song : playlist) {
			serial++;
			System.out.println(serial + ". " + song.getTitle() + " " + song.getDuration());
		}

	}
	
	
	// function to play the current song
	public void playCurrentSong(ArrayList<Songs> playlist, int pointer) {
		
		if (pointer >= 0 && pointer < playlist.size()) {
			System.out.println("\nSong Playing " + "♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫ title: " + playlist.get(pointer).getTitle()
					+ " duration: " + playlist.get(pointer).getDuration() + " ♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫");

		}
		if (pointer < 0) {

			pointer = 0;
		}
		if (pointer >= playlist.size())
			pointer = playlist.size() - 1;
	}
    
	// function to play the next song
	public void playforwardSong(ArrayList<Songs> playlist, int pointer) {

		if (pointer >= playlist.size()) {
			pointer = playlist.size() - 1;
			System.out.println("You reached the end of the playlist");
		} else
			System.out.println("\nSong Playing " + "♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫ title: " + playlist.get(pointer).getTitle()
					+ " duration: " + playlist.get(pointer).getDuration() + " ♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫");
	}
    
	// function to play the previous song
	public void playpreviousSong(ArrayList<Songs> playlist, int pointer) {

		if (pointer < 0) {
			pointer = 0;
			System.out.println("No song present before this");
		} else
			System.out.println("\nSong Playing " + "♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫ title: " + playlist.get(pointer).getTitle()
					+ " duration: " + playlist.get(pointer).getDuration() + " ♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫♫");
	}
	
}