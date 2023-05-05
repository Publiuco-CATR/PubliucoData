package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.publiuco.data.dao.PaisDAO;
import co.edu.uco.publiuco.entities.PaisEntity;

public class PaisPostgreSqlDAO implements PaisDAO  {
	
	public PaisPostgreSqlDAO(final Connection connection) {
		
	}

	@Override
	public void create(PaisEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PaisEntity> read(PaisEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PaisEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PaisEntity entity) {
		// TODO Auto-generated method stub
		
	}
	
	

}