package co.edu.uco.publiuco.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.CategoriaAdministradorCategoriaDAO;
import co.edu.uco.publiuco.entities.CategoriaAdministradorCategoriaEntity;

public class CategoriaAdministradorCategoriaSqlServerDAO implements CategoriaAdministradorCategoriaDAO {

	public CategoriaAdministradorCategoriaSqlServerDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(CategoriaAdministradorCategoriaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoriaAdministradorCategoriaEntity> read(CategoriaAdministradorCategoriaEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CategoriaAdministradorCategoriaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}
	
}