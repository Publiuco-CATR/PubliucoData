package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.EscritorPublicacionDAO;
import co.edu.uco.publiuco.entities.EscritorPublicacionEntity;

public class EscritorPublicacionPostgreSqlDAO implements EscritorPublicacionDAO{

	public EscritorPublicacionPostgreSqlDAO(final Connection connection) {
		
	}

	@Override
	public void create(EscritorPublicacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EscritorPublicacionEntity> read(EscritorPublicacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(EscritorPublicacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}

}