package co.edu.uco.publiuco.data.dao.relational.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.TipoEstadoDAO;
import co.edu.uco.publiuco.entities.TipoEstadoEntity;

public final class TipoEstadoSqlServerDAO implements TipoEstadoDAO{

	public TipoEstadoSqlServerDAO(final Connection connection) {
		//aaa
	}

	@Override
	public List<TipoEstadoEntity> read(TipoEstadoEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
