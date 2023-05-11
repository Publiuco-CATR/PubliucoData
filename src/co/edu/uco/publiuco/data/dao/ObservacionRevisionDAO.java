package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.ObservacionRevisionEntity;

public interface ObservacionRevisionDAO {
	
	void create(ObservacionRevisionEntity entity);

	List<ObservacionRevisionEntity> read(ObservacionRevisionEntity entity);

	void update(ObservacionRevisionEntity entity);

	void delete(UUID entityId);

}