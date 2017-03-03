package siit.h10;

import java.util.HashSet;
import java.util.List;

/**
 * Relation class creates the relations between the three tables
 * 
 * @author Laura
 * @version 1.0
 */
public class Relation {

	/**
	 * Creates one room and four room fare types and the relations between them
	 * is held in accomodationFairDAO
	 */
	public void createRelations() {
		AccommodationDAO accomodationDAO = new AccommodationDAO();
		List<Accommodation> accomodations = accomodationDAO.getAll();
		Accommodation accommodation = new Accommodation();
		accommodation.setBedType("one bed");
		accommodation.setDescription("land view");
		accommodation.setMaxGuests(1);
		accommodation.setType("Single");
		accomodationDAO.add(accommodation);
		accomodations = accomodationDAO.getAll();
		System.out.println(accomodations);

		RoomFairDAO roomFairDAO = new RoomFairDAO();
		List<RoomFair> roomFairs = roomFairDAO.getAll();
		roomFairs = roomFairDAO.getAll();
		createFares(roomFairDAO);
		AccommodationFairDAO accomodationFairDAO = new AccommodationFairDAO();
		HashSet<AccommodationFair> accomodationFairs = accomodationFairDAO.getAll();
		for (int i = 0; i < accomodations.size(); i++) {
			for (int j = 0; j < roomFairs.size(); j++) {
				AccommodationFair accomodationFair = new AccommodationFair();
				accomodationFair.setIdRoomFair(roomFairs.get(j).getId());
				accomodationFair.setIdAccomodation(accomodations.get(i).getId());
				accomodationFairDAO.add(accomodationFair);
				accomodationFairs = accomodationFairDAO.getAll();
			}
		}
		System.out.println(accomodationFairs);
	}

	private static void createFares(RoomFairDAO roomFairDAO) {
		List<RoomFair> roomFairs;
		RoomFair winter = new RoomFair();
		winter.setValue(150.5);
		winter.setSeason("Winter");
		roomFairDAO.add(winter);
		roomFairs = roomFairDAO.getAll();

		RoomFair summer = new RoomFair();
		summer.setValue(200);
		summer.setSeason("Summer");
		roomFairDAO.add(summer);
		roomFairs = roomFairDAO.getAll();

		RoomFair spring = new RoomFair();
		spring.setValue(150.7);
		spring.setSeason("Spring");
		roomFairDAO.add(spring);
		roomFairs = roomFairDAO.getAll();

		RoomFair autumn = new RoomFair();
		autumn.setValue(150.7);
		autumn.setSeason("Autumn");
		roomFairDAO.add(autumn);
	}

}
