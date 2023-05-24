package co.edu.uco.publiuco.data.dao.factory.relational.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
	private static Connection connection;
	private static String JDBCURL = "jdbc:postgresql://mahmud.db.elephantsql.com:5432/nfjaiiyr";
	private static String USERNAME = "nfjaiiyr";
	private static String PASSWORD = "hFdpP8B7-CxwFNh4IuZ3NXdqnJbegOcf";

	public test() {
		abrirConexion();
	}
	
	protected void abrirConexion() {
		try{
			connection = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
			System.out.println("Connected to Postgresql server");

		} catch (SQLException e){
			System.out.println("Error in connecting to postgresql server ");
			e.printStackTrace();
		}
	}

	public void cerrarConexion() {

		try {
			connection.close();
			System.out.println("Clossing connection to Postgresql server");
		} catch (SQLException e) {
			System.out.println("Error in closing to postgresql server ");
			e.printStackTrace();
		}

	}


	public static void main(String[] args) throws SQLException {

		test intento = new test();
		intento.cerrarConexion();

	}

}

