package lm.com.IMDB;

public class Character {
	String characterName;
	String movieTitle;
	String actorName;
	String characterDesc;
	
	
	public Character(String characterName, String movieTitle, String actorName, String characterDesc) {
		super();
		this.characterName = characterName;
		this.movieTitle = movieTitle;
		this.actorName = actorName;
		this.characterDesc = characterDesc;
	}
	@Override
	public String toString() {
		return "Character [characterName=" + characterName + ", movieTitle=" + movieTitle + ", actorName=" + actorName
				+ ", characterDesc=" + characterDesc + "]";
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getactorName() {
		return actorName;
	}
	public void setactorName(String actorName) {
		this.actorName = actorName;
	}
	public String getCharacterDesc() {
		return characterDesc;
	}
	public void setCharacterDesc(String characterDesc) {
		this.characterDesc = characterDesc;
	}
	
	
}
