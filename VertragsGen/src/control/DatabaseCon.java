package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseCon {
	
	 private static String url;

	 public static Connection connect() {
	        Connection conn = null;
	        try {
	            // db parameters
	            
	        	url = "jdbc:sqlite:Ressource/VertragsGen.db";
	            // create a connection to the database
	            conn = DriverManager.getConnection(url);
	            
	            System.out.println("Connected");
	            
	            return conn;
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            return conn;
	            
	        } /*finally {
	            try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                System.out.println(ex.getMessage());
	            }
	        }*/
	    }

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		DatabaseCon.url = url;
	}
	
}
