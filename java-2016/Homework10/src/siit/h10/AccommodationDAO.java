package siit.h10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * AccommodationDAO accesses data from booking database.
 * 
 * @author Laura
 * @version 1.0
 *
 */

public class AccommodationDAO {

	public void add(Accommodation accomodation) {
		try (Connection conn = newConnection("postgresql", "localhost", "5432", "booking", "laura", "laura");
				PreparedStatement stm = conn.prepareStatement(
						"INSERT INTO accomodation(type,bed_type, max_guests,description) values(?,?,?,?)");) {

			stm.setString(1, accomodation.getType());
			stm.setString(2, accomodation.getBedType());
			stm.setLong(3, accomodation.getMaxGuests());
			stm.setString(4, accomodation.getDescription());

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
	 * @return instance of class Accommodation
	 */

	public List<Accommodation> getAll() {
		List<Accommodation> result = new LinkedList<>();

		try (Connection conn = newConnection("postgresql", "localhost", "5432", "booking", "laura", "laura");
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery("select id, type, bed_type, max_guests, description from accomodation");

		) {

			while (rs.next()) {
				Accommodation st = new Accommodation();

				st.setId(rs.getInt("id"));
				st.setType(rs.getString("type"));
				st.setBedType(rs.getString("bed_type"));
				st.setMaxGuests(rs.getInt("max_guests"));
				st.setDescription(rs.getString("description"));

				result.add(st);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return result;
	}
}
