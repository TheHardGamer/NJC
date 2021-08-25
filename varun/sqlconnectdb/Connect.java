package varun.sqlconnectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	public static void connect() {
	Connection conn = null;
	try {
		String url = "jdbc:sqlite:D:/data.db";
		conn = DriverManager.getConnection(url);
		System.out.println("Successfully Connected!");
	} catch(SQLException e) {
		System.out.println(e.getMessage());
	}
	finally {
		try{
			if (conn != null)
			{
				conn.close();
			}
		} catch (SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
	public static void main(String[] args) {
		connect();
    }
}