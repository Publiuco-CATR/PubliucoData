package co.edu.uco.publiuco.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.TipoRevisionDAO;
import co.edu.uco.publiuco.entities.TipoRevisionEntity;

public class TipoRevisionSqlServerDAO implements TipoRevisionDAO {

	public TipoRevisionSqlServerDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(TipoRevisionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TipoRevisionEntity> read(TipoRevisionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TipoRevisionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}

}