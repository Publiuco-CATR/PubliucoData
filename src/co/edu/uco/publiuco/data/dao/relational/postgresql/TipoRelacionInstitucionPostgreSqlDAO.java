package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.TipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.entities.TipoRelacionInstitucionEntity;

public final class TipoRelacionInstitucionPostgreSqlDAO implements TipoRelacionInstitucionDAO {
	
	public TipoRelacionInstitucionPostgreSqlDAO(final Connection connection) {
		
	}

	@Override
	public final void create(final TipoRelacionInstitucionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final List<TipoRelacionInstitucionEntity> read(final TipoRelacionInstitucionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final void update(final TipoRelacionInstitucionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void delete(final UUID entityId) {
		// TODO Auto-generated method stub
		
	}
	
}
