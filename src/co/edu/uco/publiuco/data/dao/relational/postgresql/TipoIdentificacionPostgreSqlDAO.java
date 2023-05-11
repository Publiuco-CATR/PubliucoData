
package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.TipoIdentificacionDAO;
import co.edu.uco.publiuco.entities.TipoIdentificacionEntity;

public class TipoIdentificacionPostgreSqlDAO implements TipoIdentificacionDAO {
	
	public TipoIdentificacionPostgreSqlDAO(final Connection connection) {
		
	}

	@Override
	public void create(TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TipoIdentificacionEntity> read(TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}
}