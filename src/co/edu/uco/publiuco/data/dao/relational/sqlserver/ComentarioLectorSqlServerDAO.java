package co.edu.uco.publiuco.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.ComentarioLectorDAO;
import co.edu.uco.publiuco.entities.ComentarioLectorEntity;

public class ComentarioLectorSqlServerDAO implements ComentarioLectorDAO {

	public ComentarioLectorSqlServerDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(ComentarioLectorEntity entity) {
		
	}

	@Override
	public List<ComentarioLectorEntity> read(ComentarioLectorEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ComentarioLectorEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}

}