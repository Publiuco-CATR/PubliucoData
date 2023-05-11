package co.edu.uco.publiuco.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.PublicacionDAO;
import co.edu.uco.publiuco.entities.PublicacionEntity;

public class PublicacionSqlServerDAO implements PublicacionDAO {

	public PublicacionSqlServerDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(PublicacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PublicacionEntity> read(PublicacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PublicacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}
	
}