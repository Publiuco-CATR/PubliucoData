package co.edu.uco.publiuco.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.TipoAccesoDAO;
import co.edu.uco.publiuco.entities.TipoAccesoEntity;

public class TipoAccesoSqlServerDAO implements  TipoAccesoDAO {

	public TipoAccesoSqlServerDAO(final Connection connection) {
		
	}

	@Override
	public void create(TipoAccesoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TipoAccesoEntity> read(TipoAccesoEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TipoAccesoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}
	
}