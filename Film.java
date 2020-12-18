package systémeItegration;

public class Film {
	private String title ;
	private String summary;
	private int year;
	private Name director ;
	private Name[] actors;
	
	public Film() {}

	public Film(String title, String summary, int year, Name director, Name[] actors) {
		super();
		this.title = title;
		this.summary = summary;
		this.year = year;
		this.director = director;
		this.actors = actors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Name getDirector() {
		return director;
	}

	public void setDirector(Name director) {
		this.director = director;
	}

	public Name[] getActors() {
		return actors;
	}

	public void setActors(Name[] actors) {
		this.actors = actors;
	}
	
	
}
