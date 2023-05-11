package co.edu.uco.publiuco.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.ReporteDAO;
import co.edu.uco.publiuco.entities.ReporteEntity;

public class ReportePostgreSqlDAO implements ReporteDAO{

	public ReportePostgreSqlDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(ReporteEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReporteEntity> read(ReporteEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ReporteEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}

}