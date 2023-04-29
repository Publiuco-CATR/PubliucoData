package co.edu.uco.publiuco.data.dao.factory.relational.sqlserver;

import java.sql.Connection;

import co.edu.uco.publiuco.data.dao.EstadoDAO;
import co.edu.uco.publiuco.data.dao.TipoEstadoDAO;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.relational.sqlserver.EstadoSqlServerDAO;
import co.edu.uco.publiuco.data.dao.relational.sqlserver.TipoEstadoSqlServerDAO;

public final class SqlServerDaoFactory extends DAOFactory{

	private Connection connection;
	
	public SqlServerDaoFactory() {
		abrirConexion();
	}
	
	@Override
	protected final void abrirConexion() {
		
		//	:C
		connection = 
	}

	@Override
	public final void cerrarConexion() {
		
		//:C		
	}

	@Override
	public final void iniciarTransaccion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void confirmarTransaccion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void cancelarTransaccion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final TipoEstadoDAO getTipoEstadoDAO() {
		
		return new TipoEstadoSqlServerDAO(connection);
	}

	@Override
	public EstadoDAO geEstadoDAO() {
		// TODO Auto-generated method stub
		return new EstadoSqlServerDAO(connection);
	}

	
}
