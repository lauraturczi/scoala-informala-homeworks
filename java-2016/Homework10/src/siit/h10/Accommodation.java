package siit.h10;

/**
 * Instances of class Accommodation represent different types of rooms that can
 * be booked
 * 
 * @author Laura
 * @version 1.0
 *
 */

public class Accommodation {

	private int id;
	private String type;
	private String bedType;
	private int maxGuests;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public int getMaxGuests() {
		return maxGuests;
	}

	public void setMaxGuests(int maxGuests) {
		this.maxGuests = maxGuests;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Accomodation [id=" + id + ", type=" + type + ", bedType=" + bedType + ", maxGuests=" + maxGuests
				+ ", description=" + description + "]";
	}

}
