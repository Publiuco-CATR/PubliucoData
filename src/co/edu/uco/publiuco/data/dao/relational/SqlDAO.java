package co.edu.uco.publiuco.data.dao.relational;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.publiuco.crosscutting.exception.PubliucoDataException;
import co.edu.uco.publiuco.utils.UtilSql;

public abstract class SqlDAO<E> {
	private Connection connection;
	
	protected SqlDAO(final Connection connection) {
		setConnection(connection);
	}
	
	protected final Connection getConnection() {
		return connection;
	}
	
	private final void setConnection(final Connection connection) {
		if (!UtilSql.connectionIsOpen(connection)) {
			var userMessage = "Se ha presentado un problema trantando de llevar a cabo la operación deseada... intente de nuevo y si el problema persiste contacte el administrador del sistema";
			var technicalMessage = "No se ha podido crear la operación deseada, debido a que la conexión no esta abierta";
			
			throw PubliucoDataException.create(technicalMessage, userMessage);
		}
		
		this.connection = connection;
	}
	
	protected abstract String preparedSelect();
	
	protected abstract String preparedFrom();
	
	protected abstract String preparedWhere(E entity, List<Object> parameter);
	
	protected abstract String preparedOrderBy();
}
