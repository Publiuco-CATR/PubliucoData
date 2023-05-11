package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.PaisEntity;

public interface PaisDAO {
	
	void create(PaisEntity entity);

	List<PaisEntity> read(PaisEntity entity);

	void update(PaisEntity entity);

	void delete(UUID entityId);

}