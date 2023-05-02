package co.edu.uco.publiuco.data.dao.factory;

import co.edu.uco.publiuco.data.dao.EstadoDAO;
import co.edu.uco.publiuco.data.dao.TipoEstadoDAO;
import co.edu.uco.publiuco.data.dao.factory.relational.postgresql.PostgresSqlDaoFactory;
import co.edu.uco.publiuco.data.dao.factory.relational.sqlserver.SqlServerDaoFactory;

public abstract class DAOFactory {
	
	public static DAOFactory getFactory(final Factory factory) {
		
		DAOFactory daoFactory;
		switch (factory) {			
			case SQLSERVER: {
				daoFactory = new SqlServerDaoFactory();
				break;
			}
			case POSTGRESQL: {
				daoFactory = new PostgresSqlDaoFactory();
				break;
			}
			default: {
				throw new IllegalArgumentException("Unexpected value: " + factory);
			}
		}
		
		return daoFactory;
	}
	
	protected abstract void abrirConexion();
	
	public abstract void cerrarConexion();
	
	public abstract void iniciarTransaccion();
	
	public abstract void confirmarTransaccion();
	
	public abstract void cancelarTransaccion();
	
	public abstract TipoEstadoDAO getTipoEstadoDAO();
	
	public abstract EstadoDAO geEstadoDAO();
	
}
