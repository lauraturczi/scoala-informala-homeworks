package siit.h10.tests;

import org.junit.Test;

import siit.h10.AccommodationFairDAO;
import siit.h10.Relation;

public class BookingTest {

	@Test
	public void testInsertIntoWithPreparedStatement() {
		Relation relation = new Relation();
		relation.createRelations();
	}

	@Test
	public void testPrintingFares() {
		AccommodationFairDAO accomodationFairDAO = new AccommodationFairDAO();
		accomodationFairDAO.print();
	}
}
