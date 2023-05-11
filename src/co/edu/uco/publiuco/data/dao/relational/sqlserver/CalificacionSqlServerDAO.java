package co.edu.uco.publiuco.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.CalificacionDAO;
import co.edu.uco.publiuco.entities.CalificacionEntity;

public class CalificacionSqlServerDAO implements CalificacionDAO {

	public CalificacionSqlServerDAO(final Connection connection) {
		
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
	public void delete(UUID entityid) {
		// TODO Auto-generated method stub
		
	}
    
}
