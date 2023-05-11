package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.TipoEscritorEntity;

public interface TipoEscritorDAO {
	
	void create(TipoEscritorEntity entity);

	List<TipoEscritorEntity> read(TipoEscritorEntity entity);
	
	void update(TipoEscritorEntity entity);

	void delete(UUID entityId);

}