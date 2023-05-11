package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.TipoEstadoDAO;
import co.edu.uco.publiuco.entities.TipoEstadoEntity;

public class TipoEstadoPostreSqlDAO implements TipoEstadoDAO{
	
	public TipoEstadoPostreSqlDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(TipoEstadoEntity entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<TipoEstadoEntity> read(TipoEstadoEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void update(TipoEstadoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityid) {
		// TODO Auto-generated method stub
		
	}


}
