package playlist2;

public class Songs {

	private String title; // variable for the title of song
	private String duration; // variable for the duration of song

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	 Songs(String title, String duration) {
		this.title = title;
		this.duration = duration;
	}

}