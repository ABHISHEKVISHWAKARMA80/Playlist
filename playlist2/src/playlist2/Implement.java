package playlist2;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.System;

public class Implement {

	private static Scanner sc = new Scanner(System.in);
	
	private static int pointer = 0;

	public static void main(String[] args) {

		Album album; // declare the reference variable of Album class

		 // variable to track the song which is currently playing in the playlist

		String album_name = "", title, duration; // variables to store the user inputs
		Songs newsong;
		boolean iterator1 = true, iterator2 = true, iterator3 = true;

		ArrayList<Album> album_list = new ArrayList<Album>(); // list of the album

		ArrayList<Songs> playlist = new ArrayList<Songs>(); // list of the songs present in the playlist

		while (iterator1) {
			iterator2 = true;
			System.out.println("**********MUSIC APPLICATION**********" + "\nEnter your choice :" + "\n1.Add new album"
					+ "\n2.Print the albums with songs" + "\n3.Add songs to the playlist" + "\n4.Print the playlist"
					+ "\n5.PLAYLIST MENU" + "\n6.Quit");
            
			String choice;
            	
			choice = sc.next();
            
            
	
			switch (choice) {
            
			// Add new album
			case "1":

				int check = 0;

				System.out.println("Enter the album name");

				album_name = sc.next();

				for (Album al : album_list) {
					if (al.getAlbum_name().equalsIgnoreCase(album_name)) {
						check = 1;
						break;
					}

				}

				if (check == 0) {

					album = new Album();

					album.setAlbum_name(album_name);

					while (iterator2) {
						System.out.println("Enter the title of song");
						title = sc.next();
						System.out.println("Enter the duration of song");
						duration = sc.next();
						newsong = new Songs(title, duration);

						album.addNewSong(newsong);

						String yes_or_no;
						System.out.println("Do you want to add another song: Y/N");
						yes_or_no = sc.next();

						if (yes_or_no.equalsIgnoreCase("Y")) {
							continue;
						}
						if (yes_or_no.equalsIgnoreCase("N")) {
							iterator2 = false;
							break;
						}
						if (!yes_or_no.equalsIgnoreCase("Y") && !yes_or_no.equalsIgnoreCase("N")) {
							System.out.println("wrong input, please enter: Y/N");
						}
					}

					album_list.add(album);
				} else {
					System.out.println("Album is already present");
				}

				break;
           
			// Print the albums with songs	
			case "2":
				album = new Album();
				album.printAlbumWithSongs(album_list);
				break;

			
			// Add songs to the playlist
			case "3":
				boolean iterator11 = true;

				while (iterator11) {

					album = new Album();

					System.out.println("Enter the album from which you want to add the song in the playlist");
					album_name = sc.next();
					int check1 = 0;

					for (Album album_ : album_list) {

						if (album_.getAlbum_name().equalsIgnoreCase(album_name)) {
							check1 = 1;

							iterator2 = true;

							while (iterator2) {
								int check2 = 0;
								System.out.println("Enter the song title which you want to add in the playlist");
								title = sc.next();

								for (Songs song : album_.getSong()) {

									if (song.getTitle().equalsIgnoreCase(title)) {
										album.addSongtoPlaylist(title, album_, playlist);
										check2 = 1;
										break;

									}

								}

								if (check2 == 0)
									System.out.println("song is not present in this album");

								System.out.println("Do you want to add another song from this album: Y/N");
								String yORn = sc.next();

								if (yORn.equalsIgnoreCase("Y")) {
									continue;
								}
								if (yORn.equalsIgnoreCase("N")) {
									iterator11 = false;
									iterator2 = false;
								}
								if (!yORn.equalsIgnoreCase("Y") && !yORn.equalsIgnoreCase("N")) {
									System.out.println("enter the correct input");
									continue;
								}
							}

							break;
						}
					}

					if (check1 == 0) {

						System.out.println("Album is not present");
					}

				}
				break;

		
			// Print the list of song present in the playlist
			case "4":
				album = new Album();

				if (playlist.size() == 0)
					System.out.println("Playlist is empty");
				else
					album.printPlaylist(playlist);
				break;

			
		    // PLAYLIST MENU
			case "5":
				iterator3 = true;
				album = new Album();

				while (iterator3) {

					System.out.println(
							"**********PLAY THE SONG**********" + "\nEnter your choice :" + "\n1.Play the current song "
									+ "\n2.Play the next song" + "\n3.Play the previous song" + "\n4.quit");

					String choice2 = sc.next();

					switch (choice2) {
                    
					// Play the current song
					case "1":

						if (pointer < 0) {
							pointer = 0;
						}

						if (pointer >= playlist.size()) {
							pointer = playlist.size() - 1;
						}

						album.playCurrentSong(playlist, pointer);

						break;
                    
					// Play the next song	
					case "2":

						if (pointer < 0) {
							pointer = 0;
						}

						if (pointer >= playlist.size()) {
							pointer = playlist.size() - 1;
						}

						pointer = pointer + 1;
						album.playforwardSong(playlist, pointer);

						break;

					// Play the previous song	
					case "3":

						if (pointer < 0) {
							pointer = 0;
						}

						if (pointer >= playlist.size()) {
							pointer = playlist.size() - 1;
						}

						pointer = pointer - 1;
						album.playpreviousSong(playlist, pointer);

						break;
					
					// To quit	
					case "4":

						iterator3 = false;
						break;

					default:
						System.out.println("Enter the correct choice");
						continue;
					}
				}
				break;

			case "6":
				System.out.println("***************************THANK YOU***************************");
				iterator1 = false;
				System.exit(0);
				break;

			default:
				System.out.println("Enter the correct choice");
				continue;
			}
			
		}
	}
}