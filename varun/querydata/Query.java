package varun.querydata;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Query {

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

	public void showAll(){
		String command = "SELECT id, name, actor, actress, director, year FROM movies";

		try(
			Connection conn = this.connect();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(command)){

			while(rs.next()){
				System.out.println(rs.getInt("id") + "\n" + rs.getString("name") + "\n" + rs.getString("actor") + "\n"
					+ rs.getString("actress") + "\n" + rs.getString("director") + "\n" + rs.getString("year"));
			}
		} catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}

	public void showspecificmovie(){
		String command = "SELECT name,year FROM movies WHERE actor = ?";

		try(
			Connection conn = this.connect();
			PreparedStatement ps = conn.prepareStatement(command)){

			ps.setString(1,"Keanu Reeves");
			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				System.out.println(rs.getString("name") + "\n" + rs.getString("year"));
			}
		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		Query app = new Query();
		app.showAll();
		app.showspecificmovie();
    }
}