package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.TipoReporteDAO;
import co.edu.uco.publiuco.entities.TipoReporteEntity;

public class TipoReportePostgreSqlDAO implements TipoReporteDAO {

	public TipoReportePostgreSqlDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(TipoReporteEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TipoReporteEntity> read(TipoReporteEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TipoReporteEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}

}