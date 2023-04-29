package co.edu.uco.publiuco.data.dao.factory.relational.sqlserver;

import java.sql.Connection;

import co.edu.uco.publiuco.data.dao.EstadoDAO;
import co.edu.uco.publiuco.data.dao.TipoEstadoDAO;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;

public class PostgresSqlDaoFactory extends DAOFactory{

	private Connection connection;
	
	public PostgresSqlDaoFactory() {
		abrirConexion();
	}
	
	@Override
	protected void abrirConexion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cerrarConexion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciarTransaccion() {
		// TODO Auto-generated method stub
		
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
		return TipoEstadoDAO(connection);
	}

	@Override
	public EstadoDAO geEstadoDAO() {
		// TODO Auto-generated method stub
		return new EstadoDAO(connection);
	}

}
