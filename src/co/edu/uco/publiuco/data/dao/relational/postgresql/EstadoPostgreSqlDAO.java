package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.publiuco.data.dao.EstadoDAO;
import co.edu.uco.publiuco.entities.EstadoEntity;
//import co.edu.uco.publiuco.

public final class EstadoPostgreSqlDAO implements EstadoDAO{
	
	public EstadoPostgreSqlDAO(final Connection connection) {
		
	}

	@Override
	public void create(final EstadoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final List<EstadoEntity> read(final EstadoEntity entity) {
		//final EstadoEntity entity = EstadoAss
		return null;
	}

	@Override
	public final void update(final EstadoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void delete(final EstadoEntity entity) {
		// TODO Auto-generated method stub
		
	}

}
