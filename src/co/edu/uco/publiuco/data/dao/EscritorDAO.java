package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.EscritorEntity;

public interface EscritorDAO {
	
	void create(EscritorEntity entity);

	List<EscritorEntity> read(EscritorEntity entity);

	void update(EscritorEntity entity);

	void delete(UUID entityId);

}