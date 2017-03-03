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

/**
 * RoomFairDAO accesses data from booking database.
 * 
 * @author Laura
 * @version 1.0
 *
 */
public class RoomFairDAO {

	public void add(RoomFair roomFair) {
		try (Connection conn = newConnection("postgresql", "localhost", "5432", "booking", "laura", "laura");
				PreparedStatement stm = conn.prepareStatement("INSERT INTO room_fair(value, season) values(?,?)");) {

			stm.setDouble(1, roomFair.getValue());
			stm.setString(2, roomFair.getSeason());

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
	 * @return instance of class RoomFair
	 */

	public List<RoomFair> getAll() {
		List<RoomFair> result = new LinkedList<>();

		try (Connection conn = newConnection("postgresql", "localhost", "5432", "booking", "laura", "laura");
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery("select id, value, season from room_fair");

		) {

			while (rs.next()) {
				RoomFair st = new RoomFair();

				st.setId(rs.getInt("id"));
				st.setValue(rs.getDouble("value"));
				st.setSeason(rs.getString("season"));

				result.add(st);

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return result;
	}

}
