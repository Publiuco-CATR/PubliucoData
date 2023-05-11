package co.edu.uco.publiuco.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.TipoEscritorDAO;
import co.edu.uco.publiuco.entities.TipoEscritorEntity;

public class TipoEscritorSqlServerDAO implements TipoEscritorDAO {

	public TipoEscritorSqlServerDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(TipoEscritorEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TipoEscritorEntity> read(TipoEscritorEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TipoEscritorEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}

}