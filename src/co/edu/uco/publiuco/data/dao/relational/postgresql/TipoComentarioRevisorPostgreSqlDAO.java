package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.TipoComentarioRevisorDAO;
import co.edu.uco.publiuco.entities.TipoComentarioRevisorEntity;

public class TipoComentarioRevisorPostgreSqlDAO implements TipoComentarioRevisorDAO {
	
	public TipoComentarioRevisorPostgreSqlDAO(final Connection connection) {
		
	}

	@Override
	public void create(TipoComentarioRevisorEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TipoComentarioRevisorEntity> read(TipoComentarioRevisorEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TipoComentarioRevisorEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}
}