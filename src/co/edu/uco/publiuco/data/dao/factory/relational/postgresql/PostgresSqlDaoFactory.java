package co.edu.uco.publiuco.data.dao.factory.relational.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.publiuco.data.dao.EstadoDAO;
import co.edu.uco.publiuco.data.dao.TipoEstadoDAO;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.relational.sqlserver.EstadoSqlServerDAO;
import co.edu.uco.publiuco.data.dao.relational.sqlserver.TipoEstadoSqlServerDAO;

public class PostgresSqlDaoFactory extends DAOFactory{

	private static Connection connection;
	private static String JDBCURL = "jdbc:postgresql://localhost:5433/publiuco";
	private static String USERNAME = "postgres";
	private static String PASSWORD = "C@r105.zs";	
	
	public PostgresSqlDaoFactory() {
		abrirConexion();
	}

	@Override
	protected void abrirConexion() {
		try{
			connection = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
			System.out.println("Connected to Postgresql server");
			
		} catch (SQLException e){
			System.out.println("Error in connecting to postgresql server ");
			e.printStackTrace();
		}
	}

	@Override
	public void cerrarConexion() {
		
		try {
			connection.close();
			System.out.println("Clossing connection to Postgresql server");
		} catch (SQLException e) {
			System.out.println("Error in closing to postgresql server ");
			e.printStackTrace();
		}

	}

	@Override
	public void iniciarTransaccion() {
		connection.beginRequest();

	}

	@Override
	public void confirmarTransaccion() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelarTransaccion() {
		// TODO Auto-generated method stub

	}

	@Override
	public TipoEstadoDAO getTipoEstadoDAO() {
		// TODO Auto-generated method stub
		return new TipoEstadoSqlServerDAO(connection);
	}

	@Override
	public EstadoDAO geEstadoDAO() {
		// TODO Auto-generated method stub
		return new EstadoSqlServerDAO(connection);
	}

	public static void main(String[] args) throws SQLException {
				
		PostgresSqlDaoFactory intento = new PostgresSqlDaoFactory();
		intento.cerrarConexion();
		
	}

}
