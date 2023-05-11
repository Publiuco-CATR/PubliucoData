package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.HistorialAccesoPublicacionDAO;
import co.edu.uco.publiuco.entities.HistorialAccesoPublicacionEntity;

public class HistorialAccesoPublicacionPostgreSqlDAO implements HistorialAccesoPublicacionDAO {

	public HistorialAccesoPublicacionPostgreSqlDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(HistorialAccesoPublicacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HistorialAccesoPublicacionEntity> read(HistorialAccesoPublicacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(HistorialAccesoPublicacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}
	
}