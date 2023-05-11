package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.RespuestaDAO;
import co.edu.uco.publiuco.entities.RespuestaEntity;

public class RespuestaPostgreSqlDAO implements RespuestaDAO {

	public RespuestaPostgreSqlDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(RespuestaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RespuestaEntity> read(RespuestaEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(RespuestaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}
	
}
