package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.PlanPublicacionDAO;
import co.edu.uco.publiuco.entities.PlanPublicacionEntity;

public class PlanPublicacionPostgreSqlDAO implements PlanPublicacionDAO {

	public PlanPublicacionPostgreSqlDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(PlanPublicacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PlanPublicacionEntity> read(PlanPublicacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PlanPublicacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}
	


}