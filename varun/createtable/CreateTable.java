package varun.createtable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void createmoviestable() {
	String url = "jdbc:sqlite:D:/python/sqlite/java/connect/varun/movies.db";

	String command = "CREATE TABLE IF NOT EXISTS movies (\n" 
					+ " id integer PRIMARY KEY,\n"
					+ " name text NOT NULL,\n"
					+ " actor text NOT NULL,\n"
					+ " actress text NOT NULL,\n"
					+ " director text NOT NULL,\n"
					+ " year text NOT NULL\n"
					+ ");";

	try(
		Connection conn = DriverManager.getConnection(url);
		Statement statement = conn.createStatement())
	{
		statement.execute(command);
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}

}

    public static void main(String[] args) {
        createmoviestable();
    }

}