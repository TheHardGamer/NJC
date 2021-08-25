package varun.insertdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

	//private method
	private Connection connect(){
		String url = "jdbc:sqlite:D:/python/sqlite/java/connect/varun/movies.db";
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(url);
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void insertdata(String name, String actor, String actress, String director, String year){
		String command = "INSERT INTO movies(name,actor,actress,director,year) VALUES(?,?,?,?,?)";

		try(
			Connection conn = this.connect();
			PreparedStatement ps = conn.prepareStatement(command)){
			ps.setString(1, name);
			ps.setString(2, actor);
			ps.setString(3, actress);
			ps.setString(4, director);
			ps.setString(5, year);
			ps.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		Insert app = new Insert();
		app.insertdata("SpiderMan", "Tobey Maguire", "Kirsten Dunst", "Sam Raimi", "2002");
		app.insertdata("Batman Begins", "Christian Bale", "Katie Holmes", "Christopher Nolan", "2005");
		app.insertdata("John Wick 3", "Keanu Reeves", "Halle Berry", "Chad Stahelski", "2019");
	}
}