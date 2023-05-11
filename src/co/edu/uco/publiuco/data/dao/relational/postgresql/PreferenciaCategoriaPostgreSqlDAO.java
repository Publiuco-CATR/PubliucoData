package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.PreferenciaCategoriaDAO;
import co.edu.uco.publiuco.entities.PreferenciaCategoriaEntity;

public class PreferenciaCategoriaPostgreSqlDAO implements PreferenciaCategoriaDAO {

	public PreferenciaCategoriaPostgreSqlDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(PreferenciaCategoriaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PreferenciaCategoriaEntity> read(PreferenciaCategoriaEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PreferenciaCategoriaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}

}