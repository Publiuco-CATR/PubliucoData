package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.TipoEscritorDAO;
import co.edu.uco.publiuco.entities.TipoEscritorEntity;

public class TipoEscritorPostgreSqlDAO implements TipoEscritorDAO {

	public TipoEscritorPostgreSqlDAO(final Connection connection) {
		
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