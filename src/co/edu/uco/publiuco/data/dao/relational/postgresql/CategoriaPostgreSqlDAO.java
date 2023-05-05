package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.publiuco.data.dao.CategoriaDAO;
import co.edu.uco.publiuco.entities.CategoriaEntity;

public class CategoriaPostgreSqlDAO implements CategoriaDAO {

	public CategoriaPostgreSqlDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(CategoriaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoriaEntity> read(CategoriaEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CategoriaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CategoriaEntity entity) {
		// TODO Auto-generated method stub
		
	}
	
}