package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.PreferenciaCategoriaEntity;

public interface PreferenciaCategoriaDAO {
	
	void create(PreferenciaCategoriaEntity entity);

	List<PreferenciaCategoriaEntity> read(PreferenciaCategoriaEntity entity);

	void update(PreferenciaCategoriaEntity entity);

	void delete(UUID entityId);

}