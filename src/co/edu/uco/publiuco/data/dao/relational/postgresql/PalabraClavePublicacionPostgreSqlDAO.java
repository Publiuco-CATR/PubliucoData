package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.PalabraClavePublicacionDAO;
import co.edu.uco.publiuco.entities.PalabraClavePublicacionEntity;

public class PalabraClavePublicacionPostgreSqlDAO implements PalabraClavePublicacionDAO {

	public PalabraClavePublicacionPostgreSqlDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(PalabraClavePublicacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PalabraClavePublicacionEntity> read(PalabraClavePublicacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PalabraClavePublicacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}