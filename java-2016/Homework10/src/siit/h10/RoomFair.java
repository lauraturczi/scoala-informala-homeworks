package siit.h10;

/**
 * Instances of class RoomFair represent the fairs depending on the season.
 * 
 * @author Laura
 * @version 1.0
 *
 */
public class RoomFair {

	private int id;
	private double value;
	private String season;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	@Override
	public String toString() {
		return "RoomFair [id=" + id + ", value=" + value + ", season=" + season + "]";
	}

}
