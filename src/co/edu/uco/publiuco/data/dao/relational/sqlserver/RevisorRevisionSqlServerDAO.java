package co.edu.uco.publiuco.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.RevisorRevisionDAO;
import co.edu.uco.publiuco.entities.RevisorRevisionEntity;

public class RevisorRevisionSqlServerDAO implements RevisorRevisionDAO {

	public RevisorRevisionSqlServerDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(RevisorRevisionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RevisorRevisionEntity> read(RevisorRevisionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(RevisorRevisionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}

}