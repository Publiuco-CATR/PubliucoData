package co.edu.uco.publiuco.data.dao.relational.postresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.publiuco.data.dao.TipoEstadoDAO;
import co.edu.uco.publiuco.entities.TipoEstadoEntity;
import co.edu.uco.publiuco.utils.UtilSql;

public class TipoEstadoPostreSqlDAO implements TipoEstadoDAO{
	private Connection connection;
	
	public TipoEstadoPostreSqlDAO(final Connection connection) {
		setConnection(connection);
	}
	
	@Override
	public void create(TipoEstadoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TipoEstadoEntity> consultar(TipoEstadoEntity entity) {
		return null;
	}

	@Override
	public void update(TipoEstadoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TipoEstadoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		if (UtilSql.connectionIsOpen(connection)) {
			this.connection = connection;
		}
	}

}
