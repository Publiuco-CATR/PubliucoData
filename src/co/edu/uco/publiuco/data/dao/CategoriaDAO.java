package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.CategoriaEntity;

public interface CategoriaDAO {
	
	void create(CategoriaEntity entity);

	List<CategoriaEntity> read(CategoriaEntity entity);

	void update(CategoriaEntity entity);

	void delete(UUID entityId);

}