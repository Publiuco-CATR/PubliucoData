package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.CalificacionDAO;
import co.edu.uco.publiuco.entities.CalificacionEntity;

public class CalificacionPostgreSqlDAO implements CalificacionDAO {

	public CalificacionPostgreSqlDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(CalificacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CalificacionEntity> read(CalificacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CalificacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}
    
}
