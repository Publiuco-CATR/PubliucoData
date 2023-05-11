package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.EscritorPublicacionEntity;

public interface EscritorPublicacionDAO {
	
	void create(EscritorPublicacionEntity entity);

	List<EscritorPublicacionEntity> read(EscritorPublicacionEntity entity);

	void update(EscritorPublicacionEntity entity);

	void delete(UUID entityId);

}