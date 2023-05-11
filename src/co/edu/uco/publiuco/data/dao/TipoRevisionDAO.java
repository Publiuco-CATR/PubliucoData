package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.TipoRevisionEntity;

public interface TipoRevisionDAO {
	
	void create(TipoRevisionEntity entity);

	List<TipoRevisionEntity> read(TipoRevisionEntity entity);
	
	void update(TipoRevisionEntity entity);

	void delete(UUID entityId);

}