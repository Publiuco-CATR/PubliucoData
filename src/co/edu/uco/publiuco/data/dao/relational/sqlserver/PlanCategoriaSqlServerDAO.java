package co.edu.uco.publiuco.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.PlanCategoriaDAO;
import co.edu.uco.publiuco.entities.PlanCategoriaEntity;

public class PlanCategoriaSqlServerDAO implements PlanCategoriaDAO {

	public PlanCategoriaSqlServerDAO(final Connection connection) {
		
	}

	@Override
	public void create(PlanCategoriaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PlanCategoriaEntity> read(PlanCategoriaEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PlanCategoriaEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}
	
}