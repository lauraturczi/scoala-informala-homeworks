package siit.h10;

/**
 * Instances of class AccommodationFair represent relations between id of the
 * room fair and id of the accommodation table.
 * 
 * @author Laura
 * @version 1.0
 *
 */

public class AccommodationFair {

	private int id;
	private int idAccomodation;
	private int idRoomFair;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAccomodation() {
		return idAccomodation;
	}

	public void setIdAccomodation(int idAccomodation) {
		this.idAccomodation = idAccomodation;
	}

	public int getIdRoomFair() {
		return idRoomFair;
	}

	public void setIdRoomFair(int idRoomFair) {
		this.idRoomFair = idRoomFair;
	}

	@Override
	public String toString() {
		return "AccomodationFair [id=" + id + ", idAccomodation=" + idAccomodation + ", idRoomFair=" + idRoomFair + "]";
	}

}
