package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.PerfilDAO;
import co.edu.uco.publiuco.entities.PerfilEntity;

public class PerfilPostgreSqlDAO implements PerfilDAO {
	
	public PerfilPostgreSqlDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(PerfilEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PerfilEntity> read(PerfilEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PerfilEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}