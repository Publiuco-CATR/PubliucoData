package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.TipoEstadoEntity;

public interface TipoEstadoDAO {
	
	void create(TipoEstadoEntity entity);

	List<TipoEstadoEntity> read(TipoEstadoEntity entity);
	
	void update(TipoEstadoEntity entity);

	void delete(UUID entityId);

}
