package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.LectorDAO;
import co.edu.uco.publiuco.entities.LectorEntity;

public class LectorPostgreSqlDAO implements LectorDAO {

	public LectorPostgreSqlDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(LectorEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LectorEntity> read(LectorEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(LectorEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}
	

	
}