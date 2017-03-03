package siit.h10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * AccommodationFairDAO accesses data from booking database.
 * 
 * @author Laura
 * @version 1.0
 *
 */
public class AccommodationFairDAO {

	public void add(AccommodationFair accomodationFair) {
		try (Connection conn = newConnection("postgresql", "localhost", "5432", "booking", "laura", "laura");
				PreparedStatement stm = conn.prepareStatement(
						"INSERT INTO accomodation_fair_relation(id_accomodation, id_room_fair) values(?,?)");) {

			stm.setInt(1, accomodationFair.getIdAccomodation());
			stm.setInt(2, accomodationFair.getIdRoomFair());

			stm.execute();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	private static void loadDriver() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.err.println("Can’t load driver. Verify CLASSPATH");
			System.err.println(e.getMessage());
		}
	}

	private static Connection newConnection(String type, String host, String port, String dbName, String user,
			String pw) {

		loadDriver();
		DriverManager.setLoginTimeout(60);

		try {
			String url = new StringBuilder().append("jdbc:").append(type).append("://").append(host).append(":")
					.append(port).append("/").append(dbName).append("?user=").append(user).append("&password=")
					.append(pw).toString();
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println("Cannot connect to the database: " + e.getMessage());
		}

		return null;
	}

	/**
	 * Establishes a connection to the DBMS, creates a prepared statement
	 * executes it and processes the result set object. The result is then
	 * stored in a linked list.
	 * 
	 * @return instance of class AccommodationFairDAO
	 */
	public HashSet<AccommodationFair> getAll() {
		HashSet<AccommodationFair> result = new HashSet<>();

		try (Connection conn = newConnection("postgresql", "localhost", "5432", "booking", "laura", "laura");
				Statement stm = conn.createStatement();
				ResultSet rs = stm
						.executeQuery("select id, id_accomodation, id_room_fair from accomodation_fair_relation");

		) {

			while (rs.next()) {
				AccommodationFair st = new AccommodationFair();

				st.setId(rs.getInt("id"));
				st.setIdAccomodation(rs.getInt("id_accomodation"));
				st.setIdRoomFair(rs.getInt("id_room_fair"));

				result.add(st);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return result;
	}

	/**
	 * Joins two tables from booking database to obtain the price for each type
	 * of room for each season.
	 * 
	 * @return instance of class AccommodationFairDAO
	 */

	public List<AccommodationFair> print() {
		List<AccommodationFair> result = new LinkedList<>();

		try (Connection conn = newConnection("postgresql", "localhost", "5432", "booking", "laura", "laura");
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(
						"select distinct accomodation.type, room_fair.value, room_fair.season from accomodation_fair_relation"
								+ " join accomodation on accomodation.id=accomodation_fair_relation.id_accomodation join room_fair on room_fair.id=accomodation_fair_relation.id_room_fair;");

		) {
			int i = 0;
			while (rs.next()) {
				if (i % 4 == 0) {
					System.out.println(rs.getString("type"));
				}
				System.out.print(rs.getString("season"));
				System.out.println(rs.getFloat("value"));
				i++;
				if (i == 4) {
					i = 0;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return result;
	}

}
